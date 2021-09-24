package basic;

import basic.custom.CustomCarDeserializer;
import basic.custom.CustomCarSerializer;
import basic.model.Car;
import basic.model.Request;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class AdvancedFeatures {

    public static void main(String[] args) throws JsonProcessingException {
        //Advanced Features
        //https://github.com/FasterXML/jackson-databind/wiki/Serialization-Features
        //Configuring Serialization or Deserialization Feature
        String jsonString = "{ \"color\" : \"Black\", \"type\" : \"Fiat\", \"year\" : \"1970\" }";

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Car car = objectMapper.readValue(jsonString, Car.class);

        JsonNode jsonNodeRoot = objectMapper.readTree(jsonString);
        JsonNode jsonNodeYear = jsonNodeRoot.get("year");
        String year = jsonNodeYear.asText();
        System.out.println(year);

        objectMapper.configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, false);
        objectMapper.configure(DeserializationFeature.FAIL_ON_NUMBERS_FOR_ENUMS, false);

        //Custom Serializer or Deserializer
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule("CustomCarSerializer",
            new Version(1, 0, 0, null, null, null));
        module.addSerializer(Car.class, new CustomCarSerializer());
        mapper.registerModule(module);

        Car car2 = new Car("yellow", "renault");
        String carJson = mapper.writeValueAsString(car2);
        System.out.println(carJson);


        String json = "{ \"color\" : \"Black\", \"type\" : \"BMW\" }";
        ObjectMapper mapper1 = new ObjectMapper();
        SimpleModule sm = new SimpleModule("CustomCarDeserializer",
            new Version(1, 0, 0, null, null, null));
        sm.addDeserializer(Car.class, new CustomCarDeserializer());
        mapper1.registerModule(sm);
        Car car3 = mapper1.readValue(json, Car.class);
        System.out.println(car3);

        //Handling Date Formats
        Request request = new Request(new Car("blue", "BMW"), new Date());
        ObjectMapper dateMapper = new ObjectMapper();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm a z");
        dateMapper.setDateFormat(df);
        String carAsString = dateMapper.writeValueAsString(request);
        System.out.println(carAsString);

        //Handling Collections - Deserialization Feature
        String jsonCarArray =
            "[{ \"color\" : \"Black\", \"type\" : \"BMW\" }, { \"color\" : \"Red\", \"type\" : \"FIAT\" }]";
        ObjectMapper mapperCollection = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY, true);
        Car[] cars = mapperCollection.readValue(jsonCarArray, Car[].class);
        for (Car c : cars) {
            System.out.println(c);
        }

        //As list
        ObjectMapper mapperList = new ObjectMapper();
        List<Car> listCar = mapperList.readValue(jsonCarArray, new TypeReference<List<Car>>() {
        });
        System.out.println(listCar);

    }
}
