package pl.coderslab;

import java.util.ArrayList;
import java.util.Scanner;

public class add {
    public static void main(String[] args) {
        ArrayList<String> task = new ArrayList<>();

        pobierzDaneToAdd(task);
    }
    public static void pobierzDaneToAdd (ArrayList<String> task) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder();
        String add = "";

        System.out.println("Dodaj nazwę zadania:");
        add = scanner.nextLine();
        stringBuilder.append(add + ", ");

        System.out.println("Podaj do kiedy chcesz zrealizować zadanie:");
        add = scanner.nextLine();
        stringBuilder.append(add + ", " );

        System.out.println("Określ czy zadanie jest ważne czy mniej ważne:");
        add = scanner.nextLine();
        stringBuilder.append(add + "\n");

        //task.add(add);
        //task.add("\n");

        task.add(stringBuilder.toString());
        //System.out.println(task.toString());
    }
}
