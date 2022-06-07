package A4.G2.controller;

import A4.G2.model.artwork.Art;
import A4.G2.model.artwork.Painting;
import A4.G2.model.artwork.Print;
import A4.G2.model.artwork.Sculpture;
import A4.G2.model.sale.Auction;
import A4.G2.model.sale.BuyNow;
import A4.G2.model.sale.Sale;
import A4.G2.model.users.Artist;
import A4.G2.service.FilterArtService;
import A4.G2.service.Gallery;
import A4.G2.service.IFilterArtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.Objects;


@Controller
@SessionAttributes("name")
public class ArtGalleryController {

    @Autowired
    Gallery gallery;

    @RequestMapping(value = "/art-gallery", method = RequestMethod.GET)
    public ModelAndView showArts(ModelMap model) throws IOException {
        //add an artwork to gallery
        gallery.initiate();

        List<Art> arts = gallery.getArtList();
        ModelAndView map = new ModelAndView("/art-gallery");
        map.addObject("lists", arts);

        List<Sale> sales = gallery.getArtSalesList();
        map.addObject("saleLists", sales);

        map.addObject("imageLists", arts);

        return map;
    }

    @RequestMapping(value = "/art-gallery/sale-type", method = RequestMethod.POST)
    public String filterBySaleType(ModelMap model, @RequestParam String saleTypeOption) throws IOException {
        gallery.initiate();

        List<Sale> sales = gallery.getArtSalesList();
        IFilterArtService filterArtService = new FilterArtService();

        if (saleTypeOption.equals("Buy now")) {
            List<Sale> buyNowList = filterArtService.getBuyNowItems(sales);
            model.put("saleType", "Buy now");
            model.put("saleList", buyNowList);
            return "sale-type";
        } else if (saleTypeOption.equals("Auction")) {
            List<Sale> auctionList = filterArtService.getAuctionItems(sales);
            model.put("saleType", "Auction");
            model.put("saleList", auctionList);
            return "sale-type";
        }

        return "art-gallery";
    }

    @RequestMapping(value = "/art-gallery/sale-type", method = RequestMethod.GET)
    public String artBySaleTypePage(ModelMap model) throws IOException {
        return "sale-type";
    }

    @RequestMapping(value = "/art-gallery/art-type", method = RequestMethod.POST)
    public String filterByArtType(ModelMap model, @RequestParam String artTypeOption) throws IOException {
        gallery.initiate();

        List<Art> arts = gallery.getArtList();
        IFilterArtService filterArtService = new FilterArtService();

        if (artTypeOption.equals("Painting")) {
            List<Art> paintingList = filterArtService.getArtPiecesByArtType(arts, "painting");
            model.put("artType", "Painting");
            model.put("artList", paintingList);
            return "art-type";
        } else if (artTypeOption.equals("Print")) {
            List<Art> printList = filterArtService.getArtPiecesByArtType(arts, "print");
            model.put("artType", "Print");
            model.put("artList", printList);
            return "art-type";
        } else if (artTypeOption.equals("Sculpture")) {
            List<Art> sculptureList = filterArtService.getArtPiecesByArtType(arts, "sculpture");
            model.put("artType", "Sculpture");
            model.put("artList", sculptureList);
            return "art-type";
        }

        return "art-gallery";
    }

    @RequestMapping(value = "/art-gallery/art-type", method = RequestMethod.GET)
    public String artByArtTypePage(ModelMap model) throws IOException {
        return "art-type";
    }

    @RequestMapping(value = "/art-gallery/sale-type/price", method = RequestMethod.POST)
    public String filterByPriceRange(ModelMap model, @RequestParam String min, @RequestParam String max) throws IOException {
        gallery.initiate();

        List<Sale> sales = gallery.getArtSalesList();
        IFilterArtService filterArtService = new FilterArtService();

        if (min.length() < 1 || min.matches("[a-zA-Z]+")) {
            min = "0.0";
        }
        if (max.length() < 1 || max.matches("[a-zA-Z]+")) {
            max = "1000.0";
        }

        double minPrice = Double.valueOf(min);
        if (Double.compare(minPrice, 0.0) < 0) {
            minPrice = 0.0;
        }
        double maxPrice = Double.valueOf(max);
        if (Double.compare(maxPrice, 1000.0) > 0) {
            maxPrice = 1000.0;
        }

        List<Sale> inRangeList = filterArtService.getPriceBetween(sales, minPrice, maxPrice);
        model.put("saleList", inRangeList);
        return "price";

    }

    @RequestMapping(value = "/art-gallery/sale-type/price", method = RequestMethod.GET)
    public String artByPriceRange(ModelMap model) throws IOException {
        return "price";
    }

    @RequestMapping(value = "/art-gallery/sale-type/time", method = RequestMethod.POST)
    public String filterByTimeRange(ModelMap model, @RequestParam String timeTypeOption, @RequestParam String hour,
                                    @RequestParam String minute) throws IOException {
        gallery.initiate();

        List<Sale> sales = gallery.getArtSalesList();
        IFilterArtService filterArtService = new FilterArtService();

        if (hour.length() < 1 || hour.matches("[a-zA-Z]+")) {
            hour = "24";
        }
        if (minute.length() < 1 || minute.matches("[a-zA-Z]+")) {
            minute = "0";
        }

        int intHour = Integer.valueOf(hour);
        if (intHour < 0) {
            intHour = 24;
        }
        int intMinute = Integer.valueOf(minute);
        if (intMinute < 0) {
            intMinute = 0;
        }

        int seconds = ((intHour * 60) + intMinute) * 60;

        if (timeTypeOption.equals("Lower")) {
            List<Sale> inRangeList = filterArtService.filterAuctionItemsUnderTime(sales, seconds);
            model.put("saleList", inRangeList);
        } else {
            List<Sale> inRangeList = filterArtService.filterAuctionItemsOverTime(sales, seconds);
            model.put("saleList", inRangeList);
        }

        return "time";
    }

    @RequestMapping(value = "/art-gallery/sale-type/time", method = RequestMethod.GET)
    public String artByTimeRange(ModelMap model) throws IOException {
        return "time";
    }

    /**
     * Test endpoint to add art pieces to gallery.
     */
    @RequestMapping(value = "/art-gallery/populate-testing", method = RequestMethod.GET)
    public String populateArtGalleryForTesting() throws IOException {
        gallery.initiate();
        gallery.galleryReinitiate();

        Artist artist = new Artist();
        Image image = new BufferedImage(7, 7, 7);

        Art painting1 = new Painting(artist, "Art 4", "Desc...", image, "40x60");
        Art painting2 = new Painting(artist, "Art 5", "Desc...", image, "40x60");

        Art print1 = new Print(artist, "Art 6", "Desc...", image, "40x60");
        Art print2 = new Print(artist, "Art 7", "Desc...", image, "40x60");

        Art sculpture1 = new Sculpture(artist, "Art 8", "Desc...", image, "40x60");
        Art sculpture2 = new Sculpture(artist, "Art 9", "Desc...", image, "40x60");

        Sale sale1 = new BuyNow("3", 10, painting1);
        Sale sale2 = new BuyNow("4",150, sculpture1);
        Sale sale3 = new BuyNow("5", 250, print1);

        Sale sale4 = new Auction("6", 10, painting2, 25.00, 3000);
        Sale sale5 = new Auction("7", 10, print2, 25.00, 4000);
        Sale sale6 = new Auction("8", 10, sculpture2, 25.00, 8000);

        gallery.addArt(painting1);
        gallery.addArt(painting2);
        gallery.addArt(print1);
        gallery.addArt(print2);
        gallery.addArt(sculpture1);
        gallery.addArt(sculpture2);

        gallery.addArtForSale(sale1);
        gallery.addArtForSale(sale2);
        gallery.addArtForSale(sale3);
        gallery.addArtForSale(sale4);
        gallery.addArtForSale(sale5);
        gallery.addArtForSale(sale6);

        return "populate";
    }
}
