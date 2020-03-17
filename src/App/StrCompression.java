package App;

public class StrCompression {

        public String compression(String source) {

                char numStart = (char)129;
                char strStart = (char)130;
                StringBuilder res = new StringBuilder();
                int start = 0;
                while(start < source.length()) {
                    int i = start;
                    while(i < source.length() && source.charAt(i) == source.charAt(start)) {
                        i++;
                    }
                    if(i - start> 2) {
                        res.append(i - start);
                        res.append(numStart);
                        res.append(source.charAt(start));
                    }
                    else {
                        while(i < source.length() && source.charAt(i - 1) != source.charAt(i)) {
                            i++;
                        }
                        res.append(i - start);
                        res.append(strStart);
                        res.append(source.substring(start, i));
                    }
                    start = i;
                }
                return res.toString();
        }
        public String deCompression(String target) {

                char numStart = (char)129;
                char strStart = (char)130;
                int start = 0;
                StringBuilder res = new StringBuilder();
                while(start < target.length()) {
                    int i = start;
                    while(i < target.length() && target.charAt(i) != numStart && target.charAt(i) != strStart) {
                        i++;
                    }
                    if(i < target.length() &&  target.charAt(i) == numStart) {
                        int count = Integer.parseInt(target.substring(start, i));
                        for (int j = 0; j < count; j++) {
                            res.append(target.charAt(i + 1));
                        }
                        start = i + 2;
                    }
                    else if (i < target.length() &&  target.charAt(i) == strStart) {
                        int count = Integer.parseInt(target.substring(start, i));
                        res.append(target.substring(i + 1, i + 1 + count));
                        start = i + 1 + count;
                    }
                }
                return res.toString();
        }
}
