package App.test;
import App.findNextVisitCountry;
import org.junit.Assert;
import org.junit.Test;
public class findNextVisitCountryTest {

    findNextVisitCountry find = new findNextVisitCountry();

    @Test
    public void Test(){
        String[] history = {"US CA MX", "US CA CN", "US CA CN", "US CN", "US MX", "US CN", "US CN","US CN"};
        String path = "US CA";
        Assert.assertEquals(find.findNextVisitCountry(history, path), "CN");
        Assert.assertEquals(find.findNextVisitCountry(history, "US"), "CN");
    }

}
