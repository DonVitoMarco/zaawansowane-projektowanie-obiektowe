package pl.marek;

import java.util.Date;

public class KartaKredytowa extends Platnosc {

    private String numerKarty;
    private Date waznosc;
    private double balance = 2500;

    public KartaKredytowa(String tytul, String opis, double kwota, String numerKarty, Date waznosc) {
        super(tytul, opis, kwota);
        this.numerKarty = numerKarty;
        this.waznosc = waznosc;
    }

    private void validate() throws NiewystarczajacaIloscSrodkow {
        if (super.getKwota() > balance) {
            throw new NiewystarczajacaIloscSrodkow();
        }
    }

    @Override
    public void zarejstrujPlatnosc() {
        try {
            validate();
            super.zarejstrujPlatnosc();
        } catch (NiewystarczajacaIloscSrodkow e) {
            System.out.println("Masz niewystarczajaca ilosc srodkow do realizacji zamowienia");
        }
    }

    public String getNumerKarty() {
        return numerKarty;
    }

    public Date getWaznosc() {
        return waznosc;
    }
}
