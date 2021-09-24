package basic.node;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class Node {
    public static void main(String[] args) throws IOException {
        //Quick Parsing
        String jsonString = "{\"k1\":\"v1\",\"k2\":\"v2\"}";

        ObjectMapper mapper = new ObjectMapper();
        JsonNode actualObj = mapper.readTree(jsonString);
        System.out.println(actualObj);

        //Low Level parsing
        JsonFactory factory = mapper.getFactory();
        JsonParser parser = factory.createParser(jsonString);
        JsonNode actual = mapper.readTree(parser);
        System.out.println(actual);

        //JsonNode
        JsonNode node = mapper.readTree(jsonString);
        JsonNode jsonNode1 = node.get("k1");
        System.out.println(jsonNode1);
    }
}
