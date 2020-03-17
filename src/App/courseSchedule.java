package App;
import java.util.*;
public class courseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for (int[] course : prerequisites) {
            if(!map.containsKey(course[1]))
                map.put(course[1], new ArrayList<Integer>());
            map.get(course[1]).add(course[0]);
            indegree[course[0]]++;
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0)
                queue.offer(i);
        }
        int visitedCount = 0;
        while(!queue.isEmpty()) {
            int curr = queue.poll();
            visitedCount++;
            if (map.containsKey(curr)) {
                for (int i : map.get(curr)) {
                    indegree[i]--;
                    if (indegree[i] == 0)
                        queue.offer(i);
                }
            }
        }
        if(visitedCount == numCourses)
            return true;
        return false;
    }
}
