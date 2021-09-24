package annotations.deserialitazion.jsoncreator;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/*
 * @JsonCreator annotation to tune the constructor/factory
 * used in deserialization.
 *
 */
public class BeanWithCreator {
    public final int id;
    public final String name;

    @JsonCreator
    public BeanWithCreator(
        @JsonProperty("id") int id,
        @JsonProperty("theName") String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "BeanWithCreator{" +
            "id=" + id +
            ", name='" + name + '\'' +
            '}';
    }
}
