package annotations.jackson.inclusion;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonIgnoreProperties({"id"})
public class IgnoreProperties {
    public int id;
    public String name;

    public IgnoreProperties(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static void main(String[] args) throws JsonProcessingException {
        IgnoreProperties bean = new IgnoreProperties(1, "My bean");

        String result = new ObjectMapper().writeValueAsString(bean);
        System.out.println(result);
    }
}
