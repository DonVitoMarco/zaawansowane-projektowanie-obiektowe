package pl.marek;

public class PrzelewInternetowy extends Platnosc {

    private String numerKonta;

    public PrzelewInternetowy(String tytul, String opis, double kwota, String numerKonta) {
        super(tytul, opis, kwota);
        this.numerKonta = numerKonta;
    }

    public String getNumerKonta() {
        return numerKonta;
    }
}
