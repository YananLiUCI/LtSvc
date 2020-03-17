package App;

public class isPalindrome {

    public boolean isPalindrome(String source) {
        if(source.length() <= 1)
            return true;
        int start = 0, end = source.length() - 1;
        source = source.toLowerCase();
        while(start < end) {
            while(start < end && !Character.isLetterOrDigit(source.charAt(start))){
                start++;
            }
            while(end > start && !Character.isLetterOrDigit(source.charAt(end))) {
                end--;
            }
            if(source.charAt(start) != source.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }


}


