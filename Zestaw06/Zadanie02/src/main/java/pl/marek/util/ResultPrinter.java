package pl.marek.util;

public class ResultPrinter {

    public static void printQueryResult(int result) {
        if (result == 1) {
            System.out.println("Success!");
        } else {
            System.out.println("Something goes wrong");
        }
    }
}
