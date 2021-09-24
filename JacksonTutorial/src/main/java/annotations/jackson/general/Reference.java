package annotations.jackson.general;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class Reference {

    public static class ItemWithRef {
        public int id;
        public String itemName;

        @JsonManagedReference
        public UserWithRef owner;

        public ItemWithRef(int id, String itemName, UserWithRef owner) {
            this.id = id;
            this.itemName = itemName;
            this.owner = owner;
        }
    }

    public static class UserWithRef {
        public int id;
        public String name;

        @JsonBackReference
        public List<ItemWithRef> userItems;

        public UserWithRef(int id, String name) {
            this.id = id;
            this.name = name;
            this.userItems = new ArrayList<>();
        }

        public void addItem(ItemWithRef item) {
            userItems.add(item);
        }
    }

    public static void main(String[] args) throws JsonProcessingException {
        UserWithRef user = new UserWithRef(1, "John");
        ItemWithRef item = new ItemWithRef(2, "book", user);
        user.addItem(item);

        String result = new ObjectMapper().writeValueAsString(item);
        System.out.println(result);
    }
}
