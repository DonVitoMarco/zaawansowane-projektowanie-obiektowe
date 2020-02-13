package pl.marek;

import java.util.ArrayList;

public class Folder implements IDane {

    private String nazwa;
    private ArrayList<IDane> kontener;

    public Folder(String nazwa) {
        this.nazwa = nazwa;
        this.kontener = new ArrayList<>();
    }

    @Override
    public void odczytajWartosc() {
        System.out.println(this.dawajNazwe());
        for (IDane d : kontener) {
            if (d instanceof Plik) {
                System.out.print("|_" + d.dawajNazwe());
            }
            d.odczytajWartosc();
        }
    }

    @Override
    public void dodajZawartosc(IDane folder) {
        this.kontener.add(folder);
    }

    @Override
    public void usunZawartosc(IDane dane) {
        this.kontener.remove(dane);
    }

    @Override
    public double obliczRozmiar() {
        long rozmiar = 0;
        for (IDane d : kontener) {
            rozmiar += d.obliczRozmiar();
        }
        return rozmiar;
    }

    @Override
    public String dawajNazwe() {
        return this.nazwa;
    }
}
