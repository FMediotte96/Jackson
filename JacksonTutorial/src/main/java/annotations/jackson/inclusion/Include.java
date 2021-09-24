package annotations.jackson.inclusion;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Include {
    public int id;
    public String name;

    public Include(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static void main(String[] args) throws JsonProcessingException {
        Include bean = new Include(1, null);

        String result = new ObjectMapper().writeValueAsString(bean);
        System.out.println(result);
    }
}
