package pl.marek;

public class KanalRadiowy implements Obserwator {

    public KanalRadiowy(Zdarzenie zdarzenie) {
        zdarzenie.subskrybuj(this);
    }

    @Override
    public void aktualizacja(Wiadomosc wiadomosc) {
        System.out.printf("Wiadomosc : %s : dostarczona przez : %s %n", wiadomosc.getTresc(), this.getClass().getSimpleName());
    }
}
