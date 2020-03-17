package App.test;
import App.packageInstallOrder;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class packageInstallOrderTest {

    Map<String, String[]> packages = new HashMap<>();
    packageInstallOrder order = new packageInstallOrder(packages);
    @Before
    public void SetUp(){
        packages.put("A", null);
        packages.put("B", new String[]{"A"});
        packages.put("C", new String[]{"A"});
        packages.put("D", new String[]{"B", "C"});
    }


    @Test
    public void installOrder(){
        String[] res = order.installOrder("D");
        for (String curr : res)
        System.out.println(curr);
    }
}
