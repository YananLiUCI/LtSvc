package App;
import java.util.*;
public class reverseStringApp {
    public String reverseWordOnly(String source) {
            List<Integer> spaces = new ArrayList<>();
            List<String> words = new ArrayList<>();
            int start = 0;
            while(start < source.length()) {
                if(source.charAt(start) == ' ') {
                    int i = start;
                    while(i < source.length() && source.charAt(i) == ' ') {
                        i++;
                    }
                    spaces.add(i - start);
                    start = i;
                }
                if(Character.isAlphabetic(source.charAt(start))) {
                    int i = start;
                    while(i < source.length() && Character.isAlphabetic(source.charAt(i))) {
                        i++;
                    }
                    words.add(source.substring(start, i));
                    start = i;
                }
            }
            StringBuilder str = new StringBuilder();
            if(source.charAt(0) == ' ') {
                int index = 0;
                while(index < spaces.size() || index < words.size()) {
                    if(index < spaces.size()) {
                        for (int i = 0; i < spaces.get(index); i++) {
                            str.append(' ');
                        }
                    }
                    if(index < words.size()) {
                        str.append(words.get(index));
                    }
                    index++;
                }
            }
            else {
                int index = 0;
                while(index < spaces.size() || index < words.size()) {
                    if(index < words.size()) {
                        str.append(words.get(index));
                    }
                    if(index < spaces.size()) {
                        for (int i = 0; i < spaces.get(index); i++) {
                            str.append(' ');
                        }
                    }

                    index++;
                }
            }
            return String.valueOf(str);
    }
}
