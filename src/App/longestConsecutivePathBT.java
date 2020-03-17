package App;

public class longestConsecutivePathBT {
    public int max = 0;
    public int longestConsecutiveI(TreeNode root) {
        dfs(root, null, 0);
        return max;
    }
    private void dfs(TreeNode child, TreeNode parent, int length) {
        if(child == null)
            return ;
        length = (parent != null && child.val == parent.val + 1) ? length + 1 : 1;
        max = Math.max(max, length);
        dfs(child.left, child, length);
        dfs(child.right, child, length);
    }
    int maxval = 0;
    public int longestConsecutiveII(TreeNode root) {
        longestPath(root);
        return maxval;
    }
    public int[] longestPath(TreeNode root) {
        if (root == null)
            return new int[] {0,0};
        int inr = 1, dcr = 1;
        if (root.left != null) {
            int[] l = longestPath(root.left);
            if (root.val == root.left.val + 1)
                dcr = l[1] + 1;
            else if (root.val == root.left.val - 1)
                inr = l[0] + 1;
        }
        if (root.right != null) {
            int[] r = longestPath(root.right);
            if (root.val == root.right.val + 1)
                dcr = Math.max(dcr, r[1] + 1);
            else if (root.val == root.right.val - 1)
                inr = Math.max(inr, r[0] + 1);
        }
        maxval = Math.max(maxval, dcr + inr - 1);
        return new int[] {inr, dcr};
    }

}
