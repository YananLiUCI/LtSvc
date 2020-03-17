package App;
import java.util.*;
public class JewlsInStone {
    public int numJewelsInStones(String J, String S) {
        HashSet<Character> set = new HashSet<>();
        char[] arr = J.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        int count = 0;
        for (int i = 0; i < S.length(); i++){
            if(set.contains(S.charAt(i))) {
                count++;
            }
        }
        return count;
    }
}
