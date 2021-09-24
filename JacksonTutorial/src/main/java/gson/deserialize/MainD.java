package gson.deserialize;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import gson.ActorGson;
import gson.Movie;

public class MainD {
    public static void main(String[] args) {
        //Deserialize
        String jsonInput = "{\"imdbId\":\"tt0472043\",\"actors\":" +
            "[{\"imdbId\":\"nm2199632\",\"dateOfBirth\":\"1982-09-21T12:00:00+01:00\"," +
            "\"filmography\":[\"Apocalypto\",\"Beatdown\",\"Wind Walkers\"]}]}";

        Movie outputMovie = new Gson().fromJson(jsonInput, Movie.class);
        System.out.println(outputMovie.toString());

        //Custom Deserialize
        Gson gson = new GsonBuilder()
            .registerTypeAdapter(ActorGson.class, new ActorGsonDeserializer())
            .create();

        Movie outputMovieCustom = gson.fromJson(jsonInput, Movie.class);
        System.out.println(outputMovieCustom.toString());
    }
}
