package App;

public class findNthDigit {
    /*

Straight forward way to solve the problem in 3 steps:

find the length of the number where the nth digit is from
find the actual number where the nth digit is from
find the nth digit and return

length  = i total number is i * 9 * 10 ^(i-1)
*/
    public int findNthDigit(int n) {
        int start = 1;
        int len = 1;
        long base = 9;
        while( n > len * base ){    //判断n落在的区间
            n = n - len * (int)base;
            len++;              //len 用来记录target 数的长度
            start *= 10;        //循环的时候不用，等会用来重组target 数
            base *= 10;
        }
        int target = start + (n - 1)/len;   //减1是因为start 自己算一个数，要把start 从计算中抠掉
        int reminder = (n - 1)%len;         //在target 中的位置
        return Character.getNumericValue( Integer.toString(target).charAt(reminder) );
    }
}
