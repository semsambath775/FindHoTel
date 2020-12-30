package com.example.findhotel.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.findhotel.R;
import com.example.findhotel.model.TopHotelsData;

import java.util.List;

public class TopHotelsAdapter extends RecyclerView.Adapter<TopHotelsAdapter.TopHotelsViewHolder> {

    Context context;
    List<TopHotelsData> topHotelsDataList;

    public TopHotelsAdapter(Context context, List<TopHotelsData> topHotelsDataList) {
        this.context = context;
        this.topHotelsDataList = topHotelsDataList;
    }

    @NonNull
    @Override
    public TopHotelsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.top_hotels_row_item, parent, false);
        // Here we create a recyclerView row item
        return new TopHotelsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TopHotelsViewHolder holder, int position) {
        holder.hotelImage.setImageResource(topHotelsDataList.get(position).getImageUrl());
        holder.hotelName.setText(topHotelsDataList.get(position).getHotelName());
        holder.hotelAddress.setText(topHotelsDataList.get(position).getHotelAddress());
        holder.hotelPrice.setText(topHotelsDataList.get(position).getHotelPrice());
    }

    @Override
    public int getItemCount() {
        return topHotelsDataList.size();
    }

    public static final class TopHotelsViewHolder extends RecyclerView.ViewHolder {
        ImageView hotelImage;
        TextView hotelName, hotelAddress, hotelPrice;

        public TopHotelsViewHolder(@NonNull View itemView) {
            super(itemView);

            hotelImage = itemView.findViewById(R.id.hotel_image);
            hotelName = itemView.findViewById(R.id.hotel_name);
            hotelAddress = itemView.findViewById(R.id.hotel_address);
            hotelPrice = itemView.findViewById(R.id.hotel_price);
        }
    }
}
