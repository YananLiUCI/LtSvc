package App;
import java.util.*;

public class BTtraverse {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root != null) stack.push(root);

        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            list.add(node.val);
            // Remember to reverse order.. right -> left
            if(node.right != null) stack.push(node.right);
            if(node.left != null) stack.push(node.left);
        }

        return list;
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();

        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode node = stack.pop();
            list.add(node.val);
            cur = node.right;
        }

        return list;
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();

        TreeNode cur = root;
        TreeNode prev = null;
        if(root != null) stack.push(root);

        while(!stack.isEmpty()){
            cur = stack.peek();

            // cur 在 prev 下面，要尝试探索所有 cur 下面的节点
            // 如果 cur 是叶节点的话，会在最后把 prev 赋值成 cur，再下一轮的时候被 pop 掉。
            if(prev == null || prev.left == cur || prev.right == cur){
                if(cur.left != null){
                    stack.push(cur.left);
                } else if(cur.right != null){
                    stack.push(cur.right);
                }
            } else if(cur.left == prev){
                // 刚把左边处理完回来，看看右边还有没有节点
                if(cur.right != null) stack.push(cur.right);
            } else {
                // 左右子树都处理完了，处理当前节点。
                list.add(cur.val);
                stack.pop();
            }
            prev = cur;
        }

        return list;
    }
}
