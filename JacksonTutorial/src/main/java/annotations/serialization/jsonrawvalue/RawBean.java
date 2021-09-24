package annotations.serialization.jsonrawvalue;

import com.fasterxml.jackson.annotation.JsonRawValue;

/*
 * @JsonRawValue annotation can instruct Jackson to serialize a property
 * exactly as is
 */
public class RawBean {
    public final String name;

    @JsonRawValue
    public String json;

    public RawBean(String name, String json) {
        this.name = name;
        this.json = json;
    }
}
