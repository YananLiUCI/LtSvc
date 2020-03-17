package App.test;
import App.sentenceScreenFitting;
import org.junit.Test;

public class wordsTypingTest {
    sentenceScreenFitting fit = new sentenceScreenFitting();
    @Test
    public void Test(){
        String[]  sent = {"abc", "de","f" };
        fit.wordsTyping(sent, 4, 6);

    }
}
