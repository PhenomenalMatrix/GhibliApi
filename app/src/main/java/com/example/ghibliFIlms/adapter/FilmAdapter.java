package com.example.ghibliFIlms.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a32work.R;
import com.example.ghibliFIlms.data.models.FilmModel;

import java.util.ArrayList;
import java.util.List;

public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.FilmAdapterVH> {

    ItemClickListener listener;
    public ArrayList<FilmModel> filmList = new ArrayList<>();

    public void setOnclick(ItemClickListener listener){
        this.listener = listener;
    }

    public void SetFilmModel(ArrayList<FilmModel> filmModels){
        this.filmList = filmModels;
        notifyDataSetChanged();
    }
   
    @NonNull
    @Override
    public FilmAdapterVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler,parent,false);
        return new FilmAdapterVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FilmAdapterVH holder, int position) {
        holder.onBind(filmList.get(position));
    }

    @Override
    public int getItemCount() { return filmList.size(); }

    public class FilmAdapterVH extends RecyclerView.ViewHolder {

        TextView name;
        TextView desc;

        public FilmAdapterVH(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(getAdapterPosition());
                }
            });
            
            name = itemView.findViewById(R.id.films_name_tv);
            desc = itemView.findViewById(R.id.films_author_tv);
        }

        

        public void onBind(FilmModel filmModel) {
            name.setText(filmModel.getTitle());
            desc.setText(filmModel.getDescription());
        }
    }

    public interface ItemClickListener {
        void onItemClick(int position);
    }
}
