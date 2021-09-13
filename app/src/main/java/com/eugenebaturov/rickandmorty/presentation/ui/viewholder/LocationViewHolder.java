package com.eugenebaturov.rickandmorty.presentation.ui.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.eugenebaturov.rickandmorty.R;

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
     * Конструктор класса.
     *
     * @param itemView вьюшка, которая используется в качестве элемента списка.
     */
    public LocationViewHolder(@NonNull View itemView) {
        super(itemView);
        init(itemView);
    }

    private void init(View view) {
        locationTypeImageView = view.findViewById(R.id.location_type_imageView);
        locationTypeTextView = view.findViewById(R.id.location_type_textView);
        locationTitleTextView = view.findViewById(R.id.location_title_textView);
        locationResidentsTextView = view.findViewById(R.id.location_population_count_textView);
        locationDimensionsTextView = view.findViewById(R.id.location_dimension_textView);
    }
}
