package App;
import java.util.*;
public class mergeKLists {
    class qComparator implements Comparator<ListNode> {
        @Override
        public int compare(ListNode a, ListNode b) {
            return a.val - b.val;
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0)
            return null;
        if(lists.length == 1)
            return lists[0];
        qComparator comparator = new qComparator();
        Queue<ListNode> queue = new PriorityQueue<>(comparator);
        ListNode res = new ListNode(0);
        ListNode head = res;
        for (int i = 0; i < lists.length; i++) {
            ListNode curr = lists[i];
            if(curr != null) {
                queue.offer(curr);
            }
        }
        while(!queue.isEmpty()) {
            ListNode curr = queue.poll();
            res.next = new ListNode(curr.val);
            res = res.next;
            if(curr.next != null)
                queue.offer(curr.next);
        }
        return head.next;
    }
    public ListNode mergeKListsII(ListNode[] lists) {
        if(lists == null || lists.length == 0 )
            return null;
        if(lists.length == 1)
            return lists[0];
        int interval = 1;
        while(interval < lists.length) {
            for (int i = 0; i + interval < lists.length; i = i + interval * 2) {
                lists[i] = mergeList(lists[i], lists[i + interval]);
            }
            interval = interval * 2;
        }
        return lists[0];
    }
    private ListNode mergeList(ListNode a, ListNode b) {
        ListNode head = new ListNode(0);
        ListNode curr = head;
        while(a != null && b != null) {
            if(a.val < b.val) {
                curr.next = a;
                a = a.next;
            }
            else {
                curr.next = b;
                b = b.next;
            }
            curr = curr.next;
        }
        if(a != null) {
            curr.next = a;
        }
        if(b != null) {
            curr.next = b;
        }
        return head.next;
    }
}
