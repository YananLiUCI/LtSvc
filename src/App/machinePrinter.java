package App;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;

public class machinePrinter{

    private DLLNode node;

    private AtomicBoolean printTotal;

    public machinePrinter(DLLNode node, AtomicBoolean printTotal) {
        this.node = node;
        this.printTotal = printTotal;
    }
    public void printAll(){

          if(!hasUp()) {
              writeDown(2);
              while(!printTotal.get()) {
              }
              int total = readDown();
              System.out.println("Total Num First: " + total);
          }
          else {
              int count = readUp();
              if(hasDown()) {
                  writeDown(count + 1);
                  while(!printTotal.get()) {
                  }
                  int total = readDown();
                  writeUp(total);
                  System.out.println(node.id + " Total Num : " + total);
              }
              else {
                  try {
                      node.writeDown.acquire();
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }
                  node.writeUp.release();// change to up

                  int total = node.count + 1;
                  writeUp(total);
                  System.out.println("Total Num Last: " + total);
                  printTotal.set(true);

              }
          }

    }

    public void writeUp(int count) {

        try {
            node.writeUp.acquire();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        node.count = count;
        node.prev.count = count;
        node.prev.readDown.release();
    }


    public void writeDown(int count) {
        try {
            node.writeDown.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        node.next.count = count;
        node.next.readUp.release();

    }


    public int readUp() {

        try {
            node.readUp.acquire();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        node.writeDown.release();
        return node.prev.count;
    }


    public int readDown() {
        try {
            node.readDown.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        node.writeUp.release();

        return node.next.count;
    }


    public boolean hasUp() {
        return node.prev != null;
    }


    public boolean hasDown() {
        return node.next != null;
    }
    public static class DLLNode{
        int id;
        int count;
        public DLLNode prev;
        public DLLNode next;
        public Semaphore readUp = new Semaphore(0);
        public Semaphore writeDown = new Semaphore(0);
        public Semaphore writeUp = new Semaphore(0);
        public Semaphore readDown = new Semaphore(0);
        public DLLNode(int id, DLLNode prev, DLLNode next) {
            this.id = id;
            this.prev = prev;
            this.next = next;
        }
    }
}
