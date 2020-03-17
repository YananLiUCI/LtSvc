package App.test;

import App.reverseChar;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class reverseCharTest {
    reverseChar reverse = new reverseChar();
    @Test
    public void test(){
        char num = 0x1;
        System.out.println(binary(num)  + ":");
        System.out.println(binary(reverse.reverseChar(num)));
    }
    private List<Integer> binary(char num){

        List<Integer> list = new ArrayList<>();
        for (int i = 7; i >= 0; i--) {
            if((num & (1 << i)) != 0)
            list.add(1);
            else
                list.add(0);
        }
        return  list;
    }

}
