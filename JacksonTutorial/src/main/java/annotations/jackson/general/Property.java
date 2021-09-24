package annotations.jackson.general;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Property {
    public int id;
    private String name;

    public Property() {
    }

    public Property(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @JsonProperty("name")
    public void setTheName(String name) {
        this.name = name;
    }

    @JsonProperty("name")
    public String getTheName() {
        return name;
    }

    @Override
    public String toString() {
        return "Property{" +
            "id=" + id +
            ", name='" + name + '\'' +
            '}';
    }

    public static void main(String[] args) throws JsonProcessingException {
        Property bean = new Property(1, "My bean");

        String result = new ObjectMapper().writeValueAsString(bean);
        System.out.println(result);

        Property resultBean = new ObjectMapper()
            .readerFor(Property.class)
            .readValue(result);
        System.out.println(resultBean);
    }
}
