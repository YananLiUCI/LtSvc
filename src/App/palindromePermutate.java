package App;
import java.util.*;
public class palindromePermutate {
    public boolean canPermutePalindrome(String s) {
        HashMap<Character, Integer> count = new HashMap<>();
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            count.put(arr[i], count.getOrDefault(arr[i], 0) + 1);
        }
        int odd = 0;
        for (Map.Entry<Character,Integer> entry : count.entrySet()) {
            odd += entry.getValue() % 2;
        }
        return odd <= 1;
    }
}
