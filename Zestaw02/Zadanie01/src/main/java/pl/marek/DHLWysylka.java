package pl.marek;

public class DHLWysylka implements IKosztWysylki {

    @Override
    public double obliczKosztPrzesylki(Zamowienie zamowienie) {
        System.out.println("Przesylka : DHL");
        return 17.50;
    }
}
