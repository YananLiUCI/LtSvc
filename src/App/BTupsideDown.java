package App;

public class BTupsideDown {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        TreeNode prev = null;
        TreeNode temp = null;
        TreeNode curr = root;
        TreeNode next = null;
        while(curr != null) {
            next = curr.left;
            curr.left = temp;
            temp = curr.right;
            curr.right = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
