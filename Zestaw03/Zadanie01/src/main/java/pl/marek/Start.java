package pl.marek;

public class Start {

    public static void main(String[] args) {
        DekoratorWojownik pierwszyWojownik = new DekoratorWojownik(new Zbroja(new Helm(new Miecz(new Tarcza(new Rycerz())))));
        System.out.println(pierwszyWojownik.dawajOpis());
        System.out.println(pierwszyWojownik.obliczKoszt());

        DekoratorWojownik drugiWojownik = new DekoratorWojownik(new Miecz(new Miecz(new Rycerz())));
        System.out.println(drugiWojownik.dawajOpis());
        System.out.println(drugiWojownik.obliczKoszt());
    }
}
