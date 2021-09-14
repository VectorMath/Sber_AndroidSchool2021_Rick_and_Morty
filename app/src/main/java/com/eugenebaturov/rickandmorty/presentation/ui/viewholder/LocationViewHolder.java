package com.eugenebaturov.rickandmorty.presentation.ui.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.eugenebaturov.rickandmorty.R;
import com.eugenebaturov.rickandmorty.models.domain.Location;
import com.eugenebaturov.rickandmorty.presentation.ui.fragment.character.CharacterListFragment;
import com.eugenebaturov.rickandmorty.presentation.ui.fragment.location.LocationListFragment;

/**
 * Вью-холдер локации.
 */
public final class LocationViewHolder extends RecyclerView.ViewHolder {

    public ImageView locationTypeImageView;
    public TextView locationTypeTextView;
    public TextView locationTitleTextView;
    public TextView locationResidentsTextView;
    public TextView locationDimensionsTextView;

    /**
     * Создаёт экземпляр {@link LocationViewHolder} с уже готовой вьюшкой.
     *
     * @param parent родительская вью(вью-группа).
     * @return ВьюХолдер локации.
     */
    public static LocationViewHolder create(@NonNull final ViewGroup parent) {
        View itemView = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_location, parent, false);

        return new LocationViewHolder(itemView);
    }

    /**
     * Заполняет вью-холдер данными из локации,
     * и вешает слушателя на возможность перехода к локации.
     *
     * @param location      локация.
     * @param mLocationPage интерфейс {@link LocationListFragment.BottomNavigation}.
     */
    public void bind(@NonNull final Location location,
                     @NonNull final LocationListFragment.BottomNavigation mLocationPage) {
        final String name = location.getName();
        final String type = location.getType();
        final String dimension = location.getDimension();
        final String residentsCount = String.valueOf(location.getResidents().size());

        locationTitleTextView.setText(name);
        locationTypeTextView.setText(type);
        locationDimensionsTextView.setText(dimension);
        locationResidentsTextView.setText(residentsCount);

        itemView.setOnClickListener(v -> {
            assert mLocationPage != null;
            mLocationPage.goToLocation(location.getId());
        });
    }

    /**
     * Конструктор класса.
     *
     * @param itemView вьюшка, которая используется в качестве элемента списка.
     */
    private LocationViewHolder(@NonNull View itemView) {
        super(itemView);
        init(itemView);
    }

    private void init(final View view) {
        locationTypeImageView = view.findViewById(R.id.location_type_imageView);
        locationTypeTextView = view.findViewById(R.id.location_type_textView);
        locationTitleTextView = view.findViewById(R.id.location_title_textView);
        locationResidentsTextView = view.findViewById(R.id.location_population_count_textView);
        locationDimensionsTextView = view.findViewById(R.id.location_dimension_textView);
    }
}
