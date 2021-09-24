package annotations.deserialitazion.jsoncreator;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.logging.Logger;

public class Test {

    private static final Logger LOGGER = Logger.getLogger(Test.class.getName());

    public static void main(String[] args) throws JsonProcessingException {
        String json = "{\"id\":1,\"theName\":\"My bean\"}";

        BeanWithCreator bean = new ObjectMapper()
            .readerFor(BeanWithCreator.class)
            .readValue(json);

        LOGGER.info(bean.toString());
    }
}
