package pl.marek;

public class GLSWysylka implements IKosztWysylki {

    @Override
    public double obliczKosztPrzesylki(Zamowienie zamowienie) {
        System.out.println("Przesylka : GLS");
        return 18.50;
    }
}
