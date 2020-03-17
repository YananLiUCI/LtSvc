package App;
import java.util.*;
public class wordBreakII {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<String>();
        ArrayList<String> temp = new ArrayList<String>();
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        return dfs(s, wordDict, map);

    }
    private List<String> dfs (String s, List<String> wordDict, HashMap<String, List<String>> map) {
        if (map.containsKey(s))
            return map.get(s);

        List<String>res = new ArrayList<String>();
        if (s.length() == 0) {
            res.add("");
            return res;
        }
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String>sublist = dfs(s.substring(word.length()), wordDict, map);
                for (String sub : sublist) {
                    if(!sub.equals(""))
                        res.add(word + " " + sub);
                    else
                        res.add(word + sub);
                }
            }
        }
        map.put(s, res);
        return res;
    }
}
