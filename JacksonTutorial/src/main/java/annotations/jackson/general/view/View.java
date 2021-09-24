package annotations.jackson.general.view;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class View {
    public static class Public {}
    public static class Internal extends Public {}

    public static void main(String[] args) throws JsonProcessingException {
        Item item = new Item(2, "book", "John");

        String result = new ObjectMapper()
            .writerWithView(View.Public.class)
            .writeValueAsString(item);

        System.out.println(result);
    }
}
