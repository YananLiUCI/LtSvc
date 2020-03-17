package App;

public class lowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q)
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null)
            return root;
        else
            return left == null ? right : left;
    }
    public TreeNode lowestCommonAncestorII(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;

        if(root.val>p.val && root.val>q.val) return lowestCommonAncestorII(root.left, p, q);
        if(root.val<p.val && root.val<q.val) return lowestCommonAncestorII(root.right, p, q);

        return root;
    }
}
