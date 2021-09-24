package annotations.serialization.jsonpropertyorder;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/*
 * @JsonPropertyOrder annotation to specify the order of
 * properties on serialization.
 * We can also use @JsonPropertyOrder(alphabetic=true) 7
 * to order the properties alphabetically.
 */
@JsonPropertyOrder({"name", "id"})
//@JsonPropertyOrder(alphabetic = true)
public class MyBean {
    public final int id;
    public final String name;

    public MyBean(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
