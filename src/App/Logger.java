package App;
import java.util.*;
public class Logger {
    private HashMap<String, Integer> last_printed;

    /** Initialize your data structure here. */
    public Logger() {
        last_printed = new HashMap<String, Integer>();
    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
     If this method returns false, the message will not be printed.
     The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(!last_printed.containsKey(message)){
            last_printed.put(message, timestamp);
            return true;
        }
        int last_time = last_printed.get(message);
        if(last_time <= timestamp - 10){
            last_printed.put(message, timestamp);
            return true;
        }
        else return false;
    }
}
