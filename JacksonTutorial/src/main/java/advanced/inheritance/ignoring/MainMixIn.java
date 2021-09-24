package advanced.inheritance.ignoring;

import advanced.inheritance.inclusion.Car;
import advanced.inheritance.inclusion.Crossover;
import advanced.inheritance.inclusion.Sedan;
import advanced.inheritance.inclusion.Vehicle;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class MainMixIn {
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.addMixIn(Car.class, CarMixIn.class);

        Crossover crossover = new Crossover("BMW", "X6", 5, 250.0, 6000.0);
        Sedan sedan = new Sedan("Mercedes-Benz", "S500", 5, 250.0);

        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(sedan);
        vehicles.add(crossover);

        String jsonDataString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(vehicles);
        System.out.println(jsonDataString);
    }
}
