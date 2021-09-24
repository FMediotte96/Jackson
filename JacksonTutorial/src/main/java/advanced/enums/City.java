package advanced.enums;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class City {
    private Distance distance;

    public Distance getDistance() {
        return distance;
    }

    public void setDistance(Distance distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "City{" +
            "distance=" + distance +
            '}';
    }

    public static void main(String[] args) throws JsonProcessingException {
        String json = "{\"distance\":\"KILOMETER\"}";
        City city = new ObjectMapper().readValue(json, City.class);
        System.out.println(city);

        //@JsonProperty
//        String json2 = "{\"distance\": \"distance-in-km\"}";
//        City city2 = new ObjectMapper().readValue(json2, City.class);
//        System.out.println(city2.getDistance());
    }
}
