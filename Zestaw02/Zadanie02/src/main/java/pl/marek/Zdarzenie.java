package pl.marek;

import java.util.ArrayList;

public class Zdarzenie {

    private ArrayList<Obserwator> obserwatorzy;

    public Zdarzenie() {
        this.obserwatorzy = new ArrayList<>();
    }

    public void subskrybuj(Obserwator obserwator) {
        obserwatorzy.add(obserwator);
    }

    public void aktualizacjaWiadomosci(Wiadomosc wiadomosc) {
        for (Obserwator o : obserwatorzy) {
            o.aktualizacja(wiadomosc);
        }
    }
}
