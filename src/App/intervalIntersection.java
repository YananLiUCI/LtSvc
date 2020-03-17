package App;
import java.util.*;
public class intervalIntersection {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> temp = new ArrayList<>();
        int startA = 0, startB = 0;
        while(startA < A.length && startB < B.length) {
            int start = Math.max(A[startA][0], B[startB][0]);
            int end = Math.min(A[startA][1], B[startB][1]);
            if(start <= end) {
                temp.add(new int[]{start, end});

            }
            if(A[startA][1] < B[startB][1]) {
                startA++;
            }
            else{
                startB++;
            }
        }

        return temp.toArray(new int[temp.size()][]);
    }
    public List<Interval> intervalIntersection(List<List<Interval>> lists) {
            int[] ids = new int[lists.size()];
            List<Interval> res = new ArrayList<>();
            Queue<Node> queue = new PriorityQueue<>((a, b)->{return a.interval.start - b.interval.start;});
            for (int i = 0; i < lists.size(); i++) {
                Interval curr = lists.get(i).get(0);
                queue.offer(new Node(curr, i));
            }
            while(queue.size() > 1 ) {
                Node curr = queue.poll();
                Node next = queue.poll();
                int start = Math.max(curr.interval.start, next.interval.start);
                int end = Math.min(curr.interval.end, next.interval.end);
                if(start <= end) {
                    res.add(new Interval(start, end));
                }
                if(curr.interval.end < next.interval.end) {
                    ids[curr.id]++;
                    List<Interval> currList = lists.get(curr.id);
                    if(ids[curr.id] < currList.size()) {
                        queue.offer(new Node(currList.get(ids[curr.id]), curr.id));
                    }
                    queue.offer(next);
                }
                else{
                    ids[next.id]++;
                    List<Interval> nextList = lists.get(next.id);
                    if(ids[next.id] < nextList.size()) {
                        queue.offer(new Node(nextList.get(ids[next.id]), next.id));
                    }
                    queue.offer(curr);
                }

            }
            return res;
    }

    class Node {
        Interval interval;
        int id;
        public Node(Interval interval, int id) {
            this.interval = interval;
            this.id = id;
        }
    }
    class Interval {
        int start;
        int end;
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

}
