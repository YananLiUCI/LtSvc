package App.test;

import App.StrCompression;
import org.junit.Assert;
import org.junit.Test;

public class StrCompressionTest {

        StrCompression strCompression = new StrCompression();

        @Test
        public void Test(){

            String org = "aaaabbbccdefg1234";
            String compress = strCompression.compression(org);
            System.out.println(compress);
            Assert.assertEquals(org, strCompression.deCompression(compress));
        }

}
