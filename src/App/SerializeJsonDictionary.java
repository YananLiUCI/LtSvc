
package App;
import java.util.*;
import org.json.*;
public class SerializeJsonDictionary{
        public void serializeJsonDictionary(){
        Map<String, Object> data = new HashMap<String, Object>();
        data.put( "name", "Mars" );
        data.put( "age", 32+"" );
        //List<String> list = new ArrayList<>();
        //list.add("NY");
        //list.add("NA");
        data.put( "city", "NY" );
        JSONObject json = new JSONObject(data);
        System.out.println(json);

    }
}