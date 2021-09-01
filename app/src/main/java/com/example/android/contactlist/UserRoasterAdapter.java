package com.example.android.contactlist;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class UserRoasterAdapter extends RecyclerView.Adapter<UserRoasterAdapter.UserRoasterViewHolder>{

    private ArrayList<Data> roasterArrayList;
    Context context;

    public UserRoasterAdapter(ArrayList<Data> roasterArrayList, Context context) {
        this.roasterArrayList = roasterArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public UserRoasterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_roaster_row, parent, false);

        return new UserRoasterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserRoasterViewHolder holder, int position) {

        final Data temp = roasterArrayList.get(position);

        holder.tv_name.setText(roasterArrayList.get(position).getName());
        holder.tv_position.setText(roasterArrayList.get(position).getPosition());

        Picasso.get().load(roasterArrayList.get(position).getImage_url()).into(holder.Tv_image_url);

        holder.Tv_image_url.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailsScreenActivity.class);

                intent.putExtra("image_url", temp.getImage_url());
                intent.putExtra("name", temp.getName());
                intent.putExtra("position", temp.getPosition());

                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return roasterArrayList.size();
    }

    public class UserRoasterViewHolder extends RecyclerView.ViewHolder{

        TextView tv_name, tv_position;
        ImageView Tv_image_url;

        public UserRoasterViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_name = itemView.findViewById(R.id.tv_name);
            tv_position = itemView.findViewById(R.id.tv_position);
            Tv_image_url = itemView.findViewById(R.id.tv_image_url);

        }
    }
}
