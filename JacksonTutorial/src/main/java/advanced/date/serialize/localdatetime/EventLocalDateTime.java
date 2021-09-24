package advanced.date.serialize.localdatetime;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.time.LocalDateTime;

public class EventLocalDateTime {
    private String name;

    @JsonSerialize(using = CustomLocalDateTimeSerializer.class)
    private LocalDateTime eventDate;

    public EventLocalDateTime() {
    }

    public EventLocalDateTime(String name, LocalDateTime eventDate) {
        this.name = name;
        this.eventDate = eventDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDateTime eventDate) {
        this.eventDate = eventDate;
    }

    @Override
    public String toString() {
        return "EventLocalDateTime{" +
            "name='" + name + '\'' +
            ", eventDate=" + eventDate +
            '}';
    }
}
