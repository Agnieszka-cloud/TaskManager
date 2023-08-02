package pl.coderslab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class remove1 {
    public static void main (String[]args){
        List<String> tasks = new ArrayList<>();
        tasks.add("aga;");
        tasks.add("ala;");
        removeNumberOfTheTask(tasks);
    }
    public static void removeNumberOfTheTask(List <String> tasks){
        int i = 0;
        Scanner scanner = new Scanner(System.in);
        while (i > tasks.size() || i <= 0){
            System.out.println(ConsoleColors.CYAN +
                    "Type correct number of the task to remove from the list.");
            while (!scanner.hasNextInt()){
                System.out.println("Incorrect format. Please select a number.");
                scanner.next();
            }
            i = scanner.nextInt();
        }
        tasks.remove(i - 1);
        System.out.println("The task under number " + i + " has been successfully removed from the notebook");
    }
}
