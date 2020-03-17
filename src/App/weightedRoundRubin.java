package App;
import java.util.*;
public class weightedRoundRubin {
    Random someRandGen = new Random();
    TreeMap<Integer, Server> pool;
    int totalWeight;

    public void init(ArrayList<Server> servers) {
        this.pool = new TreeMap<Integer, Server>();
        // create the "weighted selection" list
        totalWeight = 0;
        for(Server s : servers) {
            //  associate each server with the sum of the weights so far
            totalWeight += s.getWeight();
            this.pool.put(totalWeight, s);
        }
    }

    public Server getNext() {
        int rnd = someRandGen.nextInt(this.totalWeight);
        return pool.ceilingEntry(rnd).getValue();
    }
}
class Server {
    int weight;
    String address;
    public Server(int weight, String address) {
        this.weight = weight;
        this.address = address;
    }
    public int getWeight(){return this.weight;}
    public String getAddress(){return this.address;}
}