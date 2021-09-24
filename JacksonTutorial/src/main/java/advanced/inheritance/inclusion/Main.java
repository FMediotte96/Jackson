package advanced.inheritance.inclusion;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        //mapper.enableDefaultTyping();

//        Car car = new Car("Mercedes-Benz", "S500", 5, 250.0);
//        Truck truck = new Truck("Isuzu", "NQR", 7500.0);
//
//        List<Vehicle> vehicles = new ArrayList<>();
//        vehicles.add(car);
//        vehicles.add(truck);
//
//        Fleet serializedFleet = new Fleet();
//        serializedFleet.setVehicles(vehicles);
//
//        //Serialize
//        String jsonDataString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(serializedFleet);
//        System.out.println(jsonDataString);
//
//        //Deserialize
//        Fleet deserializedFleet = mapper.readValue(jsonDataString, Fleet.class);
//        System.out.println(deserializedFleet);

    }
}
