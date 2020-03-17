package App.test;

import App.setOfStack;
import org.junit.Test;

public class setOfStackTest {
    int size = 3;
    setOfStack stack = new setOfStack(size);
    @Test
    public void test(){

        for (int i = 5; i> 0; i--) {
            stack.push(i);
            if(i % 2 == 0){
                //stack.pop();
            }
        }
        stack.popAt(4);
        while(!stack.isEmpty()) {
            System.out.print(stack.pop());
        }

    }
}
