package pl.marek;

public class Start {

    public static void main(String[] args) {
        Zamowienie zamowienie1 = new Zamowienie(1);
        Zamowienie zamowienie2 = new Zamowienie(2);
        Zamowienie zamowienie3 = new Zamowienie(3);

        ZarzadcaPolecen zarzadcaPolecen = new ZarzadcaPolecen();

        zarzadcaPolecen.ustawPolecenie(new StworzZamowienie(zamowienie1));
        zarzadcaPolecen.ustawPolecenie(new StworzZamowienie(zamowienie2));
        zarzadcaPolecen.ustawPolecenie(new StworzZamowienie(zamowienie3));

        zarzadcaPolecen.ustawPolecenie(new ZaktualizujZamowienie(zamowienie2));

        zarzadcaPolecen.ustawPolecenie(new ZrealizujZamowienie(zamowienie1));
        zarzadcaPolecen.ustawPolecenie(new ZrealizujZamowienie(zamowienie2));

        zarzadcaPolecen.wykonajPrace();
    }
}
