package pl.marek;

public interface IDane {

    void odczytajWartosc();

    void dodajZawartosc(IDane dane);

    void usunZawartosc(IDane dane);

    double obliczRozmiar();

    String dawajNazwe();
}
