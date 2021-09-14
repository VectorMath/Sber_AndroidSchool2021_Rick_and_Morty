package com.eugenebaturov.rickandmorty.presentation.ui.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.eugenebaturov.rickandmorty.R;
import com.eugenebaturov.rickandmorty.models.domain.Episode;
import com.eugenebaturov.rickandmorty.presentation.ui.fragment.episode.EpisodeListFragment;

/**
 * Вью-холдер эпизода.
 */
public final class EpisodeViewHolder extends RecyclerView.ViewHolder {
    public ImageView episodeSeasonImageView;
    public TextView episodeTitleTextView;
    public TextView episodeCharactersCountTextView;

    /**
     * Создаёт экземпляр {@link EpisodeViewHolder} с уже готовой вьюшкой.
     *
     * @param parent родительская вью(вью-группа).
     * @return ВьюХолдер эпизода.
     */
    public static EpisodeViewHolder create(@NonNull final ViewGroup parent) {
        View itemView = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_episode, parent, false);

        return new EpisodeViewHolder(itemView);
    }

    /**
     * Заполняет вью-холдер данными из эпизода,
     * и вешает слушателя на возможность перехода к эпизоду.
     *
     * @param episode      эпизод
     * @param mEpisodePage интерфейс {@link EpisodeListFragment.BottomNavigation}.
     */
    public void bind(@NonNull final Episode episode,
                     @NonNull final EpisodeListFragment.BottomNavigation mEpisodePage) {
        final String title = episode.getTitle();
        final String seasonNumber = getSeason(episode.getEpisodeNumber());
        final int charactersCount = episode.getCharacters().size();

        episodeSeasonImageView.setImageResource(getImageSeason(seasonNumber));
        episodeTitleTextView.setText(title);
        episodeCharactersCountTextView.setText(String.valueOf(charactersCount));

        itemView.setOnClickListener(v -> {
            assert mEpisodePage != null;
            mEpisodePage.goToEpisode(episode.getId(), getImageSeason(seasonNumber));
        });
    }

    /**
     * Конструктор класса.
     *
     * @param itemView вьюшка, которая используется в качестве элемента списка.
     */
    private EpisodeViewHolder(@NonNull View itemView) {
        super(itemView);
        init(itemView);
    }

    private void init(final View view) {
        episodeSeasonImageView = view.findViewById(R.id.episode_season_numb_imageView);
        episodeTitleTextView = view.findViewById(R.id.episode_title_textView);
        episodeCharactersCountTextView = view.findViewById(R.id.episode_characters_count_textView);
    }

    private String getSeason(@NonNull final String episodeNumber) {
        return episodeNumber.substring(2, 3);
    }

    private int getImageSeason(@NonNull final String season) {
        switch (season) {
            case "1": {
                return R.drawable.ic_first_season_black;
            }

            case "2": {
                return R.drawable.ic_second_season_black;
            }

            case "3": {
                return R.drawable.ic_thrid_season_black;
            }

            case "4": {
                return R.drawable.ic_fourth_season_black;
            }

            case "5": {
                return R.drawable.ic_fifth_season_black;
            }
        }
        return 0;
    }
}
