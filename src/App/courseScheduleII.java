package App;
import java.util.*;
public class courseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int[] order = new int[numCourses];
        if(prerequisites == null || prerequisites.length == 0) {
            for (int i = 0; i < numCourses; i++) {
                order[i] = i;
            }
            return order;
        }
        for (int i = 0; i < numCourses; i++) {
            map.put(i, new ArrayList<Integer>());
        }

        for(int i = 0; i < prerequisites.length; i++) {
            int node = prerequisites[i][0];
            int neighbor = prerequisites[i][1];
            indegree[node]++;

            map.get(neighbor).add(node);
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) {
                queue.offer(i);
                order[0] = i;
            }
        }
        int count = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                order[count] = curr;
                count++;
                for (int node : map.get(curr)) {
                    indegree[node]--;
                    if(indegree[node] == 0) {
                        queue.offer(node);

                    }
                }
            }
        }
        if(count != numCourses)
            return new int[0];
        return order;
    }
}
