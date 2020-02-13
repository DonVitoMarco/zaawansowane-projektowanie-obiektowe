package pl.marek;

import java.util.Date;

public class Start {

    public static void main(String[] args) {
        Koszyk koszyk1 = new Koszyk();
        koszyk1.dodajProdukt(new Produkt("Ryzen 2700X", 1500, 1));
        koszyk1.dodajProdukt(new Produkt("DDR4 8GB", 300, 2));
        System.out.println("Koszt calkowity koszyka: " + koszyk1.getKosztCalkowity());

        Platnosc platnosc = new KartaKredytowa("Przelew", "do sklepu za pc", koszyk1.getKosztCalkowity(), "124151512412", new Date());

        ModulSprzedazy modulSprzedazy1 = new ModulSprzedazy(koszyk1, platnosc);
        modulSprzedazy1.generujPotwierdzeniePlatnosci();
        modulSprzedazy1.generujPotwierdzenieZamowienia();

        Koszyk koszyk2 = new Koszyk();
        koszyk2.dodajProdukt(new Produkt("GeForce RTX270", 2900, 1));
        System.out.println("Koszt calkowity koszyka: " + koszyk2.getKosztCalkowity());

        Platnosc platnosc2 = new KartaKredytowa("Przelew", "do sklepu za pc", koszyk2.getKosztCalkowity(), "124151512412", new Date());

        ModulSprzedazy modulSprzedazy2 = new ModulSprzedazy(koszyk2, platnosc2);
        modulSprzedazy2.generujPotwierdzeniePlatnosci();
        modulSprzedazy2.generujPotwierdzenieZamowienia();
    }
}
