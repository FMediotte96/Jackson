package annotations.deserialitazion.jsonalias;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.logging.Logger;

public class Test {

    private static final Logger LOGGER = Logger.getLogger(Test.class.getName());

    public static void main(String[] args) throws JsonProcessingException {
        String json = "{\"fName\": \"John\", \"lastName\":\"Green\"}";

        AliasBean bean = new ObjectMapper()
            .readerFor(AliasBean.class)
            .readValue(json);

        LOGGER.info(bean.toString());
    }
}
