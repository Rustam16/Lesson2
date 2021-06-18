package space.Android3.lesson2.data.remote;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import space.Android3.lesson2.data.model.Film;
import space.Android3.lesson2.data.model.People;

public interface GhibliApi {

    @GET("films/{id}")
    Call<Film> getFilm(
            @Path("id") String filmId
    );

    @GET("films/")
    Call<List<Film>> getAllFilms();

    @GET("films{id}")
    Call<Film> getFilms(@Path("id") String id);

    @GET("people/{id}")
    Call<People> getPeople(
            @Path("id") String peopleId
    );

}
