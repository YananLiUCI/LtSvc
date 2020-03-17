package App.test;

import App.randomStrGenerator;
import org.junit.Assert;
import org.junit.Test;

public class randomStrGeneratorTest {

    randomStrGenerator generator = new randomStrGenerator();
    private static int length = 7;
    @Test
    public void generateRandomStr() {
        System.out.println(generator.generateRandomStr(length));
    }

    @Test
    public void generateRandomAlphaStr() {
        String str = generator.generateRandomAlphaStr(length);
        System.out.println(str);
        Assert.assertEquals(str.length(), length);
        char[] arr = str.toCharArray();
        for (char c : arr) {
            Assert.assertTrue(Character.isLowerCase(c));
        }

    }
}