package App;

import java.util.LinkedHashMap;
import java.util.*;
public class firstUniqueChar {
    public int firstUniqChar(String s) {
        int[] freq = new int[26];
        for(int i = 0 ; i< s.length() ; i++){
            freq[s.charAt(i) - 'a']++;
        }

        for(int i = 0 ; i< s.length() ; i++){
            if(freq[s.charAt(i) - 'a'] == 1)
                return i;
        }
        return -1;
    }
    public int firstUniqueChar(String s) {
        Map<Character, Node> count = new LinkedHashMap<Character, Node>();
        int n = s.length();
        // build Linked hash map : character and how often it appears
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            int freq = 1;
            if(!count.containsKey(c)) {
                count.put(c, new Node(i, freq));
            }
            else
                count.get(c).freq = count.get(c).freq + 1;
        }

        // Iterate through the key will be in insertion order.
        for (Map.Entry<Character, Node> entry : count.entrySet()) {
            if(entry.getValue().freq == 1)
                return entry.getValue().index;
        }
        return -1;
    }
    class Node {
        int index;
        int freq;
        public Node(int index, int freq) {
            this.index = index;
            this.freq = freq;
        }
    }
}
