package App;

public class reverseNStr {

    public String reverseNstr(String source, int N){

            char[] arr = source.toCharArray();
            for (int i = 0; i <= arr.length - N; i += N) {
                reverse(arr, i, i + N - 1);
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
