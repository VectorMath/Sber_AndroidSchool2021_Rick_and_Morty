package com.eugenebaturov.rickandmorty.presentation.ui.adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

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
        return LocationViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull LocationViewHolder holder, int position) {
        final Location location = mData.get(position);
        holder.bind(location, mLocationPage);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
