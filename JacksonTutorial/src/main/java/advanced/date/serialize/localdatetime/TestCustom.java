package advanced.date.serialize.localdatetime;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDateTime;

public class TestCustom {
    public static void main(String[] args) throws JsonProcessingException {
        LocalDateTime date = LocalDateTime.of(2014,12,20,2,30);
        EventLocalDateTime event = new EventLocalDateTime("party", date);

        ObjectMapper mapper = new ObjectMapper();
        String result = mapper.writeValueAsString(event);
        System.out.println(result);
    }
}
