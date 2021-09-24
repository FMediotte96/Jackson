package annotations.serialization.jsonvalue;

import com.fasterxml.jackson.annotation.JsonValue;

/*
 * @JsonValue indicates a single method that the library will use to serialize
 * the entire instance
 */
public enum TypeEnumWithValue {
    TYPE1(1, "TYPE A"),
    TYPE2(2, "TYPE B");

    private final Integer id;
    private final String name;

    TypeEnumWithValue(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    @JsonValue
    public String getName() {
        return name;
    }
}
