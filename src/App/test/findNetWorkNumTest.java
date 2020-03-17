package App.test;

import App.findNetWorkNum;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class findNetWorkNumTest {
    findNetWorkNum findPort = new findNetWorkNum();
    @Test
    public void test(){
        String ip = "1.2.3.4";
        List<String> ips = new ArrayList<>();
        ips.add("1.2.*");
        ips.add("255.*");
        ips.add("0.0.0.*");
        Assert.assertEquals(ips.get(0), findPort.findNetWorkNum(ips, ip));
        System.out.println(findPort.findNetWorkNum(ips, ip));

    }
}
