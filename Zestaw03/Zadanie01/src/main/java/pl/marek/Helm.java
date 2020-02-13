package pl.marek;

public class Helm extends DekoratorWojownik {

    public Helm(Wojownik wojownik) {
        super(wojownik);
    }

    @Override
    String dawajOpis() {
        return super.dawajOpis() + " + Helm";
    }

    @Override
    double obliczKoszt() {
        return super.obliczKoszt() + 100;
    }
}
