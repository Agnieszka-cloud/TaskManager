package pl.coderslab;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class createFile {
    public static void main(String[]args ){
        Path path = Paths.get("tasks.csv");
        try {
            Files.createFile(path);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
