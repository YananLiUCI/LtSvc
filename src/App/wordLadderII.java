package App;
import java.util.*;
public class wordLadderII {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        Set<String> wordDict = new HashSet<>(wordList);
        if (!wordDict.contains(endWord)) return res;
        Set<String> top = new HashSet<>();
        Set<String> bot = new HashSet<>();
        top.add(beginWord);
        bot.add(endWord);
        Map<String, List<String>> map = new HashMap<>();
        boolean hasPath = helper(wordDict, top, bot, map, false);
        if (!hasPath) return res;
        List<String> sol = new ArrayList<>(Arrays.asList(beginWord));
        generateList(beginWord, endWord, map, sol, res);
        return res;
    }

    private boolean helper(Set<String> dict, Set<String> top, Set<String> bot, Map<String, List<String>> map, boolean flip) {
        if (top.isEmpty()) return false;
        if (top.size() > bot.size()) return helper(dict, bot, top, map, !flip);
        dict.removeAll(top);
        dict.removeAll(bot);
        boolean done = false;
        Set<String> next = new HashSet<>();
        for (String s : top) {
            char[] chars = s.toCharArray();
            for (int i = 0; i < s.length(); i++) {
                char old = chars[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    if(c == old)continue;
                    chars[i] = c;
                    String word = new String(chars);
                    String key = flip ? word : s;
                    String val = flip ? s : word;
                    List<String> list = map.containsKey(key) ? map.get(key) : new ArrayList<String>();
                    if (bot.contains(word)) {
                        done = true;
                        list.add(val);
                        map.put(key, list);
                    }
                    if (!done && dict.contains(word)) {
                        next.add(word);
                        list.add(val);
                        map.put(key, list);
                    }

                }
                chars[i] = old;
            }
        }
        return done || helper(dict, bot, next, map, !flip);
    }

    private void generateList(String s, String e, Map<String, List<String>> map, List<String> sol, List<List<String>> res) {
        if (s.equals(e)) {
            res.add(new ArrayList<String>(sol));
            return;
        }
        if (!map.containsKey(s)) return;
        for (String word : map.get(s)) {
            sol.add(word);
            generateList(word, e, map, sol, res);
            sol.remove(sol.size() - 1);
        }
    }
}
