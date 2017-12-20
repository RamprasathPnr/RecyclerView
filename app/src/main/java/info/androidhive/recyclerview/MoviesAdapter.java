package info.androidhive.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Movie> moviesList;

    public MoviesAdapter(List<Movie> moviesList) {
        this.moviesList = moviesList;
    }

    public class MyViewHolder1 extends RecyclerView.ViewHolder {
        public TextView title, year, genre;

        public MyViewHolder1(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            genre = (TextView) view.findViewById(R.id.genre);
            year = (TextView) view.findViewById(R.id.year);
        }
    }

    public class MyViewHolder2 extends RecyclerView.ViewHolder {
        public TextView title, year, genre;

        public MyViewHolder2(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            genre = (TextView) view.findViewById(R.id.genre);
            year = (TextView) view.findViewById(R.id.year);
        }
    }




    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        switch (viewType) {
            case 1:
                View itemView = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.movie_list_row, parent, false);
                return new MyViewHolder1(itemView);
            case 2:
                View itemView1 = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.horizontal_layout_list_row, parent, false);
                return new MyViewHolder2(itemView1);
        }
    //    return new MyViewHolder(itemView);
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()) {
            case 1:
                MyViewHolder1 viewHolder1 = (MyViewHolder1)holder;
                Movie movie = moviesList.get(position);
                viewHolder1.title.setText(movie.getTitle());
                viewHolder1.genre.setText(movie.getGenre());
                viewHolder1.year.setText(movie.getYear());

                break;

            case 2:
                MyViewHolder2 viewHolder2 = (MyViewHolder2)holder;
                Movie movie2 = moviesList.get(position);
                viewHolder2.title.setText(movie2.getTitle());
                viewHolder2.genre.setText(movie2.getGenre());
                viewHolder2.year.setText(movie2.getYear());

                break;
        }
    }


   /* @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Movie movie = moviesList.get(position);
        holder.title.setText(movie.getTitle());
        holder.genre.setText(movie.getGenre());
        holder.year.setText(movie.getYear());
    }*/

    @Override
    public int getItemCount() {
        return moviesList.size();
    }

    @Override
    public int getItemViewType(int position) {
       // return super.getItemViewType(position);
        if(moviesList.get(position).getLayoutType().equalsIgnoreCase("V")){
            return 1;
        }else{
            return 2;
        }

    }
}
