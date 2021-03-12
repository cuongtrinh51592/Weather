package com.example.weather_cuongtrinh;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.weather_cuongtrinh.ConvertWeatherIcon;
import com.example.weather_cuongtrinh.ConvertDateTime;
import com.example.weather_cuongtrinh.Item;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter {
    Activity activity;
    List<Item> list;

    ConvertDateTime cvDateTime = new ConvertDateTime();
    ConvertWeatherIcon cvWeatherIcon = new ConvertWeatherIcon();

    public HomeAdapter(Activity activity, List<Item> list) {
        this.activity = activity;
        this.list = list;
    }

    public void reloadData(List<Item> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = activity.getLayoutInflater().inflate(R.layout.item_home, parent, false);
        HomeHolder holder = new HomeHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Item model = list.get(position);
        HomeHolder vh = (HomeHolder) holder;
        vh.tvTime.setText(cvDateTime.convertDateTime(model.getDateTime()));
        Glide.with(activity).load(cvWeatherIcon.convertIcon(model.getWeatherIcon())).into(vh.ivIcon);
        vh.tvTemperature.setText(model.getTemperature().getValue().toString());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class HomeHolder extends RecyclerView.ViewHolder {
        TextView tvTemperature, tvTime;
        ImageView ivIcon;

        public HomeHolder(@NonNull View itemView) {
            super(itemView);
            tvTime = itemView.findViewById(R.id.tvDateTime);
            ivIcon = itemView.findViewById(R.id.ivWeatherIcon);
            tvTemperature = itemView.findViewById(R.id.tvTemperatureValue);

        }
    }





}
