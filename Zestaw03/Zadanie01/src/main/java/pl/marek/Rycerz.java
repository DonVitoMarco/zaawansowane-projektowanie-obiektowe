package pl.marek;

public class Rycerz extends Wojownik {

    @Override
    String getOpis() {
        return this.getClass().getSimpleName();
    }

    @Override
    String dawajOpis() {
        return this.getOpis();
    }

    @Override
    double obliczKoszt() {
        return 1000;
    }
}
