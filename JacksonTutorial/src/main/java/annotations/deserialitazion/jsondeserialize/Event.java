package annotations.deserialitazion.jsondeserialize;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.Date;

/*
 * @JsonDeserialize indicates the use of a custom deserializer.
 */
public class Event {
    public String name;

    @JsonDeserialize(using = CustomDateDeserializer.class)
    public Date eventDate;

    @Override
    public String toString() {
        return "Event{" +
            "name='" + name + '\'' +
            ", eventDate=" + eventDate +
            '}';
    }
}
