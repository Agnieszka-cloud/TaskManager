package pl.coderslab;

import java.util.ArrayList;
import java.util.Scanner;

public class remove {
    public static void main(String[] args) {
        ArrayList<String> task = new ArrayList<>();
        task.add("agjjjka");
        task.add("gugiu");
        System.out.println(task);
        System.out.println(task.size());
        remove(task);
    }

    public static void remove(ArrayList<String> task) {
        System.out.println("Podaj numer zadania do usunięcia z listy:");
        Scanner scanner = new Scanner(System.in);
        int i;
        //boolean czyMaLiczby = false;
        //while (!czyMaLiczby)
        while (true) {
            while (!scanner.hasNextInt()) {
                System.out.println("Błędny format podanych danych. \n Podaj numer zadania do usunięcia z listy");
                scanner.next();
            }
            i = scanner.nextInt();
            if (i <= task.size() && i > 0) {
                task.remove(i - 1);
                return;
                //czyMaLiczby = true;
            }else
                System.out.println("Nie ma zadania o takim numerze. \n " +
                        "Podaj numer zadania do usunięcia z listy");
        }
    }
}
