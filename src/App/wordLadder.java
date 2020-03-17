package App;
import java.util.*;
public class wordLadder {
    public int ladderLength(String source, String target, List<String> wordList) {
        HashSet<String> wordDict = new HashSet<>();
        for (String word : wordList) {
            wordDict.add(word);
        }
        if(!wordDict.contains(target))
            return 0;
        HashSet<String> visited = new HashSet<String>();
        HashSet<String> reached = new HashSet<>();
        reached.add(source);
        int distance = 1;
        while(!reached.contains(target)) {
            HashSet<String> next = new HashSet<>();
            for (String s : reached) {

                char[] arr = s.toCharArray();
                for (int i = 0; i < arr.length; i++) {
                    char c = arr[i];
                    for (char n = 'a' ; n <= 'z'; n++) {
                        if(n == c)
                            continue;
                        arr[i] = n;
                        String word = new String(arr);

                        if(!wordDict.contains(word) || visited.contains(word)) continue;
                        next.add(word);
                        visited.add(word);
                    }
                    arr[i] = c;
                }
            }
            distance++;
            if(reached.isEmpty())
                return 0;
            reached = next;
        }
        return distance;
    }
}
