package App;

public class addBinary {
    public String addBinary(String a, String b) {
        int carryOver = 0;
        int sta = a.length() - 1;
        int stb = b.length() - 1;
        StringBuilder res = new StringBuilder();
        while(sta >= 0 || stb >= 0) {
            int curr = 0;
            curr = curr + carryOver;
            if(sta >= 0) {
                curr = curr + a.charAt(sta) - '0';
                sta--;
            }
            if(stb >= 0) {
                curr = curr + b.charAt(stb) - '0';
                stb--;
            }
            res.append(String.valueOf(curr % 2));
            carryOver = curr / 2;
        }
        if(carryOver != 0) {
            res.append(carryOver);
        }
        return res.reverse().toString();
    }
}
