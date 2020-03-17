package App;
import java.util.*;
public class mergeInterval {
    static class comparator implements Comparator<Interval> {
        @Override
        public int compare(Interval a, Interval b) {
            return a.start - b.start;
        }
    }
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals.size() <= 1)
            return intervals;
        comparator comp = new comparator();
        PriorityQueue<Interval> queue = new PriorityQueue<>(comp);
        for (Interval unit : intervals) {
            queue.offer(unit);
        }
        List<Interval> res = new ArrayList<>();
        Interval prev = queue.poll();
        while(!queue.isEmpty()) {
            Interval next = queue.poll();
            if(prev.end < next.start) {
                res.add(prev);
                prev = next;
            }
            else {
                Interval merge = new Interval(prev.start, Math.max(prev.end, next.end));
                prev = merge;
            }
        }
        res.add(prev);
        return res;
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
