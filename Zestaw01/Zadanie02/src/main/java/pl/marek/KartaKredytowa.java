package pl.marek;

import java.util.Date;

public class KartaKredytowa extends Platnosc {

    private String numerKarty;
    private Date waznosc;

    public KartaKredytowa(String tytul, String opis, double kwota, String numerKarty, Date waznosc) {
        super(tytul, opis, kwota);
        this.numerKarty = numerKarty;
        this.waznosc = waznosc;
    }

    public String getNumerKarty() {
        return numerKarty;
    }

    public Date getWaznosc() {
        return waznosc;
    }
}
