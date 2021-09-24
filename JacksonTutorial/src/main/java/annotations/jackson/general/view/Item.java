package annotations.jackson.general.view;

import com.fasterxml.jackson.annotation.JsonView;

public class Item {
    @JsonView(View.Public.class)
    public int id;

    @JsonView(View.Public.class)
    public String itemName;

    @JsonView(View.Internal.class)
    public String ownerName;

    public Item(int id, String itemName, String ownerName) {
        this.id = id;
        this.itemName = itemName;
        this.ownerName = ownerName;
    }
}
