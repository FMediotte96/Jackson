package annotations.deserialitazion.jacksoninject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.InjectableValues;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.logging.Logger;

public class Test {

    private static final Logger LOGGER = Logger.getLogger(Test.class.getName());

    public static void main(String[] args) throws JsonProcessingException {
        String json = "{\"name\":\"My bean\"}";

        InjectableValues inject = new InjectableValues.Std()
            .addValue(int.class, 1);

        BeanWithInject bean = new ObjectMapper()
            .reader(inject)
            .forType(BeanWithInject.class)
            .readValue(json);

        LOGGER.info(bean.toString());
    }
}
