package App;

import java.util.*;

public class packageInstallOrder {
    Map<String, String[]> packages;
    public packageInstallOrder(Map<String, String[]> packages) {
        this.packages = packages;
    }
    public String[] installOrder(String target) {

            String[] order = new String[packages.size()];
            HashMap<String, Integer> indegree = new HashMap<>();
            HashMap<String, List<String>> dependency = new HashMap<>();
            for (Map.Entry<String, String[]> entry : packages.entrySet()) {
                String[] preRequite = entry.getValue();
                String curr = entry.getKey();
                if(!indegree.containsKey(curr)) {
                    indegree.put(curr, 0);
                }
                if(preRequite == null || preRequite.length == 0) {
                    continue;
                }
                indegree.put(curr, indegree.get(curr) + preRequite.length);
                for (String required : preRequite) {
                    if(!dependency.containsKey(required)){
                        dependency.put(required, new ArrayList<>());
                    }
                    dependency.get(required).add(curr);
                }
            }
            Queue<String> queue = new LinkedList<String>();
            HashSet<String> visited = new HashSet<>();
            for (Map.Entry<String, Integer> entry : indegree.entrySet()) {
                String pack = entry.getKey();
                Integer count = entry.getValue();
                if(count == 0) {
                    queue.offer(pack);
                }
            }
            int index = 0;
            while(!queue.isEmpty()) {
                String curr = queue.poll();
                order[index] = curr;
                index++;
                visited.add(curr);
                if(!dependency.containsKey(curr)) continue;
                for (String next : dependency.get(curr)) {
                    indegree.put(next, indegree.get(next) - 1);
                    if(visited.contains(next))
                        return null;
                    if(indegree.get(next) == 0) {
                        queue.offer(next);
                        if(next == target)
                            return order;
                    }
                }
            }
            return order;
    }
}
