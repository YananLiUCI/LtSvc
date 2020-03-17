package App;

public class reverseWord {
    public String reverseWords(String s) {
        s = s.trim();
        char[] arr = s.toCharArray();
        int index = 0;
        while(index < arr.length) {
            while(index < arr.length && arr[index] == ' ') index++;
            int wordStart = index;
            while(index < arr.length && arr[index] != ' ') index++;
            reverse(arr, wordStart, index - 1);
        }
        StringBuilder res = new StringBuilder();
        index = arr.length - 1;
        while(index >= 0) {
            while(index >= 0 && arr[index] == ' ') index--;
            while(index >= 0 && arr[index] != ' ') {
                res.append(arr[index--]);
            }
            if(index > 0)
                res.append(' ');
        }
        return res.toString();
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
