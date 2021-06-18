package space.Android3.lesson2.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import space.Android3.lesson2.R;
import space.Android3.lesson2.data.model.Film;

public class FilmsAdapter  extends RecyclerView.Adapter<FilmsAdapter.FilmsHolder> {

    private List<Film> films = new ArrayList<>();
    private ItemClickListener listener;


    @NonNull
    @Override
    public FilmsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FilmsHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull FilmsHolder holder, int position) {
        holder.onBind(films.get(position));
    }

    public void addToList(List<Film> films) {
        this.films = films;
        notifyDataSetChanged();
    }

    public void setListener(ItemClickListener listener) {
        this.listener = listener;
    }

    @Override
    public int getItemCount() {
        return films.size();
    }

    public class FilmsHolder extends RecyclerView.ViewHolder {
        private final TextView txtTitle;

        public FilmsHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(v -> listener.onItemClick(films.get(getAdapterPosition())));
            txtTitle = itemView.findViewById(R.id.mainTextForRV);
        }

        public void onBind(Film film) {
            txtTitle.setText(film.getTitle());
        }
    }

    interface ItemClickListener {
        void onItemClick(Film film);
    }
}
