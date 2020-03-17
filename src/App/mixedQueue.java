
package App;
import java.util.*;
public class mixedQueue{
    private List blockingQueue = new LinkedList();
    private int  limit = 10;
    private List queue = new LinkedList();
    public mixedQueue(int limit){
        this.limit = limit;
    }

    public void enqueue(Object item) {
        if(queue.size() == limit)
            return;
        queue.add(item);
    }

    public Object dequeue() {
        if(queue.size() == 0)
            return null;
        return queue.remove(0);
    }
    public synchronized void enqueueBlocking(Object item)
            throws InterruptedException  {
        while(this.blockingQueue.size() == this.limit) {
            wait();
        }
        if(this.blockingQueue.size() == 0) {
            notifyAll();
        }
        this.blockingQueue.add(item);
    }


    public synchronized Object dequeueBlocking()
            throws InterruptedException{
        while(this.blockingQueue.size() == 0){
            wait();
        }
        if(this.blockingQueue.size() == this.limit){
            notifyAll();
        }

        return this.blockingQueue.remove(0);
    }
}