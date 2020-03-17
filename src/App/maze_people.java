package App;
import java.util.*;
public class maze_people {
    // 0 block, x start, 1 pass;
    // edges are the exit.
    class Point {
        int x,y;
        public Point(int _x, int _y) {x=_x;y=_y;}
    }
    public boolean hasPath(int[][] maze, int[] start) {
        int m=maze.length, n=maze[0].length;
        if (start[0]==0 || start[0]==m - 1 || start[1]==0 ||start[1]== n - 1 ) return true;
        int[][] dir=new int[][] {{-1,0},{0,1},{1,0},{0,-1}};
        boolean[][] visited=new boolean[m][n];
        Queue<Point> queue=new LinkedList<>();
        visited[start[0]][start[1]]=true;
        queue.offer(new Point(start[0], start[1]));
        while (!queue.isEmpty()) {
            Point p=queue.poll();
            int x=p.x, y=p.y;
            for (int i=0;i<4;i++) {
                int xx = x + dir[i][0];
                int yy= y +dir[i][1];
               if(xx<0 || xx>= m || yy<0 || yy>=n || maze[xx][yy]==0) {
                    continue;
                }
                if (visited[xx][yy]) continue;
                visited[xx][yy]=true;
                if (xx==0 || xx == m - 1 || yy == 0 || yy == n - 1) return true;
                queue.offer(new Point(xx, yy));
            }
        }
        return false;

    }
    // for each block point record the shortest length to the exit
    // for person point record the shortest length to exit,
    // if the length for person to reach exit is shorter then person can exit.
    public boolean shortestDistance(char[][] maze, int[] start, int[] destination) {
        int m=maze.length, n=maze[0].length;
        int[][] length=new int[m][n]; // record length
        for (int i = 0; i < m; i++) {
            Arrays.fill(length[i], Integer.MAX_VALUE);
        }
        int[][] dir=new int[][] {{-1,0},{0,1},{1,0},{0,-1}};
        Queue<Point> queue=new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(maze[i][j] == '0') {
                    queue.offer(new Point(i, j));
                    length[i][j] = 0;
                }
            }
        }
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point curr = queue.poll();
                for (int j = 0; j < dir.length; j++) {
                    int x = curr.x + dir[i][0];
                    int y = curr.y + dir[i][1];
                    if(x < 0 || x >= m || y < 0 || y >= n || maze[x][y]== 'x') continue;
                    if(length[curr.x][curr.y] + 1 < length[x][y]) {
                        length[x][y] = length[curr.x][curr.y] + 1;
                        queue.offer(new Point(x, y));
                    }
                }
            }
        }
        length[start[0]][start[1]] = 0;
        queue.offer(new Point(start[0], start[1]));
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point curr = queue.poll();
                for (int j = 0; j < dir.length; j++) {
                    int x = curr.x + dir[i][0];
                    int y = curr.y + dir[i][1];
                    if(x < 0 || x >= m || y < 0 || y >= n || maze[x][y]== '0') continue;
                    if(length[curr.x][curr.y] + 1 < length[x][y]) {
                        length[x][y] = length[curr.x][curr.y] + 1;
                        if(x == 0 || x == m - 1 || y == 0 || y == n - 1)
                            return true;
                        queue.offer(new Point(x, y));
                    }
                }
            }
        }
        return false;
    }


}
