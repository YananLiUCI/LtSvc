package App;

public class findNthInBST {

    public int findNthInBST(TreeNode root, int N) {
        if(root.count == 0)
            return root.val;
        if(root.left == null) {
            if(N == 1) return root.val;
            return findNthInBST(root.right, N - 1);
        }
        else if(root.right == null) {
            if(root.count == N)
                return root.val;
            return findNthInBST(root.left, N - 1);
        }
        else {
            if(root.left.count == 0) {
                switch(N) {
                    case 1:
                        return root.left.val;
                    case 2:
                        return root.val;
                    case 3:
                        return root.right.val;
                }
            }
            if(root.left.count >= N) {
                return findNthInBST(root.left, N);
            }
            else if(root.left.count == N - 1)
                return root.val;
            else {
                return findNthInBST(root.right, N - root.left.count - 1);
            }
        }
    }

}
