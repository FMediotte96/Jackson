package basic.unmarshalling;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        //UnrecognizedPropertyException on Unknown Fields
        String jsonAsString = "" +
            "{\"stringValue\": \"a\"," +
            "\"intValue\":1," +
            "\"booleanValue\": true," +
            "\"stringValue2\":\"something\"}";

        //Dealing with the problem using ObjectMapper
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        MyDto readValue = mapper.readValue(jsonAsString, MyDto.class);
        System.out.println(readValue);

        //At the class level
        ObjectMapper mapper1 = new ObjectMapper();
        MyDto readValue1 = mapper1.readValue(jsonAsString, MyDto.class);
        System.out.println(readValue1);

        //Unmarshall an Incomplete JSON
        String jsonAsStringIncomplete = "{\"stringValue\":\"a\", \"booleanValue\":true}";
        ObjectMapper mapper2 = new ObjectMapper();
        MyDto readValue2 = mapper2.readValue(jsonAsStringIncomplete, MyDto.class);
        System.out.println(readValue2);
    }
}
