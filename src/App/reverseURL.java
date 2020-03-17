package App;
import java.util.*;
public class reverseURL{

    public String reverseURL(String url){

            char[] arr = url.toCharArray();
            reverse(arr, 0, arr.length - 1);
            int start = 0;
            while(start < arr.length) {
                int wordStart = start;
                while(start < arr.length && arr[start] != '.') {
                    start++;
                }
                reverse(arr, wordStart, start - 1);
                start++;
            }

            return String.valueOf(arr);

    }
    private void reverse(char[] arr, int start, int end) {

            while(start < end) {
                char temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }

    }
}