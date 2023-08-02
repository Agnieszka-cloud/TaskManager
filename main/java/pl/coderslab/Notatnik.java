package pl.coderslab;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Notatnik {
    static final String[] options = {"add", "list", "remove", "exit"};
    static final List<String> tasks = new ArrayList<>();


    public static void main(String[] args) {

        Notatnik();
        System.out.print(tasks);
    }

    public static void Notatnik(){
        try {
            Path path = Paths.get("notatnik.txt");
            if (!Files.exists(path)) {
                Files.createFile(path);
            }
            for (String str : Files.readAllLines(path)) {
                tasks.add(str + "\n");
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println(tasks);

        showOptions1.optionsToChoose(options);

        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()) {
            String answer = scanner.next();
            if (answer.equals("add")){
                add1.add1(tasks);
                showOptions1.optionsToChoose(options);
            } else if (answer.equals("list")){
                list1.listing(tasks);
                showOptions1.optionsToChoose(options);
            } else if (answer.equals("remove")){
                remove1.removeNumberOfTheTask(tasks);
                showOptions1.optionsToChoose(options);
            } else if (answer.equals("exit")){
                System.out.println("Good bye.");
                return;
            }
            else {
                System.out.println(ConsoleColors.BLUE + "Incorrect value. Choose an option " +
                        "between: \nadd, list, remove, exit \nand paste it below.");
                showOptions1.optionsToChoose(options);
            }
        }
    }
}





