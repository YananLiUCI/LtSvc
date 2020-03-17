package App;

public class Read4N {
    char[] temp = new char[4];
    int bufPtr = 0;
    int bufCount = 0;
    int bufEnd = 0;

    public int read(char[] buf, int n) {
        int curPtr = 0;
        while(curPtr < n){
            if(bufCount == 0){
                bufCount = read4(temp);
                bufEnd = bufCount;
                bufPtr = 0;
            }
            if(bufCount == 0) break;

            while(bufPtr < bufEnd && curPtr < n){
                buf[curPtr++] = temp[bufPtr++];
                bufCount --;
            }
        }
        return curPtr;
    }
    public int read4(char[] temp){
        return 4;
    }
}
