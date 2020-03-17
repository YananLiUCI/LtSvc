package App;

import java.util.Stack;

public class BTPostOrderIterator{
    Stack<TreeNode> stack;
    TreeNode cur;
    TreeNode prev;
    public BTPostOrderIterator(TreeNode root){
        stack = new Stack<>();
        cur = root;
        prev = null;
        if(cur != null) stack.push(cur);
    }
    public boolean hasNext(){
        return (!stack.isEmpty());
    }
    public TreeNode next(){
        TreeNode rst = null;

        while(!stack.isEmpty()){
            cur = stack.peek();
            if(prev == null || prev.left == cur || prev.right == cur){
                if(cur.left != null){
                    stack.push(cur.left);
                } else if(cur.right != null){
                    stack.push(cur.right);
                }
            } else if(cur.left == prev){
                if(cur.right != null) stack.push(cur.right);
            } else {
                rst = cur;
                stack.pop();
            }
            prev = cur;
            if(rst != null) break;
        }

        return rst;
    }
}