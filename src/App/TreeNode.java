package App;

public class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public int val;
    public int count;
    public TreeNode(int val){

        this.val = val;
    }
    public TreeNode(int val, int count) {
        this.val = val;
        this.count = count;
    }
}
