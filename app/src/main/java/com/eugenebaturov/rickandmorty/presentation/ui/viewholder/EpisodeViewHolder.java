package com.eugenebaturov.rickandmorty.presentation.ui.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.eugenebaturov.rickandmorty.R;

public final class EpisodeViewHolder extends RecyclerView.ViewHolder {
    public ImageView episodeSeasonImageView;
    public TextView episodeTitleTextView;
    public TextView episodeCharactersCountTextView;

    public EpisodeViewHolder(@NonNull View itemView) {
        super(itemView);
        init(itemView);
    }

    private void init(View view) {
        episodeSeasonImageView = view.findViewById(R.id.episodeSeasonNumb_imageView);
        episodeTitleTextView = view.findViewById(R.id.episodeTitle_textView);
        episodeCharactersCountTextView = view.findViewById(R.id.episodeCharactersCount_textView);
    }
}
