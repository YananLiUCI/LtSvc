package App;
import java.util.*;
public class wordSearchII {
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = buildTrie(words);
        List<String> res = new ArrayList<String>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, root, i, j, res);
            }
        }
        return res;
    }
    private void dfs(char[][] board, TrieNode root, int x, int y, List<String> res) {

        char c = board[x][y];
        root = root.children[c - 'a'];
        if (root == null)
            return;
        board[x][y] = '#';
        if(root.word != null) {
            res.add(root.word);
            root.word = null;
        }

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        for (int i = 0;i < dx.length; i++) {
            int _x =  x + dx[i];
            int _y = y + dy[i];
            if(_x < 0 || _x >= board.length || _y < 0 || _y >= board[0].length || board[_x][_y] == '#')
                continue;
            dfs(board, root, x + dx[i], y + dy[i], res);
        }

        board[x][y] = c;
    }
    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();

        for (String word : words) {
            TrieNode p = root;
            for (char c : word.toCharArray()) {
                if(p.children[c - 'a'] == null)
                    p.children[c - 'a'] = new TrieNode();
                p = p.children[c - 'a'];
            }
            p.word = word;
        }

        return root;
    }
    private class TrieNode {
        String word;
        TrieNode[] children = new TrieNode[26];

    }
}
