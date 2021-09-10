package com.eugenebaturov.rickandmorty.presentation.ui.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.eugenebaturov.rickandmorty.R;

public final class LocationViewHolder extends RecyclerView.ViewHolder {

    public ImageView locationTypeImageView;
    public TextView locationTypeTextView;
    public TextView locationTitleTextView;
    public TextView locationResidentsTextView;
    public TextView locationDimensionsTextView;

    public LocationViewHolder(@NonNull View itemView) {
        super(itemView);
        init(itemView);
    }

    private void init(View view) {
        locationTypeImageView = view.findViewById(R.id.locationType_imageView);
        locationTypeTextView = view.findViewById(R.id.locationType_textView);
        locationTitleTextView = view.findViewById(R.id.locationTitle_textView);
        locationResidentsTextView = view.findViewById(R.id.locationPopulationCount_textView);
        locationDimensionsTextView = view.findViewById(R.id.locationDimension_textView);
    }
}
