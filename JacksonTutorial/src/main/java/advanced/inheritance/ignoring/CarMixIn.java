package advanced.inheritance.ignoring;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class CarMixIn {
    @JsonIgnore
    private String make;

    @JsonIgnore
    private String topSpeed;

    public CarMixIn() {
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getTopSpeed() {
        return topSpeed;
    }

    public void setTopSpeed(String topSpeed) {
        this.topSpeed = topSpeed;
    }
}
