package App;
import java.util.*;
public class LFUCache {
    class Node {
        int value;
        int count;
        public Node(int value, int count) {
            this.value = value;
            this.count = count;
        }
    }
    private int capacity;
    private int min;
    private HashMap<Integer, Node> cache;
    private HashMap<Integer, LinkedHashSet<Integer>> freqList;
    public LFUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        freqList = new HashMap<>();
        freqList.put(0, new LinkedHashSet<Integer>());
        min = -1;
    }

    public int get(int key) {
        if(capacity == 0)
            return -1;
        if(cache.containsKey(key)) {
            Node node = cache.get(key);
            node.count++;
            freqList.get(node.count - 1).remove(key);
            if(!freqList.containsKey(node.count)) {
                freqList.put(node.count, new LinkedHashSet<Integer>());
            }
            freqList.get(node.count).add(key);
            if(min == node.count - 1 && freqList.get(min).isEmpty()) {
                min = node.count;
            }

            return node.value;
        }
        else
            return -1;
    }

    public void put(int key, int value) {
        if(capacity <= 0)
            return;
        if (get(key) != -1) {
            Node node = cache.get(key);
            node.value = value;
            return;
        }
        if(cache.size() == capacity) {
            Integer evict = freqList.get(min).iterator().next();
            cache.remove(evict);
            freqList.get(min).remove(evict);
        }
        min = 0;
        cache.put(key, new Node(value, 0));
        freqList.get(0).add(key);
    }
}
