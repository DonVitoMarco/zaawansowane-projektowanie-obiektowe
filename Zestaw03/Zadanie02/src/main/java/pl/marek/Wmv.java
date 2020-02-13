package pl.marek;

public class Wmv implements ZaawansowanyOdtwarzaczMuzyki {

    @Override
    public void grajMP4(String path) {
       // do nothing
    }

    @Override
    public void grajWMV(String path) {
        System.out.printf("Gra - WMV plik - %s!%n", path);
    }
}
