package pl.marek;

public class TwitterReporter implements ISocialMediaReporter {

    private static final String NAZWA = "Twitter";

    @Override
    public String getNazwa() {
        return NAZWA;
    }

    @Override
    public void raportuj(String wiadomosc) {
        System.out.printf("%s : zaraportowana do : %s %n", wiadomosc, NAZWA);
    }
}
