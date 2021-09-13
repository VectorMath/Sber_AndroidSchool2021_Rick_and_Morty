package com.eugenebaturov.rickandmorty.presentation.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.eugenebaturov.rickandmorty.R;
import com.eugenebaturov.rickandmorty.models.domain.Location;
import com.eugenebaturov.rickandmorty.presentation.ui.fragment.location.LocationListFragment;
import com.eugenebaturov.rickandmorty.presentation.ui.viewholder.LocationViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Адаптер для списка {@link Location}.
 */
public final class LocationsAdapter extends RecyclerView.Adapter<LocationViewHolder> {
    @Nullable
    private final LocationListFragment.BottomNavigation mLocationPage;

    @NonNull
    private List<Location> mData = new ArrayList<>();

    /**
     * Конструктор адаптера.
     *
     * @param locationPage реализация интерфейса {@link LocationListFragment.BottomNavigation}.
     */
    public LocationsAdapter(@Nullable LocationListFragment.BottomNavigation locationPage) {
        mLocationPage = locationPage;
    }

    /**
     * Обновляет список локаций в адаптере.
     *
     * @param data список локаций.
     */
    public void updateData(List<Location> data) {
        mData = data;
        notifyDataSetChanged();
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
        final Location location = mData.get(position);
        final String name = location.getName();
        final String type = location.getType();
        final String dimension = location.getDimension();
        final String residentsCount = String.valueOf(location.getResidents().size());

        holder.locationTitleTextView.setText(name);
        holder.locationTypeTextView.setText(type);
        holder.locationDimensionsTextView.setText(dimension);
        holder.locationResidentsTextView.setText(residentsCount);

        holder.itemView.setOnClickListener(v -> {
            assert mLocationPage != null;
            mLocationPage.goToLocation(location.getId());
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
