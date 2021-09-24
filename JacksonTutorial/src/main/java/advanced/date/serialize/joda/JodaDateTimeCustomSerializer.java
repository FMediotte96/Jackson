package advanced.date.serialize.joda;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.io.IOException;

public class JodaDateTimeCustomSerializer extends StdSerializer<DateTime> {

    private static DateTimeFormatter formatter =
        DateTimeFormat.forPattern("yyyy-MM-dd HH:mm");

    public JodaDateTimeCustomSerializer() {
        this(null);
    }

    public JodaDateTimeCustomSerializer(Class<DateTime> t) {
        super(t);
    }

    @Override
    public void serialize(DateTime value, JsonGenerator gen, SerializerProvider provider)
        throws IOException {
        gen.writeString(formatter.print(value));
    }
}
