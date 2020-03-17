package App.test;

import App.reverseNStr;
import org.junit.Assert;
import org.junit.Test;

public class reverseNStrTest {

    reverseNStr reverse = new reverseNStr();

    @Test
    public void Test(){
        String source = "qwertyyui";
        int N = 3;
        System.out.println(reverse.reverseNstr(source, N));
        Assert.assertEquals(reverse.reverseNstr(source, N), "ewqytriuy");
        String ip = "1.2.3.4";
        ip = ip.replace(".", "[.]");
        System.out.println(ip);
    }
}
