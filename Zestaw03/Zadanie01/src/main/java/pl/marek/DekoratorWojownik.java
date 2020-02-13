package pl.marek;

public class DekoratorWojownik extends Wojownik {

    protected Wojownik wojownik;

    public DekoratorWojownik(Wojownik wojownik) {
        this.wojownik = wojownik;
    }

    @Override
    String getOpis() {
        return wojownik.getOpis();
    }

    @Override
    String dawajOpis() {
        return wojownik.dawajOpis();
    }

    @Override
    double obliczKoszt() {
        return wojownik.obliczKoszt();
    }
}
