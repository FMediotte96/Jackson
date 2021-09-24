package annotations.jackson.inclusion;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Ignore {
    @JsonIgnore
    public int id;

    public String name;

    public Ignore(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static void main(String[] args) throws JsonProcessingException {
        Ignore bean = new Ignore(1, "My bean");

        String result = new ObjectMapper().writeValueAsString(bean);
        System.out.println(result);
    }
}
