package advanced.map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

public class Deserialize {
    public static void main(String[] args) throws JsonProcessingException {
        //Map<String,String>
        String jsonInput = "{\"key\": \"value\"}";
        TypeReference<HashMap<String, String>> typeRef = new TypeReference<HashMap<String, String>>() {
        };

        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> map = mapper.readValue(jsonInput, typeRef);
        System.out.println(map);

        //Map<Object,String>
        String jsonValue = "{\"Abbott and Costello\" : \"Comedy\"}";
        TypeReference<HashMap<MyPair, String>> typeRefMap = new TypeReference<HashMap<MyPair, String>>() {
        };
        Map<MyPair, String> mapO = mapper.readValue(jsonValue, typeRefMap);
        System.out.println(mapO);

        String jsonInputA = "{\"Abbott and Costello\":\"Comedy\"}";
        ClassWithAMap classWithAMap = mapper.readValue(jsonInputA, ClassWithAMap.class);
        System.out.println(classWithAMap);

        //Map<Object,Object>
        String jsonInputB = "{\"Abbott and Costello\" : \"Comedy and 1940s\"}";
        TypeReference<HashMap<MyPair,MyPair>> typeRefObj = new TypeReference<HashMap<MyPair, MyPair>>() {
        };
        Map<MyPair, MyPair> mapB = mapper.readValue(jsonInputB, typeRefObj);
        System.out.println(mapB);
    }
}
