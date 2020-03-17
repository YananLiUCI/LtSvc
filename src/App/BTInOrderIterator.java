package App;

import java.util.Stack;

public class BTInOrderIterator{
    Stack<TreeNode> stack;
    TreeNode cur;
    public BTInOrderIterator(TreeNode root) {
        stack = new Stack<TreeNode>();
        cur = root;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return (!stack.isEmpty() || cur != null);
    }

    /** @return the next smallest number */
    public int next() {
        while(cur != null){
            stack.push(cur);
            cur = cur.left;
        }
        TreeNode node = stack.pop();
        cur = node.right;
        return node.val;
    }
}