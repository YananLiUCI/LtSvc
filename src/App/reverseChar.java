package App;

public class reverseChar {

    public char reverseChar(char num) {

            int[] binary = new int[8];
            for (int i = 0; i < binary.length; i++) {
                binary[i] = num & (1 << i);
            }

            int res = 0;

            for (int i = 0; i < binary.length; i++) {
                if(binary[i] == 0) {
                    res += (1 << i);
                }
            }
            return (char) (res);
    }
}
