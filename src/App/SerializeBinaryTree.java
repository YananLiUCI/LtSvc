package App;

public class SerializeBinaryTree {

    public String serialize(Node root) {

        StringBuilder str = new StringBuilder();
        dfsHelper(str, root);
        return str.toString();
    }
    private void dfsHelper(StringBuilder str, Node root) {

        if(root == null) {
            str.append(' ');
            return;
        }
        str.append(root.val);
        dfsHelper(str, root.left);
        dfsHelper(str, root.right);
    }
}
