package advanced.date.serialize.joda;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

public class JodaDate {
    public static void main(String[] args) throws JsonProcessingException {
        DateTime date = new DateTime(2014,12,20,2,30,
            DateTimeZone.forID("Europe/London"));

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JodaModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        String result = mapper.writeValueAsString(date);
        System.out.println(result);
    }
}
