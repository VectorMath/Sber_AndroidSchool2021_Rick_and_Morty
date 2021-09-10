package com.eugenebaturov.rickandmorty.presentation.ui.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.eugenebaturov.rickandmorty.R;

public final class CharacterViewHolder extends RecyclerView.ViewHolder {
    public ImageView characterStatusImageView;
    public ImageView characterImageView;
    public TextView characterNameTextView;
    public TextView characterStatusTextView;

    public CharacterViewHolder(@NonNull View itemView) {
        super(itemView);
        init(itemView);
    }

    private void init(View view) {
        characterStatusImageView = view.findViewById(R.id.character_itemStatus_imageView);
        characterImageView = view.findViewById(R.id.character_imageView);
        characterNameTextView = view.findViewById(R.id.characterName_textView);
        characterStatusTextView = view.findViewById(R.id.characterStatus_textView);
    }
}
