package pl.coderslab;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class list1 {
    public static void main(String []args){
        List<String> tasks = new ArrayList<>();
        tasks.add("aga;");
        tasks.add("ala;");
        listing(tasks);
    }
    public static void listing(List<String> tasks ){
        for (int i = 0; i <tasks.size() ; i++) {
            System.out.print( i + 1 +  ": " + tasks.get(i));
        }
        try {
            Path path = Paths.get("notatnik.txt");
            if (!Files.exists(path)) {
                Files.createFile(path);
            }else {
                Files.delete(path);
                Files.createFile(path);
                /*for (String str : tasks) {
                    //System.out.println(str);
                    Files.writeString(path, str, StandardOpenOption.APPEND);
                }*/

                }
            for ( int i = 0; i <tasks.size() ; i++) {
                String str = tasks.get(i);
                //System.out.println(str);
                Files.writeString(path, str, StandardOpenOption.APPEND);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
