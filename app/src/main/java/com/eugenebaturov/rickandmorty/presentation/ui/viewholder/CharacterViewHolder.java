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
import com.eugenebaturov.rickandmorty.presentation.ui.fragment.character.CharacterListFragment;
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
     * @param character      персонаж
     * @param mCharacterPage интерфейс {@link CharacterListFragment.BottomNavigation}.
     */
    public void bind(@NonNull final Character character,
                     @NonNull final CharacterListFragment.BottomNavigation mCharacterPage) {
        final String imageUrl = character.getImage();
        final String name = character.getName();
        final String status = character.getStatus();

        ImageLoader.loadFromPicasso(imageUrl, characterImageView);
        setImageStatus(character.getStatus());
        characterNameTextView.setText(name);
        characterStatusTextView.setText(status);

        itemView.setOnClickListener(
                v -> {
                    assert mCharacterPage != null;
                    mCharacterPage.goToCharacter(character.getId());
                });
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

    private void setImageStatus(String status) {
        final String STATUS_ALIVE = "Alive";
        final String STATUS_DEAD = "Dead";

        switch (status) {
            case STATUS_ALIVE: {
                this.characterStatusImageView.setImageResource(R.drawable.ic_status_alive);
                break;
            }

            case STATUS_DEAD: {
                this.characterStatusImageView.setImageResource(R.drawable.ic_status_dead);
                break;
            }

            default: {
                this.characterStatusImageView.setImageResource(R.drawable.ic_status_unknown);
                break;
            }
        }
    }
}
