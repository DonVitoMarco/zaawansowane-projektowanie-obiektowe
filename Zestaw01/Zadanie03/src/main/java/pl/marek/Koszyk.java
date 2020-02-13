package pl.marek;

import java.util.ArrayList;
import java.util.List;

public class Koszyk {

    private double kosztCalkowity;
    private List<Produkt> produkty;

    public Koszyk() {
        this.produkty = new ArrayList<Produkt>();
        this.kosztCalkowity = 0;
    }

    public void dodajProdukt(Produkt produkt) {
        produkty.add(produkt);
        przeliczKoszyk();
    }

    public double getKosztCalkowity() {
        return kosztCalkowity;
    }

    private void przeliczKoszyk() {
        double koszt = 0;
        for (Produkt p : produkty) {
            koszt += p.getCena() * p.getIlosc();
        }
        this.kosztCalkowity = koszt;
    }
}
