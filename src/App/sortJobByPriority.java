package App;

import java.util.*;
public class sortJobByPriority {
    HashMap<Job, List<Job>> jobGraph;
    HashMap<Job, Integer> jobPriority;
    HashMap<Job, Integer> indegree;
    public sortJobByPriority(){
        jobGraph = new HashMap<>();
        jobPriority = new HashMap<>();
    }
    public void insertTask(Job job, int priority, Set<Job> dependencies) {
        
            for (Job parent : dependencies) {
                if(!jobGraph.containsKey(parent)){
                    jobGraph.put(parent, new ArrayList<>());
                }
                jobGraph.get(parent).add(job);
                if(!indegree.containsKey(parent)) {
                    indegree.put(parent, 0);
                }
                if(!jobPriority.containsKey(parent)){
                    jobPriority.put(parent, Integer.MIN_VALUE);
                }
            }
            jobPriority.put(job, priority);
            indegree.put(job, indegree.getOrDefault(job, 0) + dependencies.size());
    }
    public void runAllTasks(){

        PriorityQueue<Job> queue = new PriorityQueue<>((a,b)->{return jobPriority.getOrDefault(a, Integer.MIN_VALUE) - jobPriority.getOrDefault(b, Integer.MIN_VALUE);});
        for (Map.Entry<Job, Integer> entry : indegree.entrySet()) {
            if(entry.getValue() == 0) {
                queue.offer(entry.getKey());
            }
        }
        while(!queue.isEmpty()) {

            Job curr = queue.poll();
            curr.run();
            if(!jobGraph.containsKey(curr))
                continue;
            List<Job> children = jobGraph.get(curr);
            for (Job child : children) {
                indegree.put(child, indegree.get(child) - 1);
                if(indegree.get(child) == 0) {
                    queue.offer(child);
                }
            }
        }
        
    }
   
    
    class Job {
        int id;
        public Job (int id){
            this.id = id;
        }
        public void run(){
            
        }
    }
}
