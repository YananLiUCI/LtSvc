package App;

public class constructQuadTree {
    public Node construct(int[][] grid) {
        return constructNode(grid, 0, 0, grid.length);
    }
    public Node constructNode(int[][] grid, int y, int x, int n) {
        Node node = new Node();
        if (isUniform(grid, y, x, n)) {
            node.val = grid[y][x] == 1;
            node.isLeaf = true;
        }
        else {
            node.topLeft = constructNode(grid, y, x, n/2);
            node.topRight = constructNode(grid, y, x+n/2, n/2);
            node.bottomLeft = constructNode(grid, y+n/2, x, n/2);
            node.bottomRight = constructNode(grid, y+n/2, x+n/2, n/2);
        }
        return node;
    }

    public boolean isUniform(int[][] grid, int y, int x, int n) {
        int value = grid[y][x];
        for (int i = y; i < y+n; i++) {
            for (int j = x; j < x+n; j++) {
                if (grid[i][j] != value) return false;
            }
        }
        return true;
    }
    public Node intersect(Node quadTree1, Node quadTree2) {
        Node res = new Node();
        if(quadTree1 == null || quadTree2 == null)
            return null;
        if(quadTree1.isLeaf && quadTree2.isLeaf) {
            res.isLeaf = true;
            res.val = quadTree1.val || quadTree2.val;
        }
        else if (quadTree1.isLeaf) {
            res = quadTree1.val ? quadTree1: quadTree2;
        }
        else if (quadTree2.isLeaf) {
            res = quadTree2.val ?  quadTree2: quadTree1;
        }
        else {
            res.isLeaf = false;
            res.val = quadTree1.val || quadTree2.val;
            res.topLeft = intersect(quadTree1.topLeft, quadTree2.topLeft);
            res.topRight = intersect(quadTree1.topRight, quadTree2.topRight);
            res.bottomLeft = intersect(quadTree1.bottomLeft, quadTree2.bottomLeft);
            res.bottomRight = intersect(quadTree1.bottomRight, quadTree2.bottomRight);
        }
        if(!res.isLeaf && isUniform(res)){
            res.isLeaf = true;
            res.val = res.topLeft.val;
        }
        return res;

    }
    private boolean isUniform(Node root) {

        if(root.topLeft.isLeaf && root.topRight.isLeaf && root.bottomLeft.isLeaf && root.bottomRight.isLeaf) {
            boolean val = root.topLeft.val;
            if(val == root.topRight.val && val == root.bottomLeft.val && val == root.bottomRight.val)
                return true;
        }
        return false;
    }
    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;

        public Node() {}

        public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
            val = _val;
            isLeaf = _isLeaf;
            topLeft = _topLeft;
            topRight = _topRight;
            bottomLeft = _bottomLeft;
            bottomRight = _bottomRight;
        }
    };
}
