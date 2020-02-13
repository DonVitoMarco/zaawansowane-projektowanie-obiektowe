package pl.marek;

public class OdtwarzaczMuzykiAdapter implements OdtwarzaczMuzyki {

    private ZaawansowanyOdtwarzaczMuzyki zaawansowanyOdtwarzaczMuzyki;

    public OdtwarzaczMuzykiAdapter(String typ) {
        if (typ.equalsIgnoreCase("mp4")) {
            this.zaawansowanyOdtwarzaczMuzyki = new Mp4();
        } else if (typ.equalsIgnoreCase("wmv")) {
            this.zaawansowanyOdtwarzaczMuzyki = new Wmv();
        }
    }

    @Override
    public void graj(String typ, String sciezka) {
        System.out.print("Przez Adapter --> ");
        if (typ.equalsIgnoreCase("mp4")) {
            zaawansowanyOdtwarzaczMuzyki.grajMP4(sciezka);
        } else if (typ.equalsIgnoreCase("wmv")) {
            zaawansowanyOdtwarzaczMuzyki.grajWMV(sciezka);
        }
    }
}
