package App;

import java.util.*;

public class validateJson {

        public boolean validJsonObjectBFS(JsonObj root) {

            if(root == null || root.Obj == null)
                return false;

            Queue<JsonObj> queue = new LinkedList<>();
            queue.offer(root);

            while(!queue.isEmpty()) {

                JsonObj curr = queue.poll();
                if(!validHashMap(curr.Obj))
                    return false;
                for (Map.Entry<String, JsonObj> child : curr.children.entrySet()) {
                    if(child.getKey() == null || child.getValue() == null)
                        return false;
                    queue.offer(child.getValue());
                }
            }

            return true;

        }
        public boolean validJsonObjectDFS(JsonObj root) {

            if(root == null || root.Obj == null)
                return false;

            if(!validHashMap(root.Obj))
                return false;
            for (Map.Entry<String, JsonObj> child : root.children.entrySet()) {
                if(child.getKey() == null || child.getValue() == null)
                    return false;
                if(!validJsonObjectDFS(child.getValue()))
                    return false;
            }
            return true;
        }


        private boolean validHashMap(HashMap<String, String> curr) {

                if(curr == null || curr.isEmpty())
                    return false;

                for (Map.Entry<String, String> entry : curr.entrySet()) {
                    if(entry.getKey() == null || entry.getValue() == null)
                        return false;
                }

                return true;
        }
}
