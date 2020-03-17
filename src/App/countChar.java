package App;

import java.util.HashMap;

public class countChar {
    public void countChar(String word) {

        HashMap<Character, Integer> map = new HashMap<>();
        char[] arr = word.toCharArray();
        for (char c : arr) {
            map.put(c, map.getOrDefault(c,0 ) + 1);
        }
    }
    public void countCharII(String word) {

        int[] count = new int[26];
        char[] arr = word.toCharArray();
        for (char c : arr) {
            count[c - 'a']++;
        }
    }
}
