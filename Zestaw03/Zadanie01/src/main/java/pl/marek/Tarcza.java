package pl.marek;

public class Tarcza extends DekoratorWojownik {

    public Tarcza(Wojownik wojownik) {
        super(wojownik);
    }

    @Override
    String dawajOpis() {
        return super.dawajOpis() + " + Tarcza";
    }

    @Override
    double obliczKoszt() {
        return super.obliczKoszt() + 300;
    }
}
