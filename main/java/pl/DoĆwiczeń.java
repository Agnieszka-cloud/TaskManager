package pl;

import org.apache.commons.lang3.math.NumberUtils;
import pl.coderslab.ConsoleColors;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class DoĆwiczeń {
    static final String TASKSSSS_FILE_NAME = "tasks.csv";
    static final String[] OPTIONS = {"add", "remove", "list", "exit"};
    static String[][] tasksss = {{"add", "remove", "list", "exit"},{"jjj","kkk"}};
    public static void printOptions(String[] tab) {
        System.out.println(ConsoleColors.BLUE);
        System.out.println("Please select an option: " + ConsoleColors.RESET);
        for (String option : tab) {
            System.out.println(option);
        }
    }
    public static boolean isNumberGreaterEqualZero(String input) {
        if (NumberUtils.isParsable(input)) {
            return Integer.parseInt(input) >= 0;
        }
        return false;
    }
    public static void printTab(String[][] tab) {
        for (int i = 0; i < tab.length; i++) {
            System.out.print(i + " : ");
            for (int j = 0; j < tab[i].length; j++) {
                System.out.print(tab[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static String[][] loadDataToTab(String fileName) {
        Path dir = Paths.get(fileName);
        if (!Files.exists(dir)) {
            System.out.println("File do not exist.");
            System.exit(0);
        }
        String[][] tab = null;
        try {
            List<String> strings = Files.readAllLines(dir);
            System.out.println(strings.toString());
            System.out.println(strings.toString().length());
            System.out.println(strings.size());
            tab = new String[strings.size()][strings.get(0).split(",").length];
            //String [][] tab = {{"kot","9.11.  2023","important"},{"kklklk"}};
            for (int i = 0; i < strings.size(); i++) {
                String[] split = strings.get(i).split(",");
                for (int j = 0; j < split.length; j++) {
                    tab[i][j] = split[j];
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tab;
    }
    public static void main(String[] args) {
        String[][] task = loadDataToTab(TASKSSSS_FILE_NAME);
        printTab(task);
        printTab(tasksss);
        printOptions(OPTIONS);
        System.out.println();
        System.out.println("______________________________________");

        String[] numbers = {"1", "one"};
        System.out.println("klasa NumberUtils.isParsable:");
        System.out.println(NumberUtils.isParsable(numbers[0]));
        System.out.println(NumberUtils.isParsable(numbers[1]));
    }

}


