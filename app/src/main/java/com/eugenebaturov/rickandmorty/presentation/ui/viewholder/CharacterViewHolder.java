package com.eugenebaturov.rickandmorty.presentation.ui.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.eugenebaturov.rickandmorty.R;
import com.eugenebaturov.rickandmorty.models.domain.Character;
import com.eugenebaturov.rickandmorty.presentation.ui.Navigation;
import com.eugenebaturov.rickandmorty.utils.ImageLoader;

/**
 * Вью-холдер персонажа.
 */
public final class CharacterViewHolder extends RecyclerView.ViewHolder {
    public ImageView characterStatusImageView;
    public ImageView characterImageView;
    public TextView characterNameTextView;
    public TextView characterStatusTextView;

    /**
     * Создаёт экземпляр {@link CharacterViewHolder} с уже готовой вьюшкой.
     *
     * @param parent родительская вью(вью-группа).
     * @return ВьюХолдер персонажа.
     */
    public static CharacterViewHolder create(@NonNull final ViewGroup parent) {
        final View itemView = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_character, parent, false);

        return new CharacterViewHolder(itemView);
    }

    /**
     * Заполняет вью-холдер данными из персонажа,
     * и вешает слушателя на возможность перехода к персонажу.
     *
     * @param character  персонаж
     * @param navigation реализация {@link Navigation}.
     */
    public void bind(@NonNull final Character character,
                     @NonNull final Navigation navigation) {
        ImageLoader.loadFromPicasso(character.getImageUrl(), characterImageView);
        characterStatusImageView.setImageResource(character.getImageStatusResource());
        characterNameTextView.setText(character.getName());
        characterStatusTextView.setText(character.getStatus());

        itemView.setOnClickListener(
                v -> navigation.goToCharacter(character.getId()));
    }

    /**
     * Коструктор класса.
     *
     * @param itemView вьюшка, которая используется в качестве элемента списка.
     */
    private CharacterViewHolder(@NonNull View itemView) {
        super(itemView);
        init(itemView);
    }

    private void init(final View view) {
        characterStatusImageView = view.findViewById(R.id.character_item_status_imageView);
        characterImageView = view.findViewById(R.id.character_imageView);
        characterNameTextView = view.findViewById(R.id.character_name_textView);
        characterStatusTextView = view.findViewById(R.id.character_status_textView);
    }
}
