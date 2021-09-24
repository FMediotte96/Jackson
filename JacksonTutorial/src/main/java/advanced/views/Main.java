package advanced.views;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        User user = new User(1, "John");

        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(MapperFeature.DEFAULT_VIEW_INCLUSION);

        String result = mapper
            .writerWithView(Views.Public.class)
            .writeValueAsString(user);

        System.out.println(result);

        //OnlyPublicView
        Item item = new Item(2, "book", "John");

        ObjectMapper mapper1 = new ObjectMapper();
        String result1 = mapper1
            .writerWithView(Views.Public.class)
            .writeValueAsString(item);

        System.out.println(result1);

        //InternalView should show all attributes
        String result2 = mapper1
            .writerWithView(Views.Internal.class)
            .writeValueAsString(item);

        System.out.println(result2);


        //Deserialize
        String json = "{\"id\":1,\"name\":\"John\"}";

        ObjectMapper mapper3 = new ObjectMapper();
        User user2 = mapper3
            .readerWithView(Views.Public.class)
            .forType(User.class)
            .readValue(json);

        System.out.println(user2);
    }
}
