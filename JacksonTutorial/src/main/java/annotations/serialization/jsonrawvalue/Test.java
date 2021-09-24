package annotations.serialization.jsonrawvalue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.logging.Logger;

public class Test {

    private static final Logger LOGGER = Logger.getLogger(Test.class.getName());

    public static void main(String[] args) throws JsonProcessingException {
        RawBean bean = new RawBean("My bean", "{\"attr\":false}");

        String result = new ObjectMapper()
            .writerWithDefaultPrettyPrinter()
            .writeValueAsString(bean);

        LOGGER.info(result);
    }
}
