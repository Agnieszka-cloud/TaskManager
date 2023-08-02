package pl.coderslab;


public class showOptions1 {
    public static void main(String []args){
        String []options = new String []{"ola","przemo"};
        optionsToChoose(options);
    }
    public static void optionsToChoose( String [] options){
        System.out.println(ConsoleColors.GREEN + "Choose an option:");
        for (String option : options) {
            System.out.println(ConsoleColors.YELLOW + option);
        }
    }
}
