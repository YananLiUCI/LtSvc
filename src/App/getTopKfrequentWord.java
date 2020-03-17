package App;

import java.util.*;

public class getTopKfrequentWord {
    public List<String> topKFrequent(String[] words, int k) {
        nComp comparator = new nComp();
        Queue<Node> queue = new PriorityQueue<>(comparator);
        HashMap<String, Integer> count = new HashMap<>();
        for (String word : words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : count.entrySet()) {
            queue.offer(new Node(entry.getKey(), entry.getValue()));
            if(queue.size() > k)
                queue.poll();
        }
        List<String> res = new ArrayList<>();
        while(!queue.isEmpty()) {
            res.add(queue.poll().word);
        }
        Collections.reverse(res);
        return res;
    }
    class Node {
        String word;
        int freq;
        public Node(String word, int freq) {
            this.word = word;
            this.freq = freq;
        }
    }
    class nComp implements Comparator<Node> {
        @Override
        public int compare(Node a, Node b) {
            if(a.freq != b.freq) {
                return a.freq - b.freq;
            }
            else {
                return b.word.compareTo(a.word);
            }
        }
    }
}
