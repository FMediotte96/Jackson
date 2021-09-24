package advanced.inheritance.inclusion;

import java.util.List;

public class Fleet {
    private List<Vehicle> vehicles;

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    @Override
    public String toString() {
        return "Fleet{" +
            "vehicles=" + vehicles +
            '}';
    }
}
