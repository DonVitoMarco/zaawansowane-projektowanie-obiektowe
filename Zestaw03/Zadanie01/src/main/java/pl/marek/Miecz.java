package pl.marek;

public class Miecz extends DekoratorWojownik {

    public Miecz(Wojownik wojownik) {
        super(wojownik);
    }

    @Override
    String dawajOpis() {
        return super.dawajOpis() + " + Miecz";
    }

    @Override
    double obliczKoszt() {
        return super.obliczKoszt() + 250;
    }
}
