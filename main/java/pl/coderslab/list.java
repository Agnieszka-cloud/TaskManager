package pl.coderslab;

import java.util.ArrayList;

public class list {
    public static void main(String[] args){

    }
    public static void list (ArrayList<String> task) {
        for (int i = 0; i < task.size(); i++) {
            System.out.print(ConsoleColors.RED);
            System.out.print( i+1 + " : " + task.get(i) );
            /*for (String str : task) {
                System.out.print(str);*/
        }
    }
}
