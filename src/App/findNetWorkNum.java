package App;
import java.util.*;
public class findNetWorkNum{
        public String findNetWorkNum(List<String> ips, String ip) {
                Trie trie = new Trie();
                trie.insertIps(ips);
                return trie.getShortIp(ip);
        }
        class Trie{
            TrieNode root = new TrieNode("");

            public void insertIps(List<String> ips) {

                for (String ip : ips) {

                    TrieNode curr = root;
                    int start = 0;
                    while(start < ip.length()) {

                        int numStart = start;
                        while(start < ip.length() && ip.charAt(start) != '.') {
                            start++;
                        }
                        String next = ip.substring(numStart, start);
                        if(!curr.children.containsKey(next)) {
                            curr.children.put(next, new TrieNode(next));
                        }
                        curr = curr.children.get(next);
                        start++;
                    }
                }
            }
            public String getShortIp(String ip) {

                TrieNode curr = root;
                int start = 0;
                while(start < ip.length()) {

                    int numStart = start;
                    while(start < ip.length() && ip.charAt(start) != '.') {
                        start++;
                    }
                    String next = ip.substring(numStart, start);

                    if(!curr.children.containsKey(next)) {

                        if(!curr.children.containsKey("*"))
                            return null;

                        start = numStart;
                        break;
                    }

                    curr = curr.children.get(next);
                    start++;
                }
                return ip.substring(0, start) + '*';
            }
        }
        class TrieNode {
            String num;
            HashMap<String, TrieNode> children;
            public TrieNode(String num){
                this.num = num;
                children = new HashMap<>();
            }
        }
}