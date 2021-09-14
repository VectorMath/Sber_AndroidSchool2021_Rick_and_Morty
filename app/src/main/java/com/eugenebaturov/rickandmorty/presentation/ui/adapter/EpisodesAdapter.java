package com.eugenebaturov.rickandmorty.presentation.ui.adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.eugenebaturov.rickandmorty.models.domain.Episode;
import com.eugenebaturov.rickandmorty.presentation.ui.fragment.episode.EpisodeListFragment;
import com.eugenebaturov.rickandmorty.presentation.ui.viewholder.EpisodeViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Адаптер для списка {@link Episode}.
 */
public final class EpisodesAdapter extends RecyclerView.Adapter<EpisodeViewHolder> {
    @Nullable
    private final EpisodeListFragment.BottomNavigation mEpisodePage;

    @NonNull
    private List<Episode> mData = new ArrayList<>();

    /**
     * Конструктор адаптера.
     *
     * @param episodePage реализация интерфейса {@link EpisodeListFragment.BottomNavigation}.
     */
    public EpisodesAdapter(@Nullable EpisodeListFragment.BottomNavigation episodePage) {
        mEpisodePage = episodePage;
    }

    /**
     * Обновляет список эпизодов в адаптере.
     *
     * @param data список эпизодов.
     */
    public void updateData(@NonNull final List<Episode> data) {
        mData = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public EpisodeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return EpisodeViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull EpisodeViewHolder holder, int position) {
        final Episode episode = mData.get(position);
        holder.bind(episode, mEpisodePage);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
