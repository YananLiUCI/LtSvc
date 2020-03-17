package App;
import java.util.*;
public class sortItemByGroupDependency {

    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems){
//contruct graph
        //only focus on dependency and indegree inside a specific group
        List<Integer>[] itemDependency = new ArrayList[n];
        int[] itemIndegree = new int[n];
        for (int i = 0; i < n; i++) {
            itemDependency[i] = new ArrayList<>();
        }
        //itemInGroup[i] stores all items in i-th group
        List<Integer>[] itemInGroup = new ArrayList[m];
        for (int i = 0; i < m; i++) {
            itemInGroup[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            if (group[i] != -1) {
                itemInGroup[group[i]].add(i);
            }
        }
        //only focus on dependency and indegree between groups
        //the group id can be negative, so I use Map rather than Array, and use Set in groupDependency to avoid  multiple increase of group indegree
        Map<Integer, Set<Integer>> groupDependency = new HashMap<>();
        Map<Integer, Integer> groupIndegree = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (group[i] == -1) {
                //each item with groupId == -1 can be seen as a unique group with groupId = -i-2 (-i-2 is chosen to avoid conflict with actual groupId)
                groupDependency.put(-i-2, new HashSet<>());
                groupIndegree.put(-i-2, 0);
            } else {
                if (!groupDependency.containsKey(group[i])) {
                    groupDependency.put(group[i], new HashSet<>());
                    groupIndegree.put(group[i], 0);
                }
            }
        }

        //two kinds of dependencies:
        //inside a specific group, one item may denpend on another item;
        //between groups, different groups may depend on each other;
        for (int i = 0; i < n; i++) {
            List<Integer> beforeList = beforeItems.get(i);
            for (int before : beforeList) {
                //if two groups belong to different groups, I only care about the group dependency between them
                //three situations(both belong to no groups, one of two belong to no groups, two belong to actual different groups)
                if (group[before] == -1 && group[i] == -1) { //both items belong to no group, they can be seen as two different groups
                    if (groupDependency.get(-before-2).add(-i-2)) {
                        groupIndegree.put(-i-2, groupIndegree.get(-i-2) + 1);
                    }
                } else if (group[before] == -1) {            //one of two belong to no group
                    if (groupDependency.get(-before-2).add(group[i])) {
                        groupIndegree.put(group[i], groupIndegree.get(group[i]) + 1);
                    }
                } else if (group[i] == -1) {                 //one of two belong to no group
                    if (groupDependency.get(group[before]).add(-i-2)) {
                        groupIndegree.put(-i-2, groupIndegree.get(-i-2) + 1);
                    }
                } else {                              //both items belong to some groups
                    if (group[before] != group[i]) {  //they belong to different groups, dependency between groups
                        if (groupDependency.get(group[before]).add(group[i])) {
                            groupIndegree.put(group[i], groupIndegree.get(group[i]) + 1);
                        }
                    } else {                          //they belong to the same group, dependency between different items inside the same group
                        itemDependency[before].add(i);
                        itemIndegree[i]++;
                    }
                }
            }
        }


        //push all groups with indegree == 0 to queue
        Queue<Integer> groupQue = new LinkedList<>();
        Queue<Integer> itemQue = new LinkedList<>();
        for (int groupId : groupIndegree.keySet()) {
            if (groupIndegree.get(groupId) == 0) {
                groupQue.offer(groupId);
            }
        }

        //cycle situation(1)
        if (groupQue.isEmpty()) {
            //System.out.println("there is a cycle between groups, and no group has indegree == 0");
            return new int[0];
        }

        boolean hasCycle = false;
        int[] res = new int[n];
        int index = 0;
        int groupCount = 0;     //count the groups I have visited, to decide if there is a cycle
        while (!groupQue.isEmpty()) {
            int curGroup = groupQue.poll();
            groupCount++;
            if (curGroup < 0) { //the item in this group belongs to no group, and itemId of this item is -(curGroup+2)
                res[index] = (-(curGroup+2));
                index++;
            } else {  //this is an actual group
                //push all items inside this group with indegree == 0 into queue
                for (int itemInCur : itemInGroup[curGroup]) {
                    if (itemIndegree[itemInCur] == 0) {
                        itemQue.offer(itemInCur);
                    }
                }

                //cycle situation(3)
                if (itemQue.isEmpty()) {
                    //System.out.println("there is a cycle inside curGroup and no item with indegree == 0");
                    hasCycle = true;
                    break;
                }

                int itemCount = 0;
                while (!itemQue.isEmpty()) {
                    int curItem = itemQue.poll();
                    res[index] = (curItem);
                    index++;
                    itemCount++;
                    for (int nextItem : itemDependency[curItem]) {
                        itemIndegree[nextItem]--;
                        if (itemIndegree[nextItem] == 0) {
                            itemQue.offer(nextItem);
                        }
                    }
                }

                //cycle situation(4)
                //the number of items we have visited is less than the total number of items in curGroup
                if (itemCount < itemInGroup[curGroup].size()) {
                    //System.out.println("there is a cycle inside curGroup although there are some itmes with indegree == 0");
                    hasCycle = true;
                    break;
                }
            }

            //decrease the indgree of groups which depends on curGroup by 1
            //after decrease, push "nextGroup" if his indegree is 0
            for (int nextGroup : groupDependency.get(curGroup)) {
                groupIndegree.put(nextGroup, groupIndegree.get(nextGroup) - 1);
                if (groupIndegree.get(nextGroup) == 0) {
                    groupQue.offer(nextGroup);
                }
            }


        }
        //cycyle situation(2)
        //the number of groups we have visited is less than the total number of groups
        if (groupCount < groupIndegree.keySet().size()) {
            //System.out.println("has cycle between groups although we there is some group with indegree == 0");
            hasCycle = true;
        }
        if (hasCycle) {
            //System.out.println("has a cycle, no solution");
            return new int[0];
        }


        return res;
    }
}
