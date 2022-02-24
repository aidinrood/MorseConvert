import java.util.HashMap;
import java.util.Map;

public class Converter {

    String[] code = { "*-",   "-***", "-*-*", "-**",  "*",          // a b c d e
            "**-*", "--*",  "****", "**",   "*---",                 // f g h i j
            "-*-",  "*-**", "--",   "-*",   "---",                  // k l m n o
            "*--*", "--*-", "*-*",  "***",  "-",                    // p q r s t
            "**-",  "***-", "*--",  "-**-", "-*--", "--**",         // u v w x y z
            "-----","*----","**---","***--","****-",                // 0 1 2 3 4
            "*****","-****","--***","---**","----*" };              // 5 6 7 8 9

    /**
     * Convert Morse Code to Text
     * @param morse Code
     * @return Text String
     */
    public String morseToEngConvert(String morse){
        String english="";
        Map<String, Character> morseMap = new HashMap<>();    // HashMap to store morse code to alphabet-numeric mapping
        for (int i = 0; i < 26; i++) {
            morseMap.put(code[i], (char)('a' + i));         // map each alphabet char against its morse code
        }
        for(int i=0;i<10;i++){
            morseMap.put(code[i+26], Character.forDigit(i, 10));    // map 0-9 integers against their morse code
        }

        String[] array = morse.split(" ");      // split on space to get array of morse code inputed

        for (int i = 0; i < array.length; i++) {
            english+=morseMap.get(array[i])         // get alpha-numeric char against each inputed morse code from hashmap
                    + "";                           // and put that in a string to return result
        }
        return english;
    }

    /**
     * Convert Text to Morse Code
     * @param eng Text
     * @return Morse Code String
     */
    public String engToMorseConvert(String eng){
        String morse="";

        for (int i = 0; i < eng.length(); i++) {
            try {// try block to catch ArrayIndexOutOfBoundException
                // this exception occur when there is a numeric character
                // in input text that needs to be convert to morse code
                morse+=code[eng.charAt(i) - 'a'] + " ";
            }catch (ArrayIndexOutOfBoundsException e){
                // add 49+26 to get exact location of code value
                // 49-> there is difference of 49 between ascii code of 'a' and '1'
                // 26-> in out code array declared in start numeric values start at 26th index
                morse+=code[eng.charAt(i) - 'a' +49+26] + " ";
            }
        }
        return morse.substring(0,morse.length()-1);        // remove the last appended space to return accurate results
    }



}
