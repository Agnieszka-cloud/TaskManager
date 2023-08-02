package pl.coderslab;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TaskManagerTestowy {

    static final String FILE_NAME = "tasks.csv";
    static final String[] OPTIONS = {"add", "remove", "list", "exit"};
    static String[][] task;

    public static void main(String[] args) {
        task = loadDataToTab(FILE_NAME);
        wyświetlOpcje(OPTIONS);
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();

            switch (input) {

                case "add":
                    addTask();
                    break;
                case "remove":
                    removeTask(task, getTheNumber());
                    System.out.println("Value was successfully deleted.");
                    break;
                case "list":
                    printTab(task);
                    break;
                case "exit":
                    saveTabToFile(FILE_NAME, task);
                    System.out.println(ConsoleColors.RED + "Bye, bye.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please select a correct option.");
            }
            wyświetlOpcje(OPTIONS);
        }
    }

    public static String[][] loadDataToTab(String FILE_NAME) {
        Path dir = Paths.get(FILE_NAME);
        if (!Files.exists(dir)) {
            System.out.println("File does not exist.");
            System.exit(0);
        }
        String[][] tab = null;
        try
        {
            List<String> strings = Files.readAllLines(dir);
            tab = new String[strings.size()]
                    [strings.get(0).split(",").length];
            for (int i = 0; i < strings.size(); i++) {
                String[] split = strings.get(i).split(",");
                for (int j = 0; j < split.length; j++) {
                    tab[i][j] = split[j];
                }
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
        return tab;
    }

    public static void wyświetlOpcje(String[] OPTIONS) {
        System.out.println(ConsoleColors.BLUE);
        System.out.println("Please select an option: " + ConsoleColors.RESET);
        for (String option : OPTIONS) {
            System.out.println(option);
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
        task = Arrays.copyOf(task, task.length + 1);
        task[task.length - 1] = new String[3];
        task[task.length - 1][0] = description;
        task[task.length - 1][1] = dueDate;
        task[task.length - 1][2] = isImportant;
    }

    private static void removeTask(String[][] task, int index) {
        try {
            if (index < task.length) {
                task = ArrayUtils.remove(task, index);
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Element does not exist in tab");
        }
    }

    public static int getTheNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please select number to remove.");

        String number = scanner.nextLine();
        while (!isNumberGreaterEqualZero(number)) {
            System.out.println("Incorrect argument passed. Please give number greater or equal 0");
            scanner.nextLine();
        }
        return Integer.parseInt(number);
    }

    public static boolean isNumberGreaterEqualZero(String number) {
        if (NumberUtils.isParsable(number)) {
            return Integer.parseInt(number) >= 0;
        }
        return false;
    }

    public static void printTab(String[][] task) {
        for (int i = 0; i < task.length; i++) {
            System.out.print(i + " : ");
            for (int j = 0; j < task[i].length; j++) {
                System.out.print(task[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void saveTabToFile(String FILE_NAME, String[][] task) {
        Path dir = Paths.get(FILE_NAME);
        String[] lines = new String[task.length];
        for (int i = 0; i < task.length; i++) {
            lines[i] = String.join(",", task[i]);
        }
        try {
            Files.write(dir, Arrays.asList(lines));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
