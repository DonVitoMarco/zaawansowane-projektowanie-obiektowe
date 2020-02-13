package pl.marek;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ObserwowanaWiadomosc {

    private Zdarzenie zdarzenie;
    private List<Wiadomosc> wiadomosci;

    public ObserwowanaWiadomosc(Zdarzenie zdarzenie) {
        this.zdarzenie = zdarzenie;
        this.wiadomosci = new ArrayList<>();
    }

    public void dodajWiadomosc(String zawartosc) {
        Wiadomosc wiadomosc = new Wiadomosc(Instant.now(), zawartosc);
        wiadomosci.add(wiadomosc);
        zdarzenie.aktualizacjaWiadomosci(wiadomosc);
    }
}
