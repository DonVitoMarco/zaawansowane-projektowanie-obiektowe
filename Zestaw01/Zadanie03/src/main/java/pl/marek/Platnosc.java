package pl.marek;

import java.util.UUID;

public class Platnosc implements IPlatnosc {

    private UUID id;
    private String tytul;
    private String opis;
    private double kwota;

    public Platnosc(String tytul, String opis, double kwota) {
        this.tytul = tytul;
        this.opis = opis;
        this.kwota = kwota;
    }

    public double getKwota() {
        return kwota;
    }

    public UUID getId() {
        return id;
    }

    public String getTytul() {
        return tytul;
    }

    public String getOpis() {
        return opis;
    }

    @Override
    public void zarejstrujPlatnosc() {
        this.id = UUID.randomUUID();
        System.out.printf("Platnosc o numerze zarejstrowana : %s %n", id.toString());
    }

    @Override
    public void generujPotwierdzenieZamowienia() {
        if (id != null) {
            System.out.printf("Potwierdzenie zamowienia o numerze : %s %n", id.toString());
        }
    }
}
