package advanced.deserialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Standard {
    public static void main(String[] args) throws JsonProcessingException {
        String json = "{" +
            "    \"id\": 1," +
            "    \"itemName\": \"theItem\"," +
            "    \"owner\": {" +
            "        \"id\": 2," +
            "        \"name\": \"theUser\"" +
            "    }" +
            "}";

        Item itemWithOwner = new ObjectMapper().readValue(json, Item.class);
        System.out.println(itemWithOwner);
    }
}
