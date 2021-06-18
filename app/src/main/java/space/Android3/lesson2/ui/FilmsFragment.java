package space.Android3.lesson2.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import space.Android3.lesson2.R;
import space.Android3.lesson2.data.model.Film;
import space.Android3.lesson2.data.remote.RetrofitBuilder;

public class FilmsFragment extends Fragment {

    private final List<Film> films = new ArrayList<>();
    private NavController controller;

    public FilmsFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_films, container, false);
        controller = Navigation.findNavController(requireActivity(), R.id.navHostFragment);
        openFilm(view);
        return view;
    }

    private void init(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.rv_films);
        FilmsAdapter adapter = new FilmsAdapter();
        adapter.setListener(film -> {
            Bundle bundle = new Bundle();
            bundle.putString("film", film.getId());
            controller.navigate(R.id.filmsFragmentDetails, bundle);
        });
        adapter.addToList(films);
        recyclerView.setAdapter(adapter);
    }

    private void openFilm(View view) {
        RetrofitBuilder.getInstance().getAllFilms().enqueue(new Callback<List<Film>>() {
            @Override
            public void onResponse(Call<List<Film>> call, Response<List<Film>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    films.clear();
                    films.addAll(response.body());
                    init(view);
                }
            }

            @Override
            public void onFailure(Call<List<Film>> call, Throwable t) {
            }
        });
    }
}