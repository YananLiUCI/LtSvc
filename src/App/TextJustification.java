package App;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int N = words.length;
        int right = 0;
        List<String> res = new ArrayList<String>();
        for (int left = 0; left < N; left = right) {
            int length = -1;
            for(right = left; right < N && length + words[right].length() + 1 <= maxWidth; right++) {
                length += words[right].length() + 1;
            }
            int space = 1;
            int extra = 0;
            if(right != left + 1 && right != N) {
                space = (maxWidth - length) / (right - left - 1) + 1;
                extra = (maxWidth - length) % (right - left - 1);
            }
            StringBuilder sb = new StringBuilder(words[left]);
            for (int i = left + 1; i < right; i++) {
                for (int j = 0; j < space; j++) sb.append(' ');
                if(extra-- > 0) sb.append(' ');
                sb.append(words[i]);
            }
            int rightSpace = maxWidth - sb.length();
            while(rightSpace-- > 0) sb.append(' ');
            res.add(sb.toString());
        }
        return res;
    }
}
