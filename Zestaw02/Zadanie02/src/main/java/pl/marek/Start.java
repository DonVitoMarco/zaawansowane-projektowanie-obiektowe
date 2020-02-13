package pl.marek;

public class Start {

    public static void main(String[] args) {
        Zdarzenie zdarzenie = new Zdarzenie();
        ObserwowanaWiadomosc obserwowanaWiadomosc = new ObserwowanaWiadomosc(zdarzenie);

        new KanalRadiowy(zdarzenie);
        new KanalTelewizyjny(zdarzenie);

        obserwowanaWiadomosc.dodajWiadomosc("Super News");
        obserwowanaWiadomosc.dodajWiadomosc("Nowy news");
        obserwowanaWiadomosc.dodajWiadomosc("Nastepny news");
    }
}
