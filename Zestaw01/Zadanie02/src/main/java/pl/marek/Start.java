package pl.marek;

import java.util.Date;

public class Start {

    public static void main(String[] args) {
        Koszyk koszyk = new Koszyk();
        koszyk.dodajProdukt(new Produkt("Ryzen 2700X", 1500, 1));
        koszyk.dodajProdukt(new Produkt("DDR4 8GB", 300, 2));
        System.out.println("Koszt calkowity koszyka: " + koszyk.getKosztCalkowity());

        Platnosc platnosc = new KartaKredytowa("Przelew", "do sklepu za pc", koszyk.getKosztCalkowity(), "124151512412", new Date());

        ModulSprzedazy modulSprzedazy = new ModulSprzedazy(koszyk, platnosc);
        modulSprzedazy.generujPotwierdzeniePlatnosci();
        modulSprzedazy.generujPotwierdzenieZamowienia();
    }
}
