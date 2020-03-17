package App;
import java.util.*;
public class findVehicleID {

    private static HashMap<String, HashSet<Vehicle>> manufactureMap = new HashMap<>();
    private static HashMap<String, HashSet<Vehicle>> modelMap = new HashMap<>();
    private static HashMap<String, HashSet<Vehicle>> colorMap = new HashMap<>();
    private static HashSet<Vehicle> allVehicles;
    public findVehicleID(String[] vehicles) {

        for (String car : vehicles) {
            String[] info = car.split(",");
            Vehicle vi = new Vehicle(info[0], info[1], info[2], info[3]);
            if(!manufactureMap.containsKey(info[0])) manufactureMap.put(info[0], new HashSet<>());
            manufactureMap.get(info[0]).add(vi);
            if(!modelMap.containsKey(info[1])) modelMap.put(info[1], new HashSet<>());
            modelMap.get(info[1]).add(vi);
            if(!colorMap.containsKey(info[2])) colorMap.put(info[2], new HashSet<>());
            colorMap.get(info[2]).add(vi);
            allVehicles.add(vi);
        }
    }
    public String[] searchCar(String manufacture, String model, String color) {
           HashSet<Vehicle> manSet = new HashSet<>();
           if(manufacture == null) {
               manSet = allVehicles;
           }
           else if(manufactureMap.containsKey(manufacture)){
               manSet = manufactureMap.get(manufacture);
           }
            HashSet<Vehicle> modelSet = new HashSet<>();
            if(model == null) {
                modelSet = allVehicles;
            }
            else if(modelMap.containsKey(model)){
                modelSet = modelMap.get(model);
            }
            HashSet<Vehicle> colorSet = new HashSet<>();
            if(color == null) {
                colorSet = allVehicles;
            }
            else if(colorMap.containsKey(color)) {
                colorSet = colorMap.get(color);
            }

            HashSet<Vehicle> finds = new HashSet<>();
            for (Vehicle manu : manSet) {
                if(modelSet.contains(manu) && colorSet.contains(manu)) {
                    finds.add(manu);
                }
            }
            String[] Ids = new String[finds.size()];
            finds.toArray(Ids);
            return Ids;
    }

}
class Vehicle{
    private static String manufacture;
    private static String model;
    private static String color;
    private static String Id;
    public Vehicle(String manufacture, String model, String color, String Id){
        this.manufacture = manufacture;
        this.model = model;
        this.color = color;
        this.Id = Id;
    }

    public static String getManufacture() {
        return manufacture;
    }

    public static void setManufacture(String manufacture) {
        Vehicle.manufacture = manufacture;
    }

    public static String getModel() {
        return model;
    }

    public static void setModel(String model) {
        Vehicle.model = model;
    }

    public static String getColor() {
        return color;
    }

    public static void setColor(String color) {
        Vehicle.color = color;
    }

    public static String getId() {
        return Id;
    }

    public static void setId(String id) {
        Id = id;
    }
}