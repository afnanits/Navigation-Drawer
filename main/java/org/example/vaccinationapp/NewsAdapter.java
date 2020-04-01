package org.example.vaccinationapp;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
    public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.CustomViewHolder> {
    private Context context;
    private ArrayList<NEWS> items;
  //  private ArrayList<NEWS> subjects;

    public NewsAdapter(Context context) {
        this.context = context;
       // this.items = items;
    }



    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CustomViewHolder(LayoutInflater.from(context).inflate(R.layout.recycler_view, parent, false));
    }
    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.itemTitle.setText(items.get(position).getText());
        Glide.with(context).asBitmap().load(items.get(position).getImageUrl())
                .into(holder.itemImage);
    }
    @Override
    public int getItemCount() {
        return items.size();
    }
    public class CustomViewHolder extends RecyclerView.ViewHolder {
        private ImageView itemImage;
        private TextView itemTitle;
        public CustomViewHolder(View view) {
            super(view);
            itemImage = view.findViewById(R.id.item_image);
            itemTitle = view.findViewById(R.id.item_title);
        }
    }
    public void setSubjects(ArrayList<NEWS> subjects) {
        this.items = subjects;
        notifyDataSetChanged();
    }
}