package A4.G2.controller;

import A4.G2.model.artwork.Art;
import A4.G2.model.sale.Auction;
import A4.G2.model.sale.BuyNow;
import A4.G2.service.AddArtValidator;
import A4.G2.service.Gallery;
import A4.G2.model.artwork.Painting;
import A4.G2.model.artwork.Print;
import A4.G2.model.artwork.Sculpture;
import A4.G2.model.users.Artist;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@SessionAttributes("name")
public class AddArtController {

    @Autowired
    Gallery gallery;

    @RequestMapping(value = "/add-art", method = RequestMethod.GET)
    public String showAddArtPage(ModelMap model) {
        return "add-art";
    }

    @RequestMapping(value = "/add-art", method = RequestMethod.POST)
    public String showSuccessAddArtPage(
            ModelMap model,
            @RequestParam String title,
            @RequestParam String description,
            @RequestParam String dimensions,
            @RequestParam String artType,
            @RequestParam String artistName,
            @RequestParam String fileOfImage,
            @RequestParam String buyNowPrice,
            @RequestParam String auctionStartPrice,
            @RequestParam String auctionReservePrice,
            @RequestParam String auctionTimeRemaining
    ) throws IOException {

        AddArtValidator av = new AddArtValidator();
        if(!av.validateArtInputs(title,description,artType,dimensions,artistName,fileOfImage)){
            model.put("errorMessage","Invalid inputs try again");
            return "add-art";
        } else if(!buyNowPrice.isEmpty() && !av.validateArtBuyNowInputs(buyNowPrice)){
            model.put("errorMessage","Invalid inputs try again");
            return "add-art";
        } else if(!auctionStartPrice.isEmpty() && !av.validateArtAuctionInputs(auctionStartPrice,auctionReservePrice,auctionTimeRemaining)){
            model.put("errorMessage","Invalid inputs try again");
            return "add-art";
        }

        Image image;
        image = ImageIO.read(new File("src/main/images/" + fileOfImage));

        Artist artist = new Artist();
        artist.setArtistName(artistName);

        Art newArt = null;

        if (artType.equals("0")) {
            newArt = new Painting(artist, title, description, image, dimensions);
        } else if(artType.equals("1")) {
            newArt = new Print(artist, title, description, image, dimensions);
        } else if (artType.equals("2")) {
            newArt = new Sculpture(artist, title, description, image, dimensions);
        }

        gallery.addArt(newArt);

        String message = null;
        if (!buyNowPrice.isEmpty()) {
            BuyNow buyNow = new BuyNow(UUID.randomUUID().toString(), Double.parseDouble(buyNowPrice), newArt);
            gallery.addArtForSale(buyNow);
            message = String.format("Art titled: \"%s\" successfully added with buy-now listing", title);
        } else if (!auctionStartPrice.isEmpty() && !auctionReservePrice.isEmpty() && !auctionTimeRemaining.isEmpty()) {
            Auction auction = new Auction(
                    UUID.randomUUID().toString(),
                    Double.parseDouble(auctionStartPrice),
                    newArt, Double.parseDouble(auctionReservePrice),
                    Integer.parseInt(auctionTimeRemaining)
            );
            gallery.addArtForSale(auction);
            message = String.format("Art titled: \"%s\" successfully added with auction listing", title);
        } else {
            message = String.format("Art titled: \"%s\" successfully added", title);
        }
        model.put("message", message);
        return "add-art";
    }

}
