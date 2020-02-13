package pl.marek;

public class KalkulatorZamowien {

    private Zamowienie zamowienie;
    private IKosztWysylki kosztWysylki;

    public KalkulatorZamowien(Zamowienie zamowienie, IKosztWysylki kosztWysylki) {
        this.zamowienie = zamowienie;
        this.kosztWysylki = kosztWysylki;
    }

    public Double oblicz() {
        System.out.println("Koszt zamowienia : " + zamowienie.getWartoscTowaru());
        return zamowienie.getWartoscTowaru() + kosztWysylki.obliczKosztPrzesylki(zamowienie);
    }
}
