import static org.junit.Assert.assertEquals;

public class MorseTest {

    @org.junit.Test
    public void morseToEngConvert() {
        Converter converter = new Converter();
        String englishText=converter.morseToEngConvert("*** -*-* **** --- --- *-**");
        assertEquals(englishText,"school");
    }

    @org.junit.Test
    public void engToMorseConvert() {
        Converter converter = new Converter();
        String morseCode=converter.engToMorseConvert("school");
        assertEquals(morseCode,"*** -*-* **** --- --- *-**");
    }

    @org.junit.Test
    public void isValidInputText(){
        Reader reader = new Reader();
        boolean isValidText= reader.isValidInputText("school");
        assertEquals(isValidText,true);
    }

    @org.junit.Test
    public void isValidInputCode(){
        Reader reader = new Reader();
        boolean isValidText= reader.isValidInputCode("*---- **----");
        assertEquals(isValidText,true);
    }
}