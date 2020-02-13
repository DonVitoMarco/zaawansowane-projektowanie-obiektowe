package pl.marek;

public class Start {

    public static void main(String[] args) {
        Folder c = new Folder("C:");
        Folder programFiles = new Folder("Program Files");
        Folder java = new Folder("Java");
        Folder microsoft = new Folder("Microsoft");
        Folder bin = new Folder("bin");

        Plik readMeTxt = new Plik("README.txt", "");
        Plik welcome = new Plik("Welcome.html", "");
        Plik javaJar = new Plik("java.jar", "");
        Plik javawJar = new Plik("javaw.jar", "");
        Plik eula = new Plik("eula.docx", "");
        Plik readMeHtml = new Plik("readme.html", "");
        Plik notices = new Plik("thirdpartynotices.docx", "");

        c.dodajZawartosc(programFiles);
        programFiles.dodajZawartosc(java);
        java.dodajZawartosc(readMeTxt);
        java.dodajZawartosc(welcome);

        java.dodajZawartosc(bin);
        bin.dodajZawartosc(javaJar);
        bin.dodajZawartosc(javawJar);

        programFiles.dodajZawartosc(microsoft);
        microsoft.dodajZawartosc(eula);
        microsoft.dodajZawartosc(readMeHtml);
        microsoft.dodajZawartosc(notices);

        c.odczytajWartosc();
    }
}
