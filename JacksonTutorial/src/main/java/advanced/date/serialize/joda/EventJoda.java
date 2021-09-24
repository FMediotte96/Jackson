package advanced.date.serialize.joda;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.joda.time.DateTime;

public class EventJoda {
    private String name;

    @JsonSerialize(using = JodaDateTimeCustomSerializer.class)
    private DateTime eventDate;

    public EventJoda() {
    }

    public EventJoda(String name, DateTime eventDate) {
        this.name = name;
        this.eventDate = eventDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DateTime getEventDate() {
        return eventDate;
    }

    public void setEventDate(DateTime eventDate) {
        this.eventDate = eventDate;
    }

    @Override
    public String toString() {
        return "EventJoda{" +
            "name='" + name + '\'' +
            ", eventDate=" + eventDate +
            '}';
    }
}
