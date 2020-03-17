package App;

import java.util.*;

public class randomPickNode {

    public List<Node> getRandomNode(List<Node> list, int num) {

        if(list == null || list.size() <= num)
            return list;
        List<Node> res = new ArrayList<>();
        HashMap<Integer, List<Node>> count = new HashMap<>();
        for (Node node : list) {
            if(!count.containsKey(node.getMachine())){
                count.put(node.getMachine(), new ArrayList<>());
            }
            count.get(node.getMachine()).add(node);
        }
        for (Map.Entry<Integer, List<Node>> entry : count.entrySet()) {
            int pick = entry.getValue().size()/list.size() * num;
            Node[] stream = new Node[entry.getValue().size()];
            stream = entry.getValue().toArray(stream);
            res.addAll(Arrays.asList(selectKItems(stream, entry.getValue().size(), pick)));
        }
        return res;
    }
    private static Node[] selectKItems(Node stream[], int n, int k)
    {
        int i;   // index for elements in stream[]

        // reservoir[] is the output array. Initialize it with
        // first k elements from stream[]
        Node reservoir[] = new Node[k];
        for (i = 0; i < k; i++)
            reservoir[i] = stream[i];

        Random r = new Random();

        // Iterate from the (k+1)th element to nth element
        for (; i < n; i++)
        {
            // Pick a random index from 0 to i.
            int j = r.nextInt(i + 1);

            // If the randomly  picked index is smaller than k,
            // then replace the element present at the index
            // with new element from stream
            if(j < k)
                reservoir[j] = stream[i];
        }
        return reservoir;
    }
    class Node {
        private int id;
        public int getMachine() {
            return id;
        }
    }
}
