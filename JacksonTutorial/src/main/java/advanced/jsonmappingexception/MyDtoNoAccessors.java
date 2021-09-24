package advanced.jsonmappingexception;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

//Detected All Fields at the Class Level
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class MyDtoNoAccessors {
    String stringValue;
    int intValue;
    boolean booleanValue;

    public MyDtoNoAccessors() {
    }
}
