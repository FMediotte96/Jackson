package basic;

import basic.model.Car;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Basic {

    public static void main(String[] args) throws IOException {
        //Reading and Writing Using ObjectMapper
        //Object to Json by writeValue
        ObjectMapper objectMapper = new ObjectMapper();
        Car car = new Car("yellow", "renault");
        objectMapper.writeValue(new File("target/car.json"), car);

        //WriteValueAsString
        String carAsString = objectMapper.writeValueAsString(car);
        System.out.println(carAsString);

        //WriteValueAsBytes
        byte[] carAsBytes = objectMapper.writeValueAsBytes(car);
        System.out.println(carAsBytes);

        //JSON to Java Object
        String json = "{ \"color\" : \"Black\", \"type\" : \"BMW\" }";
        Car carO = objectMapper.readValue(json, Car.class);
        System.out.println(carO);

        //JSON to Jackson JsonNode
        String json2 = "{ \"color\" : \"Black\", \"type\" : \"FIAT\" }";
        JsonNode jsonNode = objectMapper.readTree(json2);
        String color = jsonNode.get("color").asText();
        System.out.println("Color: " + color);

        //Java List from JSON Array String
        String jsonCarArray =
            "[{ \"color\" : \"Black\", \"type\" : \"BMW\" }, { \"color\" : \"Red\", \"type\" : \"FIAT\" }]";
        List<Car> listCar = objectMapper.readValue(jsonCarArray, new TypeReference<List<Car>>() {
        });
        System.out.println(listCar);

        //Java Map from JSON String
        String jsonMap = "{ \"color\" : \"Black\", \"type\" : \"BMW\" }";
        Map<String, Object> map = objectMapper.readValue(jsonMap, new TypeReference<Map<String, Object>>() {
        });
        System.out.println(map);

    }
}
