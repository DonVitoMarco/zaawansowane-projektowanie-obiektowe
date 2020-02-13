package pl.marek;

import java.time.Instant;

public class Wiadomosc {

    private Instant data;
    private String tresc;

    public Wiadomosc(Instant data, String tresc) {
        this.data = data;
        this.tresc = tresc;
    }

    public Instant getData() {
        return data;
    }

    public String getTresc() {
        return tresc;
    }
}
