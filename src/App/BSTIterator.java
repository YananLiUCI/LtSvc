package App;
import java.util.*;
public class BSTIterator {
    TreeNode curr;
    Stack<TreeNode> st = new Stack<>();
    public BSTIterator(TreeNode root) {
        curr = root;

    }

    /** @return the next smallest number */
    public int next() {
        int res = -1;
        if(hasNext()) {
            while(curr != null) {
                st.push(curr);
                curr = curr.left;
            }
            curr = st.pop();
            res = curr.val;
            curr = curr.right;
        }

        return res;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if(curr != null || !st.isEmpty())
            return true;
        return false;
    }
}
