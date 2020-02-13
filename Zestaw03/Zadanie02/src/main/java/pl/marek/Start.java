package pl.marek;

public class Start {

    public static void main(String[] args) {
        OdtwarzaczMuzyki odtwarzaczMuzyki = new OdtwarzaczMuzykiImpl();

        odtwarzaczMuzyki.graj("mp3", "super.mp3");
        odtwarzaczMuzyki.graj("mp4", "extra.mp4");
        odtwarzaczMuzyki.graj("wmv", "extra.wmv");
    }
}
