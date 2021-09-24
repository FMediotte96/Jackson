package advanced.views.custom;

import advanced.views.User;
import advanced.views.Views;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.BeanSerializerFactory;
import com.fasterxml.jackson.databind.ser.SerializerFactory;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        User user = new User(1, "John");
        SerializerFactory factory = BeanSerializerFactory.instance
            .withSerializerModifier(new MyBeanSerializerModifier());

        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializerFactory(factory);

        String result = mapper
            .writerWithView(Views.Public.class)
            .writeValueAsString(user);

        System.out.println(result);
    }
}
