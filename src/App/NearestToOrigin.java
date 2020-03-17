package App;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class NearestToOrigin {

    public void setNearestToOrigin(Object origin) {

        Queue<Object> queue = new LinkedList<>();
        queue.offer(origin);
        HashSet<Object> visited = new HashSet<>();

        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Object curr = queue.poll();
                visited.add(curr);
                if(curr.left.state != State.Empty && !visited.contains(curr.left) && curr.left.state != State.Blocked) {
                    curr.left.nextObjectToOrigin = curr;
                    queue.offer(curr.left);
                }
                if(curr.right.state != State.Empty && !visited.contains(curr.right) && curr.right.state != State.Blocked) {
                    curr.right.nextObjectToOrigin = curr;
                    queue.offer(curr.right);
                }
                if(curr.top.state != State.Empty && !visited.contains(curr.top) && curr.top.state != State.Blocked) {
                    curr.top.nextObjectToOrigin = curr;
                    queue.offer(curr.top);
                }
                if(curr.down.state != State.Empty && !visited.contains(curr.down) && curr.down.state != State.Blocked) {
                    curr.down.nextObjectToOrigin = curr;
                    queue.offer(curr.down);
                }
            }
        }
    }

    class Object {
        Object left;
        Object right;
        Object top;
        Object down;
        Object nextObjectToOrigin;
        State state;

    }
    enum State {
        Origin,
        Empty,
        Blocked,
    }
}
