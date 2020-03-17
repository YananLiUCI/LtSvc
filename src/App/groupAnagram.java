package App;
import java.util.*;
public class groupAnagram {

    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> map = new HashMap<>();
        for (String curr : strs) {
            String key = getKey(curr);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(curr);
            map.put(key, list);
        }
        return new ArrayList(map.values());
    }
    private String getKey(String s){
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            count[c - 'a']++;
        }
        StringBuilder str = new StringBuilder();
        for (int i= 0; i < 26; i++) {
            str.append(count[i]);
            str.append('#');

        }
        return str.toString();
    }
}
