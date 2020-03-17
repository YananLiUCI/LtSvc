package App;
import java.util.*;
import org.junit.Test;
public class setOfStack {

    private int count;
    private int size;
    private List<fixedStack> stacks = new ArrayList<>();
    public setOfStack(int _size) {
        this.size = _size;
    }
    public boolean isEmpty(){
        return count == 0;
    }
    public void push(int val) {
        if(stacks.isEmpty()) {
            stacks.add(new fixedStack(size));
        }
        else if(stacks.get(stacks.size() - 1).count() == size) {
            stacks.add(new fixedStack(size));
        }
        fixedStack stack= stacks.get(stacks.size() - 1);
        stack.push(val);
        count++;
    }
    public Integer pop() {
        if(count == 0)
            return null;
        fixedStack stack = stacks.get(stacks.size() - 1);
        if(stack.count() == 0){
            stacks.remove(stacks.size() - 1);
        }
        stack = stacks.get(stacks.size() - 1);
        count--;
        return stack.pop();
    }
    public Integer popAt(int index){
        if(index > count)
            return null;
        index = count - index;
        int stId = index / size;
        int valId = index % size;
        fixedStack stack = stacks.get(stId);
        fixedStack temp = new fixedStack(size);
        if(valId == 0) {
            return stack.pop();
        }
        Integer res = null;
        while(valId >= 0) {
            res = stack.pop();
            if(valId != 0) {
                temp.push(res);
            }
            valId--;
        }
        while(stack.count() > 0) {
            temp.push(stack.pop());
        }
        while(temp.count() > 0) {
            stack.push(temp.pop());
        }
        count--;
        return res;
    }
}
class fixedStack{
    private int size;
    private ListNode head;
    private int count;
    public fixedStack(int _size) {
        this.size = _size;
    }
    // add To head;
    public void push(int val){
        ListNode curr = new ListNode(val);
        curr.next = head;
        head = curr;
        count++;
    }
    // remove from head;
    public Integer pop(){
        if(head == null)
            return null;
        ListNode next = head.next;
        Integer res = head.val;
        head.next = null;
        head = next;
        count--;
        return res;
    }
    public int count(){
        return this.count;
    }
}


