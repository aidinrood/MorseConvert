import java.util.Scanner;

public class Reader {

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int op;
        String result;
        while (true){
            System.out.println("1-> English to Morse Converter\n2-> Morse to English Converter\n0-> Exit Program\nPlease Input ");
            op=in.nextInt();
            in.nextLine();
            result="";
            Converter converter=new Converter();
            if(op==1){
                System.out.println("Please enter English String");
                String userInput=in.nextLine();
                if(isValidInputText(userInput)){
                    result=converter.engToMorseConvert(userInput);
                    printResults(result);
                }else{
                    System.err.println("Invalid input data. Program support only Alpha-Numeric data. Please input again.");
                }
            }else if(op==2){
                System.out.println("Please enter Morse code");
                String userInput=in.nextLine();
                if(isValidInputCode(userInput)){
                    result=converter.morseToEngConvert(userInput);
                    printResults(result);
                }else {
                    System.err.println("Invalid input data. Program support only Alpha-Numeric data. Please input again.");
                }

            }else if(op==0){
                System.exit(0);
            }else {
                System.err.println("Invalid input. Please input again.");
            }
        }

    }

    /**
     * Show Results on console
     * @param result
     */
    private static void printResults(String result){

        System.out.println("RESULTS");
        System.out.println("--------------------------------------------------");
        System.out.println(result);
        System.out.println("--------------------------------------------------");
    }

    /**
     * Use case in which user can input invalid input that is input contains other chars than alphabets and numeric
     * This Method handles such type of bug.
     * @param input text by user
     * @return either valid or in-valid input(True/False)
     */
    static boolean isValidInputText(String input){
        input=input.replaceAll("\\s","");
        if(input!=null && (input.chars().allMatch(Character::isLetterOrDigit))){
            return true;
        }
        return false;
    }

    /**
     * Use case in which user can input invalid Morse Code that is Code contains other chars than '*', '-', space
     * This Method handles such type of bug.
     * @param input text by user
     * @return either valid or in-valid input code (True/False)
     */
    static boolean isValidInputCode(String input){
        if(input!=null && input.chars().allMatch(value -> value=='*' || value == '-' || value == ' ')){
            return true;
        }
        return false;
    }

}
