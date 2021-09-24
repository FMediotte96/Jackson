package annotations.serialization.jsonserialize;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Date;

/*
 * @JsonSerialize indicates a custom serializer to use
 * when marshalling the entity.
 */
public class Event {
    public final String name;

    @JsonSerialize(using = CustomDateSerializer.class)
    public Date eventDate;

    public Event(String name, Date eventDate) {
        this.name = name;
        this.eventDate = eventDate;
    }
}
