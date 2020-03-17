package App;
import java.util.*;
public class numIslandsUF {
    // if graph is needs to split in machine, put the split edge relation in hashmap and do the uf based on the split edges relation.
    private class WeightedUnionFind{
        HashMap<Integer, Integer> parent;
        HashMap<Integer, Integer> size;
        int count;

        public WeightedUnionFind(char[][] grid){
            parent = new HashMap<Integer, Integer>();
            size = new HashMap<Integer, Integer>();
            count = 0;
            int rows = grid.length;
            int cols = grid[0].length;

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if(grid[i][j] == '1') {
                        add(i * cols + j);
                    }
                }
            }
        }

        public Integer find(Integer index){
            if(!parent.containsKey(index)) return null;

            Integer root = index;
            while(root != parent.get(root)){
                root = parent.get(root);
            }
            while(index != root){
                Integer next = parent.get(index);
                parent.put(index, root);
                index = next;
            }
            return root;
        }

        public void union(Integer a, Integer b){
            Integer aRoot = find(a);
            Integer bRoot = find(b);
            if(aRoot == null || bRoot == null) return;
            if(aRoot.equals(bRoot)) return;

            int aSize = size.get(aRoot);
            int bSize = size.get(bRoot);

            if(aSize > bSize){
                parent.put(bRoot, aRoot);
                size.put(aRoot, aSize + bSize);
            } else {
                parent.put(aRoot, bRoot);
                size.put(bRoot, aSize + bSize);
            }
            count --;
        }

        public void add(Integer index){
            if(!parent.containsKey(index)){
                parent.put(index, index);
                size.put(index, 1);
                count ++;
            }
        }

        public int getCount(){
            return this.count;
        }

    }


    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0)
            return 0;
        WeightedUnionFind uf = new WeightedUnionFind(grid);
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int rows = grid.length;
        int cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(grid[i][j] == '1') {
                    for (int k = 0; k < 4; k++) {
                        int x = i + dx[k];
                        int y = j + dy[k];
                        if(x < 0 || x >= rows || y < 0 || y >= cols || grid[x][y] == '0')
                            continue;
                        else {
                            uf.union(i * cols + j, x * cols + y);
                        }
                    }
                }
            }
        }
        return uf.count;
    }
}
