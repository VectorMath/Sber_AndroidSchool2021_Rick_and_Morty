package com.eugenebaturov.rickandmorty.presentation.ui.adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.eugenebaturov.rickandmorty.models.domain.Character;
import com.eugenebaturov.rickandmorty.presentation.ui.Navigation;
import com.eugenebaturov.rickandmorty.presentation.ui.viewholder.CharacterViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Адаптер для списка {@link Character}.
 */
public final class CharactersAdapter extends RecyclerView.Adapter<CharacterViewHolder> {
    @NonNull
    private List<Character> mData = new ArrayList<>();

    @NonNull
    private final Navigation mNavigation;

    /**
     * Конструктор адаптера.
     *
     * @param navigation реализация {@link Navigation}
     */
    public CharactersAdapter(@NonNull Navigation navigation) {
        mNavigation = navigation;
    }

    /**
     * Обновляет список персонажей в адаптере.
     *
     * @param data список персонажей.
     */
    public void updateData(@NonNull final List<Character> data) {
        mData = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CharacterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return CharacterViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull CharacterViewHolder holder, int position) {
        final Character character = mData.get(position);
        holder.bind(character, mNavigation);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
