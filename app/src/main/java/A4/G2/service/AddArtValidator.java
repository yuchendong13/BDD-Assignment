package A4.G2.service;

import java.nio.file.Files;
import java.nio.file.Path;

public class AddArtValidator {
    public boolean validateArtInputs(String title, String descriptions, String artType, String dimensions, String artist, String image) {
        if (title.isEmpty() || descriptions.isEmpty() || artType.isEmpty() || dimensions.isEmpty() || artist.isEmpty() || image.isEmpty()) {
            return false;
        } else return Files.exists(Path.of("src/main/images/" + image));
    }

    public boolean validateArtBuyNowInputs(String price) {

        try {
            double d = Double.parseDouble(price);
            return (d > 0);
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    public boolean validateArtAuctionInputs(String startPrice, String reservePrice, String timeRemaining) {

        try {
            double d = Double.parseDouble(startPrice);
            double dd = Double.parseDouble(reservePrice);
            double ddd = Double.parseDouble(timeRemaining);

            return (d > 0 && dd > 0 && ddd > 0);
        } catch (NumberFormatException nfe) {
            return false;
        }
    }
}
