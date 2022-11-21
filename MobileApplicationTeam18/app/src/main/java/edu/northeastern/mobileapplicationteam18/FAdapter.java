package edu.northeastern.mobileapplicationteam18;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FAdapter extends RecyclerView.Adapter<FAdapter.myViewHolder> {
    private ArrayList<FModel> models;

    public FAdapter(ArrayList<FModel> models) {
        this.models = models;
    }

    @NonNull
    @Override
    public FAdapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        return new myViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.rec0_single_item_row, null));
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rec0_single_item_row, parent, false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        int resource = models.get(position).getImageRes();
        String name = models.get(position).getName();
        String detail = models.get(position).getDetails();
        holder.setData(resource, name, detail);
//        holder.imageView.setImageResource(models.get(position).getImageRes());
//        holder.Name.setText(models.get(position).getName());
//        holder.Details.setText(models.get(position).getDetails());
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    class myViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView Name, Details;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView2);
            Name = itemView.findViewById(R.id.tvTitle);
            Details = itemView.findViewById(R.id.tvDetail);
        }

        public void setData(int resource, String name, String detail) {
            imageView.setImageResource(resource);
            Name.setText(name);
            Details.setText(detail);
        }
    }

}
