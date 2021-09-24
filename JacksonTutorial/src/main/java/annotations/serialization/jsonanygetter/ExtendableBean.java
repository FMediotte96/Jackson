package annotations.serialization.jsonanygetter;

import com.fasterxml.jackson.annotation.JsonAnyGetter;

import java.util.HashMap;
import java.util.Map;

/*
 * @JsonAnyGetter annotation allows the flexibility of using a Map field as
 * standard properties
 */
public class ExtendableBean {
    public final String name;
    private final Map<String, String> properties;

    public ExtendableBean(String name) {
        this.name = name;
        this.properties = new HashMap<>();
    }

    @JsonAnyGetter
    public Map<String, String> getProperties() {
        return properties;
    }

    public void add(String key, String value) {
        properties.put(key, value);
    }

}
