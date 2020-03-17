package App.test;

import App.FizzBuzzSem;
import App.FizzBuzzVol;
import org.junit.Before;
import org.junit.Test;
import sun.jvm.hotspot.runtime.Threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.IntConsumer;


public class FizzBuzzVolTest {

    private static int n = 15;
    static FizzBuzzVol fizzBuzzVol = new FizzBuzzVol(n);
    static Runnable printFizz;
    static Runnable printBuzz;
    static Runnable printFizzBuzz;
    static IntConsumer printNumber;
    @Before
    public void SetUp(){

        printFizz = new Thread(){
            @Override
            public void run() {
                System.out.print("Fizz," );
            }
        } ;
        printBuzz = new Thread() {
            @Override
            public void run() {
                System.out.print("Buzz," );
            }
        };
        printFizzBuzz = new Thread(){
            @Override
            public void run() {
                System.out.print("FizzBuzz," );
            }
        } ;
        printNumber = new IntConsumer() {
            @Override
            public void accept(int num) {
                System.out.print(num + "," );
            }
        };

    }

    @Test
    public void test() throws Exception{

        ExecutorService executor = Executors.newFixedThreadPool(10);

        Runnable worker = new numThread();
        Runnable worker2 = new fizzThread();
        Runnable worker3 = new buzzThread();
        Runnable worker4 = new fizzBuzzThread();
        executor.execute(worker);
        executor.execute(worker2);
        executor.execute(worker3);
        executor.execute(worker4);
        executor.shutdown();

        //System.out.println("Finished all threads");


    }

    class numThread implements Runnable {
        @Override
        public void run() {
            try {
                fizzBuzzVol.number(printNumber);

            }
            catch (Exception e) {}
        }
    }
    class fizzThread implements Runnable {
        @Override
        public void run() {
            try {
                fizzBuzzVol.fizz(printFizz);

            }
            catch (Exception e) {}
        }
    }
    class buzzThread implements Runnable {
        @Override
        public void run() {
            try {

                fizzBuzzVol.buzz(printBuzz);

            }
            catch (Exception e) {}
        }
    }
    class fizzBuzzThread implements Runnable {
        @Override
        public void run() {
            try {

                fizzBuzzVol.fizzbuzz(printFizzBuzz);
            }
            catch (Exception e) {}
        }
    }

}
