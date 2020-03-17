package App;
import java.util.*;
//The point that we got stuck would be the last airport that we visit. And then we follow the visited vertex (airport) backwards, we would obtain the final itinerary.
public class findIternary {
    public List<String> findItinerary(List<List<String>> tickets) {
        LinkedList<String> list = new LinkedList<>();

        HashMap<String, PriorityQueue<String>> map = new HashMap<>();
        for(List<String> ticket : tickets){
            if(!map.containsKey(ticket.get(0))) map.put(ticket.get(0), new PriorityQueue<String>());

            map.get(ticket.get(0)).add(ticket.get(1));
        }

        dfs(list, "JFK", map);

        return new ArrayList<String>(list);
    }

    private void dfs(LinkedList<String> list, String airport, HashMap<String, PriorityQueue<String>> map){
        while(map.containsKey(airport) && !map.get(airport).isEmpty()){
            dfs(list, map.get(airport).poll(), map);
        }
        list.offerFirst(airport);
    }
}
