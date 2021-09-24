package advanced.unmarshalling;

import basic.unmarshalling.MyDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;
import java.util.List;

public class JacksonArray {
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        List<MyDto> listOfDtos = Arrays.asList(
            new MyDto("a",1,true),
            new MyDto("bc", 3, false)
        );

        //Serialize
        String jsonArray = mapper.writeValueAsString(listOfDtos);
        System.out.println(jsonArray);

        //Deserialize
        MyDto[] asArray = mapper.readValue(jsonArray, MyDto[].class);
        for(MyDto m: asArray) {
            System.out.println(m);
        }
    }
}
