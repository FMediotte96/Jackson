package annotations.serialization.jsongetter;

import com.fasterxml.jackson.annotation.JsonGetter;

/*
 * @JsonGetter annotation is an alternative to the @JsonProperty annotation
 * to mark a method as a getter method.
 */
public class MyBean {
    public final int id;
    private final String name;

    public MyBean(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @JsonGetter("name")
    public String getTheName() {
        return name;
    }
}
