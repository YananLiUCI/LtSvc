package App;
import java.util.*;
public class perfectRectangle {
    class Node {
        int x;
        int y;
        Node(int _x, int _y) {
            x = _x;
            y = _y;
        }
        @Override
        public boolean equals(Object o) {
            if (o instanceof Node) {
                Node p = (Node)o;
                return this.x == p.x && this.y == p.y;
            }
            return false;
        }
        @Override
        public int hashCode() {
            int code = 1;
            code = code * 31 + x;
            code = code * 31 + y;
            return code;
        }
    }

    public boolean isRectangleCover(int[][] rectangles) {
        if (rectangles == null || rectangles.length == 0 || rectangles[0].length == 0) {
            return false;
        }
        Set<Node> set = new HashSet<>();
        int x1 = Integer.MAX_VALUE;
        int y1 = Integer.MAX_VALUE;
        int x2 = Integer.MIN_VALUE;
        int y2 = Integer.MIN_VALUE;
        int area = 0;

        for (int[] rect : rectangles) {
            x1 = Math.min(x1, rect[0]);
            y1 = Math.min(y1, rect[1]);
            x2 = Math.max(x2, rect[2]);
            y2 = Math.max(y2, rect[3]);

            Node s1 = new Node(rect[0], rect[1]);
            Node s2 = new Node(rect[0], rect[3]);
            Node s3 = new Node(rect[2], rect[3]);
            Node s4 = new Node(rect[2], rect[1]);

            if (!set.add(s1)) {
                set.remove(s1);
            }
            if (!set.add(s2)) {
                set.remove(s2);
            }
            if (!set.add(s3)) {
                set.remove(s3);
            }
            if (!set.add(s4)) {
                set.remove(s4);
            }
            area += ((rect[2] - rect[0]) * (rect[3] - rect[1]));
        }

        Node c1 = new Node(x1, y1);
        Node c2 = new Node(x1, y2);
        Node c3 = new Node(x2, y1);
        Node c4 = new Node(x2, y2);

        if (set.size() != 4 || !set.contains(c1) || !set.contains(c2) || !set.contains(c3) || !set.contains(c4)) {
            return false;
        }

        return area == (x2 - x1) * (y2 - y1);
    }
}
