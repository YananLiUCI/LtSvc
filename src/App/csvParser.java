package App;

import java.io.*;

public class csvParser {
    private void parseData(String input, String output) {
        try {
            File f1 = new File(input);
            BufferedReader br = new BufferedReader(new FileReader(f1));
            BufferedWriter bw = new BufferedWriter(new FileWriter(output));
            String st;
            while ((st = br.readLine()) != null) {
                String[] curr = st.split(",");
                for (int i = 0; i < curr.length; i++) {
                    bw.write(curr[i] + "\r\n");
                }
            }
            br.close();
            bw.close();
        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}
