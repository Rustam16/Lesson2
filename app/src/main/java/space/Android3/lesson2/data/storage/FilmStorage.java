package space.Android3.lesson2.data.storage;

import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import space.Android3.lesson2.data.model.Film;
import space.Android3.lesson2.data.model.People;
import space.Android3.lesson2.data.remote.RetrofitBuilder;

public class FilmStorage {


    public void getFilm(String filmId, GhibliCallback callback) {
        RetrofitBuilder.getInstance().getFilm(filmId).enqueue(new Callback<Film>() {
            @Override
            public void onResponse(Call<Film> call, Response<Film> response) {
                if (response.isSuccessful() && response.body() != null) {
                    callback.onSuccess(response.body());
                }else {
                    callback.onFailure("request error");
                }
            }

            @Override
            public void onFailure(Call<Film> call, Throwable t) {
                callback.onFailure(t.getLocalizedMessage());
            }
        });
    }

    public void getPeople(String people, GhibliCallback<People> callback) {
        RetrofitBuilder.getInstance().getPeople(people).enqueue(new Callback<People>() {
            @Override
            public void onResponse(Call<People> call, Response<People> response) {
                if (response.isSuccessful() && response.body() != null) {
                    callback.onSuccess(response.body());
                }else {
                    callback.onFailure("Request error");
                }
            }

            @Override
            public void onFailure(Call<People> call, Throwable t) {
                callback.onFailure(t.getLocalizedMessage());
            }
        });
    }


  public interface GhibliCallback<Data> {
        void onSuccess(Data film);

      default void onFailure(String errorMsg) {
          Log.d("tag", "some code");
      }
  }
}
