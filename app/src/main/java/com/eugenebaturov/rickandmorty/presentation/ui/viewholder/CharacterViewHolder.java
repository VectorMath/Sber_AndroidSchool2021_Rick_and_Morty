package com.eugenebaturov.rickandmorty.presentation.ui.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.eugenebaturov.rickandmorty.R;

/**
 * Вью-холдер персонажа.
 */
public final class CharacterViewHolder extends RecyclerView.ViewHolder {
    public ImageView characterStatusImageView;
    public ImageView characterImageView;
    public TextView characterNameTextView;
    public TextView characterStatusTextView;

    /**
     * Коструктор класса.
     *
     * @param itemView вьюшка, которая используется в качестве элемента списка.
     */
    public CharacterViewHolder(@NonNull View itemView) {
        super(itemView);
        init(itemView);
    }

    private void init(View view) {
        characterStatusImageView = view.findViewById(R.id.character_item_status_imageView);
        characterImageView = view.findViewById(R.id.character_imageView);
        characterNameTextView = view.findViewById(R.id.character_name_textView);
        characterStatusTextView = view.findViewById(R.id.character_status_textView);
    }
}
