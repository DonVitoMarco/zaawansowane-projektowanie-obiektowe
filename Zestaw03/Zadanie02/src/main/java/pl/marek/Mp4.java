package pl.marek;

public class Mp4 implements ZaawansowanyOdtwarzaczMuzyki {

    @Override
    public void grajMP4(String path) {
        System.out.printf("Gra - MP4 plik - %s!%n", path);
    }

    @Override
    public void grajWMV(String path) {
        // do nothing
    }
}
