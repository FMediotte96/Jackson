package gson.serialize;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import gson.ActorGson;
import gson.Movie;
import gson.serialize.ActorGsonSerializer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        ActorGson rudyYoungBlood = new ActorGson(
            "nm2199632",
            sdf.parse("21-09-1982"),
            Arrays.asList("Apocalypto", "Beatdown", "Wind Walkers")
        );

        Movie movie = new Movie(
            "tt0472043",
            "Mel Gibson",
            Arrays.asList(rudyYoungBlood)
        );

        String serializedMovie = new Gson().toJson(movie);
        System.out.println(serializedMovie);

        Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .excludeFieldsWithoutExposeAnnotation()
            .serializeNulls()
            .disableHtmlEscaping()
            .registerTypeAdapter(ActorGson.class, new ActorGsonSerializer())
            .create();

        Movie movieWithNullValue =
            new Movie(null, "Mel Gibson", Arrays.asList(rudyYoungBlood));

        String serializedMovieNull = gson.toJson(movieWithNullValue);
        System.out.println(serializedMovieNull);
    }
}
