package com.eugenebaturov.rickandmorty.presentation.ui.adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.eugenebaturov.rickandmorty.models.domain.Episode;
import com.eugenebaturov.rickandmorty.presentation.ui.Navigation;
import com.eugenebaturov.rickandmorty.presentation.ui.viewholder.EpisodeViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Адаптер для списка {@link Episode}.
 */
public final class EpisodesAdapter extends RecyclerView.Adapter<EpisodeViewHolder> {
    @NonNull
    private List<Episode> mData = new ArrayList<>();

    @NonNull
    private final Navigation mNavigation;

    /**
     * Конструктор адаптера.
     *
     * @param navigation реализация интерфейса {@link Navigation}.
     */
    public EpisodesAdapter(@NonNull Navigation navigation) {
        mNavigation = navigation;
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
        holder.bind(episode, mNavigation);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
