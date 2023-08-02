package pl.coderslab;

import java.util.ArrayList;
import java.util.Scanner;

public class removeBetter {
    public static void main(String[] args) {
        ArrayList<String> task = new ArrayList<>();
        task.add("agjjjka");
        task.add("gugiu");
        System.out.println(task);
        System.out.println(task.size());
        remove(task);
    }

    public static void remove(ArrayList<String> task) {
        int i = 0;
        Scanner scanner = new Scanner(System.in);
        while (i <= 0 || i > task.size()) {
            System.out.println("Podaj numer zadania do usunięcia z listy, który występuje na liście:");
            while (!scanner.hasNextInt()) {
                System.out.println("Błędny format podanych danych. \nPodaj numer zadania z listy do usunięcia:");
                scanner.next();
            }
            i = scanner.nextInt();
        }
        task.remove(i - 1);
        System.out.println(task);
    }
}
