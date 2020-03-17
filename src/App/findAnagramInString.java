package App;
import java.util.*;
public class findAnagramInString {
    // if the total diff anagrams of String s is small
    // put all anagrams in HashSet
    // Iterate through the String s
    // use fixed s.length sliding window to check if current substring is valid anagram.
    // O(n)
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        HashMap<Character, Integer> dictP = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            if(!dictP.containsKey(c)) {
                dictP.put(c, 0);
            }
            dictP.put(c, dictP.get(c) + 1);
        }
        int requried = dictP.size();
        int formed = 0;
        int start = 0, end = 0, minLeng = p.length();
        HashMap<Character, Integer> mapS = new HashMap<>();
        while(end < s.length()) {
            char c = s.charAt(end);
            end++;
            int count = mapS.getOrDefault(c, 0);
            mapS.put(c,  count + 1);
            if(dictP.containsKey(c) && mapS.get(c).intValue() == dictP.get(c).intValue()) {
                formed++;
            }
            while(formed == requried) {
                if(end - start == minLeng) {
                    res.add(start);
                }
                char curr = s.charAt(start);
                int sum = mapS.get(curr);
                mapS.put(curr, sum - 1);
                if(dictP.containsKey(curr) && mapS.get(curr).intValue() < dictP.get(curr).intValue())
                    formed--;
                start++;
            }
        }
        return res;
    }
}
