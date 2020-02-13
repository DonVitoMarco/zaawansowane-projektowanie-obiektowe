package pl.marek;

public class Zbroja extends DekoratorWojownik {

    public Zbroja(Wojownik wojownik) {
        super(wojownik);
    }

    @Override
    String dawajOpis() {
        return super.dawajOpis() + " + Zbroja";
    }

    @Override
    double obliczKoszt() {
        return super.obliczKoszt() + 500;
    }
}
