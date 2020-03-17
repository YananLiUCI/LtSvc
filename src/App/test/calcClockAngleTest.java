package App.test;

import App.calcClockAngle;
import org.junit.Test;

public class calcClockAngleTest {

        calcClockAngle calc = new calcClockAngle();

        @Test
        public void test(){

            String time = "10:10";
            System.out.println(calc.calcClockAngle(time));
            time = "0:10";
            System.out.println(calc.calcClockAngle(time));
        }

}
