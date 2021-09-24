package advanced.enums;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SerializeEnum {
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String mile = mapper.writeValueAsString(Distance.MILE);
        System.out.println(mile);
    }
}
