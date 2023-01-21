package br.com.cod3r.flyweight.musicFlyweight;

public class MusicFlyweight {
    private String name;
    private String artist;
    private Integer durationInSeconds;

    public MusicFlyweight(String name, String artist, Integer durationInSeconds) {
        this.name = name;
        this.artist = artist;
        this.durationInSeconds = durationInSeconds;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public Integer getDurationInSeconds() {
        return durationInSeconds;
    }

    public void setDurationInSeconds(Integer durationInMiliseconds) {
        this.durationInSeconds = durationInMiliseconds;
    }

    @Override
    public String toString() {
        return "MusicFlyweight{" +
                "name='" + name + '\'' +
                ", artist='" + artist + '\'' +
                ", durationInMilisecounds=" + durationInSeconds +
                '}';
    }
}
