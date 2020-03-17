package App.test;

import App.DatesDiff;
import org.junit.Test;

public class DatesDiffTest {
    DatesDiff diff = new DatesDiff();
    @Test
    public void test(){
        String date1 = "04241990";
        String curr = "12252019";
        String date2 = "01091990";
        System.out.println(diff.datesDiff(date1,date2));
        System.out.println(diff.datesDiff(curr,date1));
        System.out.println(diff.datesDiff(curr,date2));
        System.out.println(diff.datesDiff(curr,date2) - diff.datesDiff(curr,date1));

    }
}
