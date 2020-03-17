package App;

public class balancedStringSplit {
    public int balancedStringSplit(String s) {
        int lcount=0;
        int rcount=0;
        int count=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='L')
                lcount++;
            else rcount++;

            if(lcount==rcount)
            {
                count++;
            }

        }
        return count;
    }
}
