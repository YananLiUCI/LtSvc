package App;

public class DeserializeBinaryTree {
    public Node deserialize(String str) {
            if(str == null || str.length() == 0)
                return null;

            int[] index = new int[1];
            return dfs(str, index);
    }
    private Node dfs(String str, int[] index) {
        if(index[0] == str.length())
            return null;
        if(str.charAt(index[0]) == ' ') {
            index[0]++;
            return null;
        }
        Node root = new Node(str.charAt(index[0]));
        index[0]++;
        root.left = dfs(str, index);
        root.right = dfs(str, index);
        return root;
    }
}
