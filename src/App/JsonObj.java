package App;

import java.util.HashMap;

public class JsonObj {

        HashMap<String, String> Obj;
        HashMap<String, JsonObj> children;

        public JsonObj(HashMap<String, String> obj) {
                this.Obj = obj;
                children = new HashMap<>();
        }

}
