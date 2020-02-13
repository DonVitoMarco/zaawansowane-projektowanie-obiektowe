package pl.marek;

public class Fabia implements ISamochod {

    @Override
    public String getNazwa() {
        return "Fabia";
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
