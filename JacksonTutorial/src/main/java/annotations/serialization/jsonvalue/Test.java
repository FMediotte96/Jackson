package annotations.serialization.jsonvalue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.logging.Logger;

public class Test {

    private static final Logger LOGGER = Logger.getLogger(Test.class.getName());

    public static void main(String[] args) throws JsonProcessingException {
        String typeA = new ObjectMapper()
            .writerWithDefaultPrettyPrinter()
            .writeValueAsString(TypeEnumWithValue.TYPE1);
        LOGGER.info(typeA);

        String typeB = new ObjectMapper()
            .writerWithDefaultPrettyPrinter()
            .writeValueAsString(TypeEnumWithValue.TYPE2);
        LOGGER.info(typeB);
    }
}
