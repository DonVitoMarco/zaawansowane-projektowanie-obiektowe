package pl.marek;

public class Start {

    public static void main(String[] args) {
        Adres odbiorca = new Adres("Odbiorca", "Pogodna", "Gdynia", "11-223");
        Adres nadawca = new Adres("Nadawca", "Zytnia", "Gliwice", "22-343");

        Zamowienie zamowienie1 = new Zamowienie(odbiorca, nadawca, 20.00, RodzajTransportu.UPS);
        Double kosztZamowienia1 = new KalkulatorZamowien(zamowienie1, new UPSWysylka()).oblicz();
        System.out.println("Zamowienie 1 : " + kosztZamowienia1);

        Zamowienie zamowienie2 = new Zamowienie(odbiorca, nadawca, 50.00, RodzajTransportu.GLS);
        Double kosztZamowienia2 = new KalkulatorZamowien(zamowienie2, new GLSWysylka()).oblicz();
        System.out.println("Zamowienie 2 : " + kosztZamowienia2);

        Zamowienie zamowienie3 = new Zamowienie(odbiorca, nadawca, 30.00, RodzajTransportu.DHL);
        Double kosztZamowienia3 = new KalkulatorZamowien(zamowienie3, new DHLWysylka()).oblicz();
        System.out.println("Zamowienie 3 : " + kosztZamowienia3);
    }
}
