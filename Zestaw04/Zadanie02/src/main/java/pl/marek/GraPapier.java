package pl.marek;

import java.util.Random;

import static pl.marek.GraPapier.ElementGry.*;

public class GraPapier extends Gra {

    private Random random = new Random();
    private String nazwaGracza1;
    private String nazwaGracza2;
    private String nazwaZwyciezcy;
    private ElementGry wyborGracza1;
    private ElementGry wyborGracza2;

    @Override
    public void ustawGre() {
        System.out.println("Gra papier, kamien, nozyce - ustawianie gry");
        nazwaGracza1 = "Gracz1";
        nazwaGracza2 = "Gracz2";
    }

    @Override
    public void rozegrajGre() {
        System.out.println("Gra papier, kamien, nozyce - rozegraj gre");
        wyborGracza1 = wybierzElement(random.nextInt(3));
        wyborGracza2 = wybierzElement(random.nextInt(3));
        System.out.println("Gracz1: " + wyborGracza1);
        System.out.println("Gracz2: " + wyborGracza2);
    }

    @Override
    public void zakonczGre() {
        System.out.println("Gra papier, kamien, nozyce - zakoncz gre");
        if (wyborGracza1 == wyborGracza2) {
            nazwaZwyciezcy = "brak";
        } else if ((Kamien.equals(wyborGracza1) && Nozyce.equals(wyborGracza2)) ||
                (Nozyce.equals(wyborGracza1) && Papier.equals(wyborGracza2)) ||
                (Papier.equals(wyborGracza1) && Kamien.equals(wyborGracza2))) {
            nazwaZwyciezcy = nazwaGracza1;
        } else if ((Kamien.equals(wyborGracza2) && Nozyce.equals(wyborGracza1)) ||
                (Nozyce.equals(wyborGracza2) && Papier.equals(wyborGracza1)) ||
                (Papier.equals(wyborGracza2) && Kamien.equals(wyborGracza1))) {
            nazwaZwyciezcy = nazwaGracza2;
        }
    }

    @Override
    public void wyswietlZwyciezce() {
        System.out.println("Zwyciezca: " + nazwaZwyciezcy);
    }

    public ElementGry wybierzElement(int number) {
        if (number == 0) {
            return Papier;
        } else if (number == 1) {
            return Kamien;
        } else {
            return Nozyce;
        }
    }

    enum ElementGry {
        Papier, Kamien, Nozyce;
    }
}
