package App;

import java.util.HashMap;
import java.util.PriorityQueue;

public class findNextVisitCountry {

    public String findNextVisitCountry(String[] history, String user) {
            Trie trie = new Trie();
            for (String path : history) {
                trie.add(path);
            }
            return trie.getNextCountry(user);
    }
    class Trie {
        TrieNode root = new TrieNode("");
        public void add(String path) {
            TrieNode curr = root;
            String[] countries = path.split("\\s+");
            for (String country : countries) {
                if(!curr.children.containsKey(country)) {
                    curr.children.put(country, new TrieNode(country));
                }
                curr.children.get(country).freq++;
                curr = curr.children.get(country);
            }
        }
        public String getNextCountry(String path) {
            TrieNode curr = root;
            String[] countries = path.split("\\s+");
            for (String country : countries) {
                if (!curr.children.containsKey(country)) {
                   return null;
                }
                curr = curr.children.get(country);
            }
            int max = 0;
            String res = "";
            for (TrieNode child : curr.children.values()) {
                if(child.freq > max) {
                    max = child.freq;
                    res = child.country;
                }
            }
            return res;
        }

    }
    class TrieNode {
          HashMap<String, TrieNode> children;
          int freq;
          String country;
          public TrieNode(String country) {
              this.country = country;
              children = new HashMap<>();
          }

    }
}
