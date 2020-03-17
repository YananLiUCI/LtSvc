package App;

import java.nio.charset.Charset;
import java.util.*;
public class randomStrGenerator {

    public String generateRandomStr(int length){

        byte[] array = new byte[length];// str length is bounded by length;
        new Random().nextBytes(array);

        String generatedString = new String(array, Charset.forName("UTF-8"));

        return generatedString;

    }
    public String generateRandomAlphaStr(int length){
           int lowerLimit = (int) 'a';
           int upperLimit = (int) 'z';
           int range = upperLimit - lowerLimit;
           StringBuilder str = new StringBuilder();
           Random rand = new Random();

           for (int i = 0; i < length; i++) {
               int offset = rand.nextInt(range + 1);
               str.append((char) (lowerLimit + offset));
           }
           return str.toString();
    }

}
