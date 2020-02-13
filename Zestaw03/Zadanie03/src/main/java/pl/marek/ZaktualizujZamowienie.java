package pl.marek;

public class ZaktualizujZamowienie implements IPolecenie {

    private Zamowienie zamowienie;

    public ZaktualizujZamowienie(Zamowienie zamowienie) {
        this.zamowienie = zamowienie;
    }

    @Override
    public void wykonaj() {
        zamowienie.zmodyfikujZamowienie();
    }
}
