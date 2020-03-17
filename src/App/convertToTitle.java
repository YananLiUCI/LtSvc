package App;

public class convertToTitle {
    public String convertToTitle(int n) {
        StringBuilder res = new StringBuilder();

        while(n > 0) {
            char next = (char)('A' + (n - 1) % 26);
            res.append(next);
            n = (n - 1) / 26;
        }
        res.reverse();
        return res.toString();
    }
}
