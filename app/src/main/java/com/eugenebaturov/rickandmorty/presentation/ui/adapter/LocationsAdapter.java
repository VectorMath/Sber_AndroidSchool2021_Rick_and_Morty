package com.eugenebaturov.rickandmorty.presentation.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.eugenebaturov.rickandmorty.R;
import com.eugenebaturov.rickandmorty.models.domain.Location;
import com.eugenebaturov.rickandmorty.presentation.ui.viewholder.LocationViewHolder;

import java.util.ArrayList;
import java.util.List;

public final class LocationsAdapter extends RecyclerView.Adapter<LocationViewHolder> {
    private final LocationPage mLocationPage;
    private List<Location> mData = new ArrayList<>();

    public interface LocationPage {
        void goToLocation(int id);
    }

    public LocationsAdapter(LocationPage locationPage) {
        mLocationPage = locationPage;
    }

    @NonNull
    @Override
    public LocationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_location, parent, false);

        return new LocationViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull LocationViewHolder holder, int position) {
        Location location = mData.get(position);
        String name = location.getName();
        String type = location.getType();
        String dimension = location.getDimension();
        String residentsCount = String.valueOf(location.getResidents().size());

        holder.locationTitleTextView.setText(name);
        holder.locationTypeTextView.setText(type);
        holder.locationDimensionsTextView.setText(dimension);
        holder.locationResidentsTextView.setText(residentsCount);

        holder.itemView.setOnClickListener(v -> mLocationPage.goToLocation(location.getId()));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void updateData(List<Location> data) {
        mData = data;
        notifyDataSetChanged();
    }
}
