package pl.marek;

public class ModulSprzedazy {

    private Koszyk koszyk;
    private Platnosc platnosc;

    public ModulSprzedazy(Koszyk koszyk, Platnosc platnosc) {
        this.koszyk = koszyk;
        this.platnosc = platnosc;
    }

    public void generujPotwierdzeniePlatnosci() {
        platnosc.zarejstrujPlatnosc();
    }

    public void generujPotwierdzenieZamowienia() {
        platnosc.generujPotwierdzenieZamowienia();
    }
}
