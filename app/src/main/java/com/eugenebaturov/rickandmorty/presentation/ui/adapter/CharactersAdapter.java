package com.eugenebaturov.rickandmorty.presentation.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.eugenebaturov.rickandmorty.R;
import com.eugenebaturov.rickandmorty.models.domain.Character;
import com.eugenebaturov.rickandmorty.presentation.ui.fragment.character.CharacterListFragment;
import com.eugenebaturov.rickandmorty.presentation.ui.viewholder.CharacterViewHolder;
import com.eugenebaturov.rickandmorty.utils.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Адаптер для списка {@link Character}.
 */
public final class CharactersAdapter extends RecyclerView.Adapter<CharacterViewHolder> {

    @NonNull
    private List<Character> mData = new ArrayList<>();

    @Nullable
    private final CharacterListFragment.BottomNavigation mCharacterPage;

    /**
     * Конструктор адаптера.
     *
     * @param characterPage реализация {@link CharacterListFragment.BottomNavigation}
     */
    public CharactersAdapter(@Nullable CharacterListFragment.BottomNavigation characterPage) {
        mCharacterPage = characterPage;
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
        // Создание во Viewhodler
        View itemView = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_character, parent, false);

        return new CharacterViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CharacterViewHolder holder, int position) {
        final Character character = mData.get(position);
        final String imageUrl = character.getImage();
        final String name = character.getName();
        final String status = character.getStatus();

        ImageLoader.loadFromPicasso(imageUrl, holder.characterImageView);
        setImageStatus(character.getStatus(), holder);
        holder.characterNameTextView.setText(name);
        holder.characterStatusTextView.setText(status);

        holder.itemView.setOnClickListener(
                v -> {
                    assert mCharacterPage != null;
                    mCharacterPage.goToCharacter(character.getId());
                });
    }

    private void setImageStatus(String status, CharacterViewHolder holder) {
        final String STATUS_ALIVE = "Alive";
        final String STATUS_DEAD = "Dead";

        switch (status) {
            case STATUS_ALIVE: {
                holder.characterStatusImageView.setImageResource(R.drawable.ic_status_alive);
                break;
            }

            case STATUS_DEAD: {
                holder.characterStatusImageView.setImageResource(R.drawable.ic_status_dead);
                break;
            }

            default: {
                holder.characterStatusImageView.setImageResource(R.drawable.ic_status_unknown);
                break;
            }
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
