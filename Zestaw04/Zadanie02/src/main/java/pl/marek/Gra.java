package pl.marek;

public abstract class Gra {

    public final void graj() {
        ustawGre();
        rozegrajGre();
        zakonczGre();
        wyswietlZwyciezce();
    }

    public abstract void ustawGre();
    public abstract void rozegrajGre();
    public abstract void zakonczGre();
    public abstract void wyswietlZwyciezce();
}
