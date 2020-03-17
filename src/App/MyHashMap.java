package App;

public class MyHashMap {
    class Node {
        int key;
        int value;
        Node next;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    Node[] map = new Node[10000];
    private int getIndex(int key) {
        return Integer.hashCode(key) % map.length;
    }
    private Node getPre(Node node, int key) {
        Node prev = null;
        while(node != null && node.key != key) {
            prev = node;
            node = node.next;
        }
        return prev;
    }
    public MyHashMap() {

    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = getIndex(key);
        if(map[index] == null) map[index] = new Node(-1, -1);
        Node prev = getPre(map[index], key);
        if(prev.next == null) prev.next = new Node(key, value);
        else
            prev.next.value = value;

    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = getIndex(key);
        if(map[index] == null) return -1;
        Node prev = getPre(map[index], key);
        if(prev.next == null) return -1;
        return prev.next.value;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = getIndex(key);
        if(map[index] == null) return;
        Node prev = getPre(map[index], key);
        if(prev.next == null) return;
        prev.next = prev.next.next;
    }
}
