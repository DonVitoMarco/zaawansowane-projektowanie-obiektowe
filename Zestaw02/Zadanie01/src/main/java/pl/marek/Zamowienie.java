package pl.marek;

public class Zamowienie {

    private Adres adresOdbiorcy;
    private Adres adresNadawcy;
    private Double wartoscTowaru;
    private RodzajTransportu rodzajTransportu;

    public Zamowienie(Adres adresOdbiorcy, Adres adresNadawcy, Double wartoscTowaru, RodzajTransportu rodzajTransportu) {
        this.adresOdbiorcy = adresOdbiorcy;
        this.adresNadawcy = adresNadawcy;
        this.wartoscTowaru = wartoscTowaru;
        this.rodzajTransportu = rodzajTransportu;
    }

    public Adres getAdresOdbiorcy() {
        return adresOdbiorcy;
    }

    public Adres getAdresNadawcy() {
        return adresNadawcy;
    }

    public Double getWartoscTowaru() {
        return wartoscTowaru;
    }

    public RodzajTransportu getRodzajTransportu() {
        return rodzajTransportu;
    }
}
