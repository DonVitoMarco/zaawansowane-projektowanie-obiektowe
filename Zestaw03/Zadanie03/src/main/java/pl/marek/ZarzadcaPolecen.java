package pl.marek;

import java.util.ArrayList;
import java.util.List;

public class ZarzadcaPolecen {

    List<IPolecenie> kontener = new ArrayList<>();

    void ustawPolecenie(IPolecenie IPolecenie) {
        kontener.add(IPolecenie);
    }

    void usunOstatniePolecenie() {
        kontener.remove(kontener.size() - 1);
    }

    void wykonajPrace() {
        kontener.forEach(IPolecenie::wykonaj);
    }
}
