package App.test;
import App.machinePrinter;
import org.junit.Test;
import App.machinePrinter.DLLNode;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;

public class machinePrinterTest {
    static machinePrinter machine1;
    static machinePrinter machine2;
    static machinePrinter machine3;
    static machinePrinter machine4;

    private static AtomicBoolean printTotal = new AtomicBoolean(false);
    @Test
    public void Test(){
        DLLNode node1 = new DLLNode(1, null, null);
        DLLNode node2 = new DLLNode(2, node1, null);
        DLLNode node3 = new DLLNode(3, node2, null);
        DLLNode node4 = new DLLNode(4, node3, null);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node1.writeDown =  new Semaphore(1);
        machinePrinter machine1 = new machinePrinter(node1, printTotal);
        machinePrinter machine2 = new machinePrinter(node2, printTotal);
        machinePrinter machine3 = new machinePrinter(node3, printTotal);
        machinePrinter machine4 = new machinePrinter(node4, printTotal);

        Thread a = new Thread(new printer(machine1));
        Thread b = new Thread(new printer(machine2));
        Thread c= new Thread(new printer(machine3));
        Thread d = new Thread(new printer(machine4));
        a.start();
        b.start();
        c.start();
        d.start();

    }
    class printer implements Runnable{

        private machinePrinter machine;

        public printer(machinePrinter machine) {
                this.machine = machine;
        }
        @Override
        public void run() {
            machine.printAll();
        }
    }
}
