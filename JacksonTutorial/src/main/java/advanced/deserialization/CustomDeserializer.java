package advanced.deserialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

public class CustomDeserializer {
    public static void main(String[] args) throws JsonProcessingException {
        String json = "{" +
            "    \"id\": 1," +
            "    \"itemName\": \"theItem\"," +
            "    \"createdBy\": 2" +
            "}";

        //This won't work
//        Item itemwithOwner = new ObjectMapper().readValue(json, Item.class);
//        System.out.println(itemwithOwner);

        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addDeserializer(Item.class, new ItemDeserializer());
        mapper.registerModule(module);

        Item readValue = mapper.readValue(json, Item.class);
        System.out.println(readValue);

        //Alternatively we can also register the deserializer directly on the class
        //and go this way
        Item itemWithOwner = new ObjectMapper().readValue(json, Item.class);
        System.out.println(itemWithOwner);
    }
}
