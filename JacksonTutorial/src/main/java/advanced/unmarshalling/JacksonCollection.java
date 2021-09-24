package advanced.unmarshalling;

import basic.unmarshalling.MyDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.util.Arrays;
import java.util.List;

public class JacksonCollection {
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        List<MyDto> listOfDtos = Arrays.asList(
            new MyDto("a",1,true),
            new MyDto("bc", 3, false)
        );

        String jsonArray = mapper.writeValueAsString(listOfDtos);
        System.out.println(jsonArray);

        List<MyDto> asList = mapper.readValue(jsonArray, List.class);
        System.out.println(asList);

        //2 solutions
        //Uses TypeReference
        List<MyDto> asListWithTypeRef = mapper.readValue(jsonArray, new TypeReference<List<MyDto>>() {
        });
        System.out.println(asListWithTypeRef);

        //overloaded readValue that accepts a JavaType
        CollectionType javaType = mapper.getTypeFactory()
            .constructCollectionType(List.class, MyDto.class);
        List<MyDto> asListValue = mapper.readValue(jsonArray, javaType);
        System.out.println(asListValue);

    }
}
