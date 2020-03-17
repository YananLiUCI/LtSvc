package App;

import java.util.function.IntConsumer;

public class FizzBuzzVol {
    private int n;
    private volatile int counter = 1;
    public FizzBuzzVol(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        synchronized(this){
            while(counter> 0 && counter<=n){
                if(counter%3 == 0 && counter%5 != 0){
                    printFizz.run();
                    counter++;
                    this.notifyAll();
                } else {
                    this.wait(10000);
                }
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        synchronized(this){
            while(counter> 0 && counter<=n){
                if(counter%3 != 0 && counter%5 == 0){
                    printBuzz.run();
                    counter++;
                    this.notifyAll();
                } else {
                    this.wait(10000);
                }
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        synchronized(this){
            while(counter> 0 && counter<=n){
                if(counter%3 == 0 && counter%5 == 0){
                    printFizzBuzz.run();
                    counter++;
                    this.notifyAll();
                } else {
                    this.wait(10000);
                }
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        synchronized(this){
            while(counter> 0 && counter<=n){
                if(counter%3 != 0 && counter%5 != 0){
                    printNumber.accept(counter);
                    counter++;
                    this.notifyAll();
                } else {
                    this.wait(10000);
                }
            }
        }
    }
}
