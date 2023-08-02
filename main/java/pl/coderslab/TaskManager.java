package pl.coderslab;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class TaskManager {
    // ZMIENNE "STATIC FINAL STRING PLIK"  MOGĄ BYĆ UMIESZCZONE TYLKO U GÓRY W KLASIE

    static final String[] tablicaOpcji = {"add", "list", "remove", "save", "exit"};

    static ArrayList<String> task = new ArrayList<>();

    public static void main(String[] args) {

        metodaDoNotatnika();

    }
    public static void metodaDoNotatnika() {
        try {
            Path path = Paths.get("notatnik.txt");
            for (String line : Files.readAllLines(path)) {
                task.add(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.println(task);

        showOptions.wyświetlPytanieIOpcjeWyboru(tablicaOpcji);

        Scanner scanner = new Scanner(System.in);
        boolean czyJestOdpowiedźUżytkownika = false;
        String odpowiedź = "";

        while (!czyJestOdpowiedźUżytkownika) {

            odpowiedź = scanner.next();
            if (odpowiedź.equals("add")) {

                add.pobierzDaneToAdd(task);

                showOptions.wyświetlPytanieIOpcjeWyboru(tablicaOpcji);
            } else if (odpowiedź.equals("list")) {

                list.list(task);

                showOptions.wyświetlPytanieIOpcjeWyboru(tablicaOpcji);
            } else if (odpowiedź.equals("remove")){

                removeBetter.remove(task);

                showOptions.wyświetlPytanieIOpcjeWyboru(tablicaOpcji);
            } else if (odpowiedź.equals("save")) {

                save.zapiszWNotatniku(task);

                System.out.println("Zachowane w notatniku: notatnik.txt");

                showOptions.wyświetlPytanieIOpcjeWyboru(tablicaOpcji);
            } else if (odpowiedź.equals("exit")) {
                System.out.println(ConsoleColors.BLUE + "Do widzenia.");
                System.exit(0); // CO TO ZNACZY ?
                return;

            } else {
                System.out.println("Dane niepoprawne. Wybierz jedną z opcji: " +
                        "add, remove, list , save albo exit");

                showOptions.wyświetlPytanieIOpcjeWyboru(tablicaOpcji);
            }
        }
    }
}
