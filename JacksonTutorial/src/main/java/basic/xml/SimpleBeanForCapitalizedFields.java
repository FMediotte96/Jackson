package basic.xml;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;

public class SimpleBeanForCapitalizedFields {
    @JsonProperty("X")
    private int x = 1;
    private int y = 2;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "SimpleBeanForCapitalizedFields{" +
            "x=" + x +
            ", y=" + y +
            '}';
    }

    public static void main(String[] args) throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        //Deserialize from XML String
        SimpleBeanForCapitalizedFields value = xmlMapper.readValue(
            "<SimpleBeanForCapitalizedFields><X>1</X><y>2</y></SimpleBeanForCapitalizedFields>",
            SimpleBeanForCapitalizedFields.class
        );
        System.out.println(value);

        //Serialize from XML String
        xmlMapper.writeValue(new File("target/simple_bean_capitalized.xml"),
            new SimpleBeanForCapitalizedFields());
        File file = new File("target/simple_bean_capitalized.xml");
    }
}
