package annotations.jackson.inclusion;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class AutoDetect {
    private int id;
    private String name;

    public AutoDetect(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static void main(String[] args) throws JsonProcessingException {
        AutoDetect bean = new AutoDetect(1, "My bean");

        String result = new ObjectMapper().writeValueAsString(bean);
        System.out.println(result);
    }
}
