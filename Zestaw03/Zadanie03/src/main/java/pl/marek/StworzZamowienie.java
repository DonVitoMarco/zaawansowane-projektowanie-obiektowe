package pl.marek;

public class StworzZamowienie implements IPolecenie {

    private Zamowienie zamowienie;

    public StworzZamowienie(Zamowienie zamowienie) {
        this.zamowienie = zamowienie;
    }

    @Override
    public void wykonaj() {
        zamowienie.utworzNoweZamowienie();
    }
}
