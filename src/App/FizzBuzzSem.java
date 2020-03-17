package App;
import java.util.*;
import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class FizzBuzzSem {
    private int n;
    private Semaphore fizzSem = new Semaphore(0);
    private Semaphore buzzSem = new Semaphore(0);
    private Semaphore fizzBuzzSem = new Semaphore(0);
    private Semaphore numSem = new Semaphore(1);

    public FizzBuzzSem(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        for(int i = 3; i <= n; i+=3) {
            fizzSem.acquire();
            if (i % 15 == 0) continue;
            printFizz.run();
            numSem.release();
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        for (int i = 5; i <= n; i+=5) {
            buzzSem.acquire();
            if (i % 15 == 0) continue;
            printBuzz.run();
            numSem.release();
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for (int i = 15; i <= n; i+=15) {
            fizzBuzzSem.acquire();
            printFizzBuzz.run();
            numSem.release();
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            numSem.acquire();
            if (i % 15 == 0)
                fizzBuzzSem.release();
            if (i % 3 == 0)
                fizzSem.release();
            if (i % 5 == 0)
                buzzSem.release();
            if (i % 3 != 0 && i % 5 != 0) {
                printNumber.accept(i);
                numSem.release();
            }
        }
    }
}
