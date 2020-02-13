package pl.marek;

public class Start {

    public static void main(String[] args) {
        Gra graNumery = new GraNumery();
        graNumery.graj();

        System.out.println("=============");

        Gra graPapier = new GraPapier();
        graPapier.graj();
    }
}
