package App;

import java.util.ArrayList;
import java.util.List;

public class printGraphString {
    public List<String> getAllGraphString(List<TrieNode> nodes) {
            List<String> res = new ArrayList<>();
            if(nodes == null || nodes.size() == 0)
                return res;
            for (TrieNode node : nodes) {
                res.addAll(getString(node));
            }
            return res;
    }
    private List<String> getString(TrieNode root) {
            List<String> res = new ArrayList<>();
            if(root == null)
                return res;
            if(root.word != null && root.word.length() > 0) {
                res.add(root.word);
            }
            for (TrieNode child : root.children) {
                res.addAll(getString(child));
            }
            return res;
    }
    class TrieNode {
        String word;
        List<TrieNode> children;
        public TrieNode (String word){
            this.word = word;
            children = new ArrayList<>();
        }
    }
}
