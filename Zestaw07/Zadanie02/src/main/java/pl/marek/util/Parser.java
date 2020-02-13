package pl.marek.util;

public class Parser {

    public static Boolean parseBoolean(String toParse) {
        try {
            return Boolean.parseBoolean(toParse);
        } catch (Exception e) {
            return false;
        }
    }

    public static double parseDouble(String toParse) {
        try {
            return Double.parseDouble(toParse);
        } catch (Exception e) {
            return 0.00;
        }
    }

    public static int parseInteger(String toParse) {
        try {
            return Integer.parseInt(toParse);
        } catch (Exception e) {
            return 0;
        }
    }
}
