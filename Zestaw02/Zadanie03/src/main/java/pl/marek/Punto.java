package pl.marek;

public class Punto implements ISamochod {

    @Override
    public String getNazwa() {
        return "Punto";
    }

    @Override
    public void wlacz() {
        System.out.printf("%s start!\n", getNazwa());
    }

    @Override
    public void wylacz() {
        System.out.printf("%s stop!\n", getNazwa());
    }
}
