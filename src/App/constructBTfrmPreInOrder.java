package App;

import java.util.HashMap;

public class constructBTfrmPreInOrder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> rootId = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            rootId.put(inorder[i], i);
        }
        return dfs(preorder, inorder, 0, 0, inorder.length - 1, rootId);
    }
    private TreeNode dfs(int[] preorder, int[] inorder, int preOrderIndex, int inOrderStart, int inOrderEnd, HashMap<Integer, Integer> rootId) {
        if(preOrderIndex == preorder.length || inOrderStart > inOrderEnd)
            return null;
        int val = preorder[preOrderIndex];
        TreeNode root = new TreeNode(val);
        int rootIndex = rootId.get(val);

        root.left = dfs(preorder, inorder, preOrderIndex + 1, inOrderStart, rootIndex - 1, rootId);
        root.right = dfs(preorder, inorder, preOrderIndex + rootIndex - inOrderStart + 1, rootIndex + 1, inOrderEnd, rootId);
        return root;
    }
}
