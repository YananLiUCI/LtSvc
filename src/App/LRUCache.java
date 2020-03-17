package App;
import java.util.*;
public class LRUCache {
    HashMap<Integer, Node> map = new HashMap<>();
    Node head;
    Node tail;
    int max_capacity;
    public LRUCache(int capacity) {
        this.max_capacity = capacity;
    }

    public int get(int key) {
        if(!map.containsKey(key))
            return -1;
        Node curr = map.get(key);
        moveToHead(curr);
        return curr.val;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)) {
            Node curr = map.get(key);
            curr.val = value;
            moveToHead(curr);
            return;
        }
        if(map.size() == max_capacity) {
            int removeKey = removeFromTail();
            map.remove(removeKey);
        }
        Node curr = new Node(key, value, null, null);
        addToHead(curr);
        map.put(key, curr);
    }
    private void moveToHead(Node node) {
        if(head == node)
            return;
        Node next = node.next;
        Node prev = node.prev;
        if(next == null) {
            tail = prev;
        }
        else
            next.prev = prev;
        prev.next = next;

        addToHead(node);
    }
    private void addToHead(Node node) {
        if(head == null) {
            head = node;
            tail = node;
            return;
        }
        node.next = head;
        head.prev = node;
        head = node;
    }
    private  int removeFromTail() {
        int key = tail.key;
        if(head == tail) {
            head = null;
            tail = null;
            return key;
        }
        Node prev = tail.prev;
        prev.next = null;
        tail = prev;
        return key;

    }
    class Node {
        int val;
        int key;
        Node prev;
        Node next;
        public Node(int key, int val, Node prev, Node next) {
            this.key = key;
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }
}
