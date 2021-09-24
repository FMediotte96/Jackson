package annotations.jackson.general;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Unwrapped {
    public int id;

    @JsonUnwrapped
    public Name name;

    public Unwrapped(int id, Name name) {
        this.id = id;
        this.name = name;
    }

    public static class Name {
        public String firstName;
        public String lastName;

        public Name(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }
    }

    public static void main(String[] args) throws JsonProcessingException {
        Unwrapped.Name name = new Unwrapped.Name("John", "Doe");
        Unwrapped user = new Unwrapped(1, name);

        String result = new ObjectMapper().writeValueAsString(user);
        System.out.println(result);
    }
}
