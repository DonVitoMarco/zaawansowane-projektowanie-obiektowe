package pl.marek;

public class KanalTelewizyjny implements Obserwator {

    public KanalTelewizyjny(Zdarzenie zdarzenie) {
        zdarzenie.subskrybuj(this);
    }

    @Override
    public void aktualizacja(Wiadomosc wiadomosc) {
        System.out.printf("Wiadomosc : %s : dostarczona przez : %s %n", wiadomosc.getTresc(), this.getClass().getSimpleName());
    }
}
