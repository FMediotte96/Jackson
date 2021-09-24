package annotations.deserialitazion.jsonanysetter;

import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.HashMap;
import java.util.Map;

/*
 * @JsonAnySetter allows us the flexibility of using a Map as standard properties.
 * On deserialization, the properties from JSON will simply be added to the map.
 */
public class ExtendableBean {
    public String name;
    private final Map<String, String> properties;

    public ExtendableBean() {
        this.properties = new HashMap<>();
    }

    public ExtendableBean(String name, Map<String, String> properties) {
        this.name = name;
        this.properties = properties;
    }

    @JsonAnySetter
    public void add(String key, String value) {
        properties.put(key, value);
    }

    @Override
    public String toString() {
        return "ExtendableBean{" +
            "name='" + name + '\'' +
            ", properties=" + properties +
            '}';
    }
}
