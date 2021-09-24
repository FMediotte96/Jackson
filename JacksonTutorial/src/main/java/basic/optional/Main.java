package basic.optional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;

import java.util.Optional;

public class Main {

    public static void main(String[] args) throws JsonProcessingException {
        Book book = new Book();
        book.setTitle("Oliver Twist");
        book.setSubTitle(Optional.of("The Parish Boy's Progress"));

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new Jdk8Module());

        //Serialize
        String result = mapper.writeValueAsString(book);
        System.out.println(result);
        book.setSubTitle(Optional.empty());
        result = mapper.writeValueAsString(book);
        System.out.println(result);

        //Deserialize
        String bookJson = "{ \"title\": \"Oliver Twist\", \"subTitle\": \"foo\" }";
        Book bookResult = mapper.readValue(bookJson, Book.class);
        System.out.println(bookResult);
    }
}
