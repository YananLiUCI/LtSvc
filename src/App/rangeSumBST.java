package App;
import java.util.*;
public class rangeSumBST {
    public int rangeSumBST(TreeNode root, int L, int R) {
        return dfs(root, L, R);
    }
    private int dfs(TreeNode root, int left, int right) {
        if(root == null)
            return 0;
        if(root.val < left) {
            return dfs(root.right, left, right);
        }
        else if(root.val > right) {
            return dfs(root.left, left, right);
        }
        else {
            return root.val + dfs(root.left, left, right) + dfs(root.right, left, right);
        }

    }
    public int rangeSumBSTII(TreeNode root, int L, int R) {
        int ans = 0;
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                if (L <= node.val && node.val <= R)
                    ans += node.val;
                if (L < node.val)
                    stack.push(node.left);
                if (node.val < R)
                    stack.push(node.right);
            }
        }
        return ans;
    }
}
