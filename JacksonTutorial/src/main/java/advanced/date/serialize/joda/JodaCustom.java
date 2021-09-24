package advanced.date.serialize.joda;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.joda.time.DateTime;

public class JodaCustom {
    public static void main(String[] args) throws JsonProcessingException {
        DateTime date = new DateTime(2014,12,20,2,30);
        EventJoda event = new EventJoda("party", date);

        ObjectMapper mapper = new ObjectMapper();
        String result = mapper.writeValueAsString(event);
        System.out.println(result);
    }
}
