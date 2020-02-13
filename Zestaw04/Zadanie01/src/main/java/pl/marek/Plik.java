package pl.marek;

public class Plik implements IDane {

    private String nazwa;
    private double rozmiar;
    private String zawartosc;

    public Plik(String nazwa, String zawartosc) {
        this.nazwa = nazwa;
        this.rozmiar = zawartosc.length();
        this.zawartosc = zawartosc;
    }

    @Override
    public void odczytajWartosc() {
        System.out.println(this.zawartosc);
    }

    @Override
    public void dodajZawartosc(IDane dane) {
    }

    @Override
    public void usunZawartosc(IDane dane) {
        this.zawartosc = "";
        this.rozmiar = this.zawartosc.length();
    }

    @Override
    public double obliczRozmiar() {
        return this.rozmiar;
    }

    @Override
    public String dawajNazwe() {
        return this.nazwa;
    }
}
