package pl.marek;

import java.util.ArrayList;
import java.util.List;

public class Start {

    public static void main(String[] args) {
        List<ISocialMediaReporter> media = new ArrayList<>();

        media.add(new FBReporter());
        media.add(new GPlusReporter());
        media.add(new TwitterReporter());

        media.forEach(m -> System.out.println(m.getNazwa()));

        media.forEach(m -> m.raportuj("Witaj Swiecie!!!"));
    }
}
