package space.Android3.lesson2.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import space.Android3.lesson2.R;
import space.Android3.lesson2.data.model.Film;
import space.Android3.lesson2.data.remote.RetrofitBuilder;
import space.Android3.lesson2.data.storage.FilmStorage;

public class MainActivity extends AppCompatActivity {

    private final FilmStorage filmStorage = new FilmStorage();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        filmStorage.getFilm("58611129-2dbc-4a81-a72f-77ddfc1b1b49", film -> Log.d("tag", film.toString()));
        filmStorage.getPeople("986faac6-67e3-4fb8-a9ee-bad077c2e7fe", people -> Log.d("tag", people.toString()));

        Log.d("tag","some code");
    }
}