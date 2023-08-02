package pl.coderslab;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Scanner;

public class save {
    public static void main(String[]args) {

    }

    public static void zapiszWNotatniku(ArrayList<String> task) {

        try {
            Path path = Paths.get("notatnik.txt");
            if (!Files.exists(path)) {
                Files.createFile(path);
            }else {
                Files.delete(path);
                Files.createFile(path);

                for (String str : task) {
                    //System.out.println(str);
                    Files.writeString(path, str, StandardOpenOption.APPEND);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
