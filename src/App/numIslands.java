package App;
import java.util.*;
public class numIslands {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    count++;
                    grid[i][j] = '0';
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }
    private void dfs(char[][] grid, int x, int y) {
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || nx >= grid.length || ny < 0 || ny >= grid[0].length || grid[nx][ny] == '0')
                continue;
            grid[nx][ny] = '0';
            dfs(grid, nx, ny);
        }
    }
    public int numIslandsBFS(char[][] grid) {
        int num = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    num++;
                    queue.offer(new int[] {i, j});
                    int[] dx = {1, 0 , -1, 0};
                    int[] dy = {0, 1, 0, -1};
                    while(!queue.isEmpty()) {
                        int[] curr = queue.poll();

                        for (int k = 0; k < dx.length; k++) {
                            int nx = curr[0] + dx[k];
                            int ny = curr[1] + dy[k];
                            if(nx < 0 || nx >= grid.length || ny < 0 || ny >= grid[0].length || grid[nx][ny] == '0')
                                continue;
                            queue.offer(new int[] {nx, ny});
                            grid[nx][ny] = '0';
                        }
                    }
                }
            }
        }
        return num;
    }
}
