package A4.G2.service;

import A4.G2.model.Payment;
import A4.G2.model.artwork.Art;
import A4.G2.model.artwork.Painting;
import A4.G2.model.artwork.Print;
import A4.G2.model.artwork.Sculpture;
import A4.G2.model.sale.Auction;
import A4.G2.model.sale.BuyNow;
import A4.G2.model.sale.Sale;
import A4.G2.model.users.Artist;
import A4.G2.model.users.ShippingDetails;
import A4.G2.model.users.User;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class Gallery {
    private final List<Art> arts = new ArrayList<>();
    private final List<Sale> artsForSale = new ArrayList<>();
    private List<User> users = new ArrayList<>();
    private String termsAndConditions = "";

    private Boolean isInitiated = false;

    public Gallery() {

    }

    public void addArt(Art art) {
        arts.add(art);
    }

    public void removeArt(Art art) {
        arts.remove(art);
    }

    public List<Art> getArtList() {
        return arts;
    }

    public void addArtForSale(Sale sale) {
        artsForSale.add(sale);
    }

    public void addUser(User newUser) {
        users.add(newUser);
    }

    public void removeArtForSale(Sale sale) {
        artsForSale.remove(sale);
    }

    public List<Sale> getArtSalesList() {
        return artsForSale;
    }

    public String getTermsAndConditions() {
        return termsAndConditions;
    }

    public List<User> getUserList() {
        return users;
    }

    public void setTermsAndConditions(String termsAndConditions) {
        this.termsAndConditions = termsAndConditions;
    }


    public void initiate() throws IOException {
        if (!this.isInitiated) {
            Artist artist = new Artist();
            artist.setArtistName("Frank");
            Image image = ImageIO.read(new File("src/main/images/testImage.png"));
            Painting initialArt = new Painting(artist, "Title", "Description", image, "2x1m");
            initialArt.setId("1");
            addArt(initialArt);

            addArt(new Painting(artist, "Art 1", "", image, ""));
            addArt(new Print(artist, "Art 2", "", image, ""));
            addArt(new Sculpture(artist, "Art 3", "", image, ""));

            addArtForSale(new Auction("1",1.0,
                    new Painting(artist,"Art 1","",image,""),
                    1.0,1));
            addArtForSale(new BuyNow("2",2.0,
                    new Print(artist,"Art 2","",image,"")));

            //Initialisation for login and signup testing
            User user1 = new User("user1", "Password123", "user1@gmail.com", "4737054",
                    "7 Parkers Ave, Mexico", new Date(1990, 6, 3));
            addUser(user1);
            setTermsAndConditions("I agree to abide by the rules of copyright and not sell duplicate prints" +
                    " of arts listed on this application");

            //Initialisation for manage account testing
            ShippingDetails shippingDetails = new ShippingDetails("90, Farmer Street, Beach Villa",
                    "Delivery after 5pm");
            Payment payment = new Payment("1234432156788765", "Pablo Manolas", "12/24", "234");

            user1.setShippingDetails(shippingDetails);
            user1.modifyPayment(payment);
            this.isInitiated = true;
        }

    }

    public void galleryReinitiate() throws IOException {
        this.isInitiated = false;
        galleryReset();
        initiate();
    }

    public void galleryReset() {
        arts.removeAll(arts);
        artsForSale.removeAll(artsForSale);
        users.removeAll(users);
        termsAndConditions = "";
    }
}
