package advanced.inheritance.subtypehandling;

import advanced.inheritance.inclusion.Car;
import advanced.inheritance.inclusion.Truck;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();

        Car car = new Car("Mercedes-Benz", "S500", 5, 250.0);
        Truck truck = mapper.convertValue(car, Truck.class);
        System.out.println(truck);

    }
}
