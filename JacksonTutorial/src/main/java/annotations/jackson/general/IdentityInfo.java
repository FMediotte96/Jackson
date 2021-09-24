package annotations.jackson.general;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class IdentityInfo {

    @JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
    )
    public static class ItemWithIdentity {
        public int id;
        public String itemName;
        public UserWithIdentity owner;

        public ItemWithIdentity(int id, String itemName, UserWithIdentity owner) {
            this.id = id;
            this.itemName = itemName;
            this.owner = owner;
        }
    }

    @JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
    )
    public static class UserWithIdentity {
        public int id;
        public String name;
        public List<ItemWithIdentity> userItems;

        public UserWithIdentity(int id, String name) {
            this.id = id;
            this.name = name;
            this.userItems = new ArrayList<>();
        }

        public void addItem(ItemWithIdentity item) {
            userItems.add(item);
        }
    }

    public static void main(String[] args) throws JsonProcessingException {
        UserWithIdentity user = new UserWithIdentity(1, "John");
        ItemWithIdentity item = new ItemWithIdentity(2, "book", user);
        user.addItem(item);

        String result = new ObjectMapper().writeValueAsString(item);
        System.out.println(result);
    }
}
