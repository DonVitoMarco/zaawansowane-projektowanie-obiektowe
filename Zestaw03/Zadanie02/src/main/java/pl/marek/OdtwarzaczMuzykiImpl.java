package pl.marek;

public class OdtwarzaczMuzykiImpl implements OdtwarzaczMuzyki {

    private OdtwarzaczMuzykiAdapter adapter;

    @Override
    public void graj(String typ, String sciezka) {
        if (typ.equalsIgnoreCase("mp3")) {
            new Mp3().graj(typ);
        } else if (typ.equalsIgnoreCase("mp4") || typ.equalsIgnoreCase("wmv")) {
            adapter = new OdtwarzaczMuzykiAdapter(typ);
            adapter.graj(typ, sciezka);
        }
    }
}
