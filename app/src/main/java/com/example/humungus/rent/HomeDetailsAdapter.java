package com.example.humungus.rent;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class HomeDetailsAdapter extends RecyclerView.Adapter<HomeDetailsAdapter.HomeDelailsViewHolder>{


    @NonNull
    @Override
    public HomeDelailsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_detail,parent,false);

        return new HomeDelailsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeDelailsViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class HomeDelailsViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView tittle;
        TextView price;
        public HomeDelailsViewHolder(View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.thumbnail);
            tittle = itemView.findViewById(R.id.housetitle);
            price = itemView.findViewById(R.id.houseprice);

        }
    }
}
