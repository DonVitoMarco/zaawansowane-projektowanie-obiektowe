package pl.marek;

public class ZrealizujZamowienie implements IPolecenie {

    private Zamowienie zamowienie;

    public ZrealizujZamowienie(Zamowienie zamowienie) {
        this.zamowienie = zamowienie;
    }

    @Override
    public void wykonaj() {
        zamowienie.zrealizujZamowienie();
    }
}
