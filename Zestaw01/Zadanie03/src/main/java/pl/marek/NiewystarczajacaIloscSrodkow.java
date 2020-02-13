package pl.marek;

public class NiewystarczajacaIloscSrodkow extends Exception {

    public NiewystarczajacaIloscSrodkow() {
        super("Masz niewystarczajca ilosc srodkow aby zrealizowac zamowienie");
    }
}
