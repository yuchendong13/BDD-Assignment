package A4.G2.model.users;

import A4.G2.model.artwork.Art;

import java.util.UUID;

public class Artist {
    private String name;
    private Art[] arts;
    private String id;

    public Artist() {
        this.id = UUID.randomUUID().toString();
    }
    public String getArtistName() {
        return this.name;
    }
    public void setArtistName(String name) {
        this.name = name;
    }

    public String getArtistId() {
        return this.id;
    }
}
