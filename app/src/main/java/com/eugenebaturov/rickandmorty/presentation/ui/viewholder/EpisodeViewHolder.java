package com.eugenebaturov.rickandmorty.presentation.ui.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.eugenebaturov.rickandmorty.R;

/**
 * Вью-холдер эпизода.
 */
public final class EpisodeViewHolder extends RecyclerView.ViewHolder {
    public ImageView episodeSeasonImageView;
    public TextView episodeTitleTextView;
    public TextView episodeCharactersCountTextView;

    /**
     * Конструктор класса.
     *
     * @param itemView вьюшка, которая используется в качестве элемента списка.
     */
    public EpisodeViewHolder(@NonNull View itemView) {
        super(itemView);
        init(itemView);
    }

    private void init(View view) {
        episodeSeasonImageView = view.findViewById(R.id.episode_season_numb_imageView);
        episodeTitleTextView = view.findViewById(R.id.episode_title_textView);
        episodeCharactersCountTextView = view.findViewById(R.id.episode_characters_count_textView);
    }
}
