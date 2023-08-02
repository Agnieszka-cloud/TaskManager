package pl.coderslab;

public class showOptions {
    public static void main(){

    }
    public static void wyświetlPytanieIOpcjeWyboru(String[] array) {
        String[] tablicaOpcji = {"add", "list", "remove", "save", "exit"};
        System.out.println(ConsoleColors.BLUE + "Wybierz opcję: ");
        for (String opcja : tablicaOpcji) {
            System.out.println(ConsoleColors.RESET + opcja);
        }
    }
}
