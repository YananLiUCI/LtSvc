package App.test;

import App.flattenDoubleLinkedList;
import App.flattenDoubleLinkedList.Node;
import org.junit.Test;

public class flattenDoubleLinkedListTest {
    @Test
    public void test(){
        Node node1 = new Node(1, null, null, null);
        Node node2 = new Node(2, null, null, null);
        Node node3 = new Node(3, null, null, null);
        Node node4 = new Node(4, null, null, null);
        Node node5 = new Node(5, null, null, null);
        Node node6 = new Node(6, null, null, null);
        Node node7 = new Node(7, null, null, null);
        Node node8 = new Node(8, null, null, null);
        node1.next = node2;
        node2.next = node3;
        node2.prev = node1;
        node3.next = node4;
        node4.prev = node3;

        node2.child = node5;
        node5.next = node6;
        node6.prev = node5;
        node6.next = node7;
        node7.prev = node6;
        node6.child = node8;

        flattenDoubleLinkedList flatten = new flattenDoubleLinkedList();
        flatten.printFlattenList(node1);
        Node temp = node1;
        Node prev = null;
        while(temp != null) {
            System.out.print(temp.val);
            if(temp.child != null) {
                System.out.println("*" + temp.child.val);
            }
            prev = temp;
            temp = temp.next;
        }
        System.out.println("*");
        while(prev != null) {
            System.out.print(prev.val);
            prev = prev.prev;

        }
    }
}
