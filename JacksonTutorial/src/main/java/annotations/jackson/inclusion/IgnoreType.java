package annotations.jackson.inclusion;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class IgnoreType {

    public static class User {
        public int id;
        public Name name;

        public User(int id, Name name) {
            this.id = id;
            this.name = name;
        }

        @JsonIgnoreType
        public static class Name {
            public String firstName;
            public String lastName;

            public Name(String firstName, String lastName) {
                this.firstName = firstName;
                this.lastName = lastName;
            }
        }
    }

    public static void main(String[] args) throws JsonProcessingException {
        User.Name name = new User.Name("John", "Doe");
        User user = new User(1, name);

        String result = new ObjectMapper().writeValueAsString(user);
        System.out.println(result);
    }
}
