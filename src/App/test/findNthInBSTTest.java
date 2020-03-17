package App.test;

import App.TreeNode;
import App.findNthInBST;
import org.junit.Test;

public class findNthInBSTTest {

    findNthInBST find = new findNthInBST();
    @Test
    public void Test(){
        TreeNode root = new TreeNode(4, 7);
        root.left = new TreeNode(2, 3);
        root.right = new TreeNode(6, 3);
        root.left.left = new TreeNode(1, 0);
        root.left.right = new TreeNode(3, 0);
        root.right.left = new TreeNode(5, 0);
        root.right.right = new TreeNode(7, 0);
        for (int i = 1; i <= 7; i++) {
            System.out.println(find.findNthInBST(root, i));
        }
        root.left.left = null;
        System.out.println(find.findNthInBST(root, 1));
        System.out.println(find.findNthInBST(root, 2));
    }
}
