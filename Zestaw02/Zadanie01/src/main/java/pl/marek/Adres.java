package pl.marek;

public class Adres {

    private String nazwaKontaktu;
    private String ulica;
    private String miasto;
    private String kodPocztowy;

    public Adres(String nazwaKontaktu, String ulica, String miasto, String kodPocztowy) {
        this.nazwaKontaktu = nazwaKontaktu;
        this.ulica = ulica;
        this.miasto = miasto;
        this.kodPocztowy = kodPocztowy;
    }

    public String getNazwaKontaktu() {
        return nazwaKontaktu;
    }

    public String getUlica() {
        return ulica;
    }

    public String getMiasto() {
        return miasto;
    }

    public String getKodPocztowy() {
        return kodPocztowy;
    }
}
