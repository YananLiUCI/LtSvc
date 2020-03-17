package App;

public class flattenDoubleLinkedList {

    public void printFlattenList(Node node) {
        Node temp = node;
        dfsFlatten(temp);
    }
    private Node dfsFlatten(Node node) {
        //System.out.println(node.val);
        if(node.next == null && node.child == null)
            return node;
        if(node.child == null)
            return dfsFlatten(node.next);
        Node temp = node.next;
        node.next = node.child;
        node.next.prev = node;
        node.child = null;
        Node end = dfsFlatten(node.next);
        end.next = temp;
        if(temp != null){
            temp.prev = end;
            return dfsFlatten(temp);
        }
        else
            return end;

    }

    public static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
        public Node(int val, Node prev, Node next, Node child) {
            this.val = val;
            this.prev = prev;
            this.next = next;
            this.child = child;
        }

    }
}
