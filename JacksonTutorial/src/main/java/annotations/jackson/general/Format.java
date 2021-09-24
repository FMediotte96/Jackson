package annotations.jackson.general;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Format {
    public String name;

    @JsonFormat(
        shape = JsonFormat.Shape.STRING,
        pattern = "dd-MM-yyyy hh:mm:ss"
    )
    public Date eventDate;

    public Format(String name, Date eventDate) {
        this.name = name;
        this.eventDate = eventDate;
    }

    public static void main(String[] args) throws ParseException, JsonProcessingException {
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        df.setTimeZone(TimeZone.getTimeZone("UTC"));

        String toParse = "20-12-2014 02:30:00";
        Date date = df.parse(toParse);
        Format bean = new Format("party", date);
        String result = new ObjectMapper().writeValueAsString(bean);
        System.out.println(result);
    }
}
