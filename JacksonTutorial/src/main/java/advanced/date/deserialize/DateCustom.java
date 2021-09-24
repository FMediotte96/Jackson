package advanced.date.deserialize;

import advanced.date.serialize.Event;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.text.SimpleDateFormat;

public class DateCustom {
    public static void main(String[] args) throws JsonProcessingException {
        String json = "{\"name\":\"party\",\"eventDate\":\"20-12-2014 02:30:00\"}";

        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        ObjectMapper mapper = new ObjectMapper();

        Event event = mapper.readerFor(Event.class).readValue(json);
        System.out.println(df.format(event.getEventDate()));
    }
}
