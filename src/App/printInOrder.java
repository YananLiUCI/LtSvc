package App;

import java.util.concurrent.Semaphore;

public class printInOrder {
    private Semaphore sem1 = new Semaphore(1);
    private Semaphore sem2 = new Semaphore(0);
    private Semaphore sem3 = new Semaphore(0);
    public printInOrder() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        try{
            sem1.acquire();
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            sem2.release();
        }
        catch(Exception e) {

        }

    }

    public void second(Runnable printSecond) throws InterruptedException {

        try{
            sem2.acquire();
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            sem3.release();
        }
        catch(Exception e) {

        }

    }

    public void third(Runnable printThird) throws InterruptedException {
        try{
            sem3.acquire();
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
            sem1.release();
        }
        catch(Exception e) {

        }

    }
}
