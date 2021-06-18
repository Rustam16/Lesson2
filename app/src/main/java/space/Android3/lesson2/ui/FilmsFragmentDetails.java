package space.Android3.lesson2.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import space.Android3.lesson2.R;
import space.Android3.lesson2.data.model.Film;
import space.Android3.lesson2.data.remote.RetrofitBuilder;

public class FilmsFragmentDetails extends Fragment {
    private TextView title;
    private TextView producer;
    private TextView release_date;
    private TextView running_time;
    private TextView rt_score;
    private String id;

    public FilmsFragmentDetails() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) id = getArguments().getString("film");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_films_details, container, false);
        init(view);
        openFilmFrag();
        return view;
    }

    private void init(View view) {
        title = view.findViewById(R.id.txtForFilmsTitle);
        producer = view.findViewById(R.id.txtForFilmsProducer);
        release_date = view.findViewById(R.id.txtForFilmsReleaseDate);
        running_time = view.findViewById(R.id.txtForFilmsRunningTime);
        rt_score = view.findViewById(R.id.txtForFilmsRtScore);
    }

    private void openFilmFrag() {
        RetrofitBuilder.getInstance().getFilms(id).enqueue(new Callback<Film>() {
            @Override
            public void onResponse(Call<Film> call, Response<Film> response) {
                if (response.isSuccessful() && response.body() != null) {
                    title.setText(response.body().getTitle());
                    producer.setText(response.body().getProducer());
                    release_date.setText(response.body().getReleaseDate());
                    running_time.setText(response.body().getRunningTime());
                    rt_score.setText(response.body().getRtScore());
                }
            }

            @Override
            public void onFailure(Call<Film> call, Throwable t) {
            }
        });
    }
}