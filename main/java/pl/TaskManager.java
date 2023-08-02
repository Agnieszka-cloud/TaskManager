package pl;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.math.NumberUtils;
import pl.coderslab.ConsoleColors;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TaskManager {

    static final String TASKS_FILE_NAME = "tasks.csv";
    static String[][] tasks_Tab; // tu ładujemy zawartość z pliku
    // dwa wymiary: w dół i w bok jak lista zadań to wygląda
    static final String[] OPTIONS = {"add", "remove", "list", "exit"};

    public static void main(String[] args) {
        tasks_Tab = loadFileDataToTab(TASKS_FILE_NAME);
        //printTab(tasks);
        printOptions(OPTIONS);
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            switch (input) {
                case "exit":
                    saveTabToFile(TASKS_FILE_NAME, tasks_Tab);
                    System.out.println(ConsoleColors.RED + "Bye, bye.");
                    System.exit(0);
                    break;
                case "add":
                    addTask();
                    break;
                case "remove":
                    removeTask(tasks_Tab, getTheNumber());
                    System.out.println("Value was successfully deleted.");
                    break;
                case "list":
                    printTab(tasks_Tab);
                    break;
                default:
                    System.out.println("Please select a correct option.");
            }
            printOptions(OPTIONS);
        }
    }
    public static String[][] loadFileDataToTab(String fileName) {
        Path dir = Paths.get(fileName);
        if (!Files.exists(dir)) {
            System.out.println("File does not exist.");
            System.exit(0);
        }
        String[][] tab = null;
        try {
            //
            List<String> strings = Files.readAllLines(dir);
            // tworzę 2 tablice jednowymiarowe  strings[] tu wszystko sczytuje z pliku
            // i split[] tu wyodrębniam poszczególne elementy w wewnętrznej tablicy
            // by móc na tej postawie
            // określić parametry tablicy dwuwymiarowej

            System.out.println(Files.readAllLines(dir));
            System.out.println(strings.toString());
            System.out.println(strings.size());
            System.out.println(strings.get(0));
            System.out.println(strings.get(1));
            System.out.println(strings.get(0).split(",").length);

            // tworzę nową tablicę dwuwymiarową więc muszę podać ilość w każdym wymiarze
            tab = new String[strings.size()][strings.get(0).split(",").length];
            for (int i = 0; i < strings.size(); i++) {
                String[] split = strings.get(i).split(",");
                for (int j = 0; j < split.length; j++) {
                    tab[i][j] = split[j];
                    System.out.print(tab[i][j]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tab;
    }
    public static void printOptions(String[] optionsTab) {
        System.out.println(ConsoleColors.BLUE);
        System.out.println("Please select an option: " + ConsoleColors.RESET);
        for (String option : optionsTab) {
            System.out.println(option); // ln, że każdy wyraz od nowej linii
        }
    }
    public static void saveTabToFile(String fileName, String[][] tab) {
        Path dir = Paths.get(fileName);
        String[] lines = new String[tab.length];
        System.out.println(tab.length);
        for (int i = 0; i < tab.length; i++) {
            lines[i] = String.join(",", tab[i]);
            System.out.println(lines[i]);
        }
        try {
            Files.write(dir, Arrays.asList(lines));
            System.out.println(Arrays.asList(lines));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    private static void addTask() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please add task description");
        String description = scanner.nextLine();
        System.out.println("Please add task due date");
        String dueDate = scanner.nextLine();
        System.out.println("Is your task important: true/false");
        String isImportant = scanner.nextLine();
        tasks_Tab = Arrays.copyOf(tasks_Tab, tasks_Tab.length + 1);
        tasks_Tab[tasks_Tab.length - 1] = new String[3];
        tasks_Tab[tasks_Tab.length - 1][0] = description;
        tasks_Tab[tasks_Tab.length - 1][1] = dueDate;
        tasks_Tab[tasks_Tab.length - 1][2] = isImportant;
    }
    private static void removeTask(String[][] tab, int index) {
        try {
            if (index < tab.length) {  // to jest zakręt
                tasks_Tab = ArrayUtils.remove(tab, index);
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Element does not exist in tab");
        }
    }
    public static int getTheNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please select number to remove.");
        String n = scanner.nextLine();
        while (!isNumberGreaterEqualZero(n)) {
            System.out.println("Incorrect argument passed. " +
                    "Please give number greater than or equal 0");
            scanner.nextLine();
        }
        return Integer.parseInt(n);
    }

    public static boolean isNumberGreaterEqualZero(String input) {
        // parsable zdolny do przekształcenia w liczbę
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
}
