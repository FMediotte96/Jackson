package advanced.map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.MapSerializer;

import java.util.HashMap;
import java.util.Map;

public class Serialize {
    @JsonSerialize(keyUsing = MyPairSerializer.class)
    private static Map<MyPair, String> mapJ;

    @JsonSerialize(keyUsing = MapSerializer.class)
    private static Map<MyPair, MyPair> mapO;

    @JsonSerialize(keyUsing = MyPairSerializer.class)
    private static MyPair mapKey;

    @JsonSerialize(keyUsing = MyPairSerializer.class)
    private static MyPair mapValue;

    public static void main(String[] args) throws JsonProcessingException {

        //Map<String, String>
        Map<String, String> map = new HashMap<>();
        map.put("key", "value");

        ObjectMapper mapper = new ObjectMapper();
        String jsonResult = mapper.writerWithDefaultPrettyPrinter()
            .writeValueAsString(map);
        System.out.println(jsonResult);

        //Map<Object, String>
        mapJ = new HashMap<>();
        MyPair key = new MyPair("Abbott", "Costello");
        mapJ.put(key, "Comedy");

        String jsonResultJ = mapper.writerWithDefaultPrettyPrinter()
            .writeValueAsString(mapJ);

        System.out.println(jsonResultJ);

        //Map<Object, Object>
        mapO = new HashMap<>();
        mapKey = new MyPair("Abbott", "Costello");
        mapValue = new MyPair("Comedy", "1940s");
        mapO.put(mapKey, mapValue);

        String jsonResultO = mapper.writerWithDefaultPrettyPrinter()
            .writeValueAsString(mapO);
        System.out.println(jsonResultO);
    }
}
