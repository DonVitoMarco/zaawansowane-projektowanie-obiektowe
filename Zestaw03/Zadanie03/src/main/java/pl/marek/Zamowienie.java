package pl.marek;

public class Zamowienie {

    private int numer;

    public Zamowienie(int numer) {
        this.numer = numer;
    }

    void utworzNoweZamowienie() {
        System.out.printf("Stworz zamowienie %d!%n", numer);
    }

    void zmodyfikujZamowienie() {
        System.out.printf("Zaktualizuj zamowienie %d!%n", numer);
    }

    void zrealizujZamowienie() {
        System.out.printf("Zrealizuj zamowienie %d!%n", numer);
    }
}
