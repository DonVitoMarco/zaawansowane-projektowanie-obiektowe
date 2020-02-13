package pl.marek;

import java.util.Random;

public class GraNumery extends Gra {

    private Random random = new Random();
    private String nazwaGracza1;
    private String nazwaGracza2;
    private String nazwaZwyciezcy;
    private int numerGracza1;
    private int numerGracza2;

    @Override
    public void ustawGre() {
        System.out.println("Gra numery - ustawianie gry");
        nazwaGracza1 = "Gracz1";
        nazwaGracza2 = "Gracz2";
    }

    @Override
    public void rozegrajGre() {
        System.out.println("Gra numery - rozegraj gre");
        numerGracza1 = random.nextInt(100);
        numerGracza2 = random.nextInt(100);
        System.out.println("Gracz1: " + numerGracza1);
        System.out.println("Gracz2: " + numerGracza2);
    }

    @Override
    public void zakonczGre() {
        System.out.println("Gra numery - zakoncz gre");
        if (numerGracza1 > numerGracza2) {
            nazwaZwyciezcy = nazwaGracza1;
        } else if (numerGracza2 > numerGracza1) {
            nazwaZwyciezcy = nazwaGracza2;
        } else {
            nazwaZwyciezcy = "brak";
        }
    }

    @Override
    public void wyswietlZwyciezce() {
        System.out.println("Zwyciezca: " + nazwaZwyciezcy);
    }
}
