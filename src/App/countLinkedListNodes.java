package App;

public class countLinkedListNodes {

        public int countLinkedListNodes(ListNode head) {

                int count = 0;
                ListNode curr = head;
                while(curr != null) {
                    count++;
                    curr = curr.next;
                }
                return count;
        }
}
