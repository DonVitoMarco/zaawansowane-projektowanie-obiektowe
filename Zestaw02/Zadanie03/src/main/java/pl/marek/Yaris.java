package pl.marek;

public class Yaris implements ISamochod {

    @Override
    public String getNazwa() {
        return "Yaris";
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
