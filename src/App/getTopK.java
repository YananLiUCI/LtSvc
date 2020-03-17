package App;

import java.util.*;

public class getTopK {

    public class qComparator implements Comparator<Node> {
        @Override
        public int compare(Node o1, Node o2) {
            return (int) Math.abs(o1.dis - o2.dis);
        }
    }
    public List<Double> getTopK(List<Double> nums, double target, int k) {
            if(nums.size() <= k)
                return nums;
            List<Double> res = new ArrayList<>();
            Queue<Node> queue = new PriorityQueue<Node>((a,b) ->{ return (int) Math.abs(b.dis-a.dis);});
            for (Double num : nums) {
                queue.offer(new Node(num, Math.abs(num - target)));
                if(queue.size() > k)
                    queue.poll();
            }
            while(!queue.isEmpty()) {
                Node curr = queue.poll();
                res.add(curr.val);
            }
            return res;
    }
    class Node {
        double val;
        double dis;
        public Node(double data, double distance) {
            this.val = data;
            this.dis = distance;
        }
    }
}
