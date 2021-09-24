package annotations.serialization.jsonrootname;

import com.fasterxml.jackson.annotation.JsonRootName;

/*
 * @JsonRootName annotation is used – if wrapping is enabled – to specify
 * the name of the root wrapper to be used.
 */
@JsonRootName(value = "user")
public class UserWithRoot {
    public final int id;
    public final String name;

    public UserWithRoot(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
