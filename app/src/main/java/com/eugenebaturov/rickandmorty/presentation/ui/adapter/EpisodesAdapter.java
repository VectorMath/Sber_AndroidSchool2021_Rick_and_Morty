package com.eugenebaturov.rickandmorty.presentation.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.eugenebaturov.rickandmorty.R;
import com.eugenebaturov.rickandmorty.models.domain.Episode;
import com.eugenebaturov.rickandmorty.presentation.ui.viewholder.EpisodeViewHolder;

import java.util.ArrayList;
import java.util.List;

public final class EpisodesAdapter extends RecyclerView.Adapter<EpisodeViewHolder> {
    private final EpisodePage mEpisodePage;
    private List<Episode> mData = new ArrayList<>();

    public interface EpisodePage {
        void goToEpisode(int id, int imgRes);
    }

    public EpisodesAdapter(EpisodePage episodePage) {
        mEpisodePage = episodePage;
    }

    @NonNull
    @Override
    public EpisodeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_episode, parent, false);

        return new EpisodeViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull EpisodeViewHolder holder, int position) {

        Episode episode = mData.get(position);
        String title = episode.getTitle();
        String seasonNumber = getSeason(episode.getEpisodeNumber());
        int charactersCount = episode.getCharacters().size();

        holder.episodeSeasonImageView.setImageResource(getImageSeason(seasonNumber));
        holder.episodeTitleTextView.setText(title);
        holder.episodeCharactersCountTextView.setText(String.valueOf(charactersCount));

        holder.itemView.setOnClickListener(v -> mEpisodePage.goToEpisode(episode.getId(), getImageSeason(seasonNumber)));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void updateData(List<Episode> data) {
        mData = data;
        notifyDataSetChanged();
    }

    private String getSeason(String episodeNumber) {
        return episodeNumber.substring(2,3);
    }

    private int getImageSeason(String season) {
        switch (season) {
            case "1" : {
                return R.drawable.ic_first_season_black;
            }

            case "2" : {
                return R.drawable.ic_second_season_black;
            }

            case "3" : {
                return R.drawable.ic_thrid_season_black;
            }

            case "4" : {
                return R.drawable.ic_fourth_season_black;
            }

            case "5" : {
                return R.drawable.ic_fifth_season_black;
            }
        }
        return 0;
    }
}
