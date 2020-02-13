package pl.marek;

public class UPSWysylka implements IKosztWysylki {

    @Override
    public double obliczKosztPrzesylki(Zamowienie zamowienie) {
        System.out.println("Przesylka : UPS");
        return 15.50;
    }
}
