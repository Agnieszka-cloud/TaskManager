package pl.coderslab;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class add1 {
    public static void main(String []args ){
        //List<String> tasks = new ArrayList<>();
        ArrayList<String> tasks = new ArrayList<>();
        add1(tasks);
        System.out.println(tasks);
        //System.out.println(tasks.toString());
        // wstaw do tasks to co pobierzesz z konsoli
    }
    public static void add1 (List<String> tasks){
        StringBuilder stringBuilder = new StringBuilder();
        Scanner scanner = new Scanner(System.in);
        String line = "";
        System.out.println("Add task's name: ");
        line = scanner.nextLine();
        stringBuilder.append(line + ",");
        System.out.println("Add deadline of the task:");
        line = scanner.nextLine();
        stringBuilder.append(line + ",");
        System.out.println("Indicate how important the task is: ");
        line = scanner.nextLine();
        stringBuilder.append(line + "\n");
        //System.out.println(stringBuilder);
        tasks.add(stringBuilder.toString());
    }
}
