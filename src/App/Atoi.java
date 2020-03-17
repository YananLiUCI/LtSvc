package App;

import java.util.LinkedList;

public class Atoi {
    public int myAtoi(String str) {
        int start = 0;
        while (start < str.length()) {
            if(str.charAt(start) == ' ')
                start++;
            else
                break;
        }
        if (start == str.length())
            return 0;
        int sign = 1;
        if(str.charAt(start) == '+') {
            start++;
        }
        else if (str.charAt(start) == '-') {
            start++;
            sign = -1;
        }
        if(start == str.length() || !Character.isDigit(str.charAt(start)))
            return 0;
        long num = 0;
        while (start < str.length() && Character.isDigit(str.charAt(start))) {
            int digi = str.charAt(start) - '0';
            num = num * 10 + digi;
            start++;
            if(num * sign > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            if (num * sign < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
        }
        LinkedList<Integer> a = new LinkedList<>();
        while(!a.isEmpty()) {
            int val = a.removeFirst();
        }
        return (int)num * sign;


    }

}
