package com.eugenebaturov.rickandmorty.presentation.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.eugenebaturov.rickandmorty.R;
import com.eugenebaturov.rickandmorty.models.domain.Character;
import com.eugenebaturov.rickandmorty.presentation.ui.activity.CharacterActivity;
import com.eugenebaturov.rickandmorty.presentation.ui.viewholder.CharacterViewHolder;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Адаптер для списка {@link Character}.
 */
public final class CharactersAdapter extends RecyclerView.Adapter<CharacterViewHolder> {

    private List<Character> mData = new ArrayList<>();
    private final CharacterPage mCharacterPage;

    /**
     * Callback-интерфейс для перехода на {@link CharacterActivity}.
     */
    public interface CharacterPage {

        /**
         * Переход на активити конкретного персонажа.
         * @param id id персонажа.
         */
        void goToCharacterActivity(int id);
    }

    /**
     * Конструктор адаптера.
     * @param characterPage реализация интерфейса {@link CharacterPage}.
     */
    public CharactersAdapter(CharacterPage characterPage) {
        mCharacterPage = characterPage;
    }

    /**
     * Обновляет список персонажей в адаптере.
     * @param data список персонажей.
     */
    public void updateData(List<Character> data) {
        mData = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CharacterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_character, parent, false);

        return new CharacterViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CharacterViewHolder holder, int position) {
        Character character = mData.get(position);
        String imageUrl = character.getImage();
        String name = character.getName();
        String status = character.getStatus();

        Picasso.get().load(imageUrl).into(holder.characterImageView);
        setImageStatus(character.getStatus(), holder);
        holder.characterNameTextView.setText(name);
        holder.characterStatusTextView.setText(status);

        holder.itemView.setOnClickListener(
                v -> mCharacterPage.goToCharacterActivity(character.getId()));
    }

    private void setImageStatus(String status, CharacterViewHolder holder) {

        switch (status) {
            case "Alive": {
                holder.characterStatusImageView.setImageResource(R.drawable.ic_status_alive);
                break;
            }

            case "Dead": {
                holder.characterStatusImageView.setImageResource(R.drawable.ic_status_dead);
                break;
            }

            case "unknown": {
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
