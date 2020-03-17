package App;
import java.util.*;
public class binaryTreeColoring {
    int left, right, val;
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        val = x;
        find(root);
        return Math.max(Math.max(left, right), n - left - right - 1) > n / 2;
    }

    private boolean find(TreeNode root){
        if(root == null) return false;
        if(root.val == val){
            left = count(root.left);
            right = count(root.right);
            return true;
        }
        return find(root.left) || find(root.right);
    }

    private int count(TreeNode root){
        if(root == null) return 0;
        return 1 + count(root.left) + count(root.right);
    }
    // follow up : you are the first one to pick up node
    // assume: Add field count in TreeNode
    static TreeNode start = null;
    int total;
    public TreeNode findPrimary(TreeNode root, int n) {

            total = n;
            dfs(root);
            return start;

    }
    private int dfs(TreeNode root) {
        if(root == null)
            return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        root.count = 1 + left + right;
        if( Math.max(Math.max(left, right), total - left - right - 1) < total / 2) {
            start = root;
        }
        return root.count;
    }
}
