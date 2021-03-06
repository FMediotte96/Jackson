package annotations.jackson.general;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@JsonFilter("myFilter")
public class Filter {
    public int id;
    public String name;

    public Filter(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static void main(String[] args) throws JsonProcessingException {
        Filter bean = new Filter(1, "My bean");

        FilterProvider filters = new SimpleFilterProvider().addFilter(
            "myFilter",
            SimpleBeanPropertyFilter.filterOutAllExcept("name")
        );

        String result = new ObjectMapper()
            .writer(filters)
            .writeValueAsString(bean);

        System.out.println(result);
    }
}
