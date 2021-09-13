package com.eugenebaturov.rickandmorty.utils;

import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.squareup.picasso.Picasso;

/**
 * Загружает изображение в ImageView через url-адресс.
 */
public final class ImageLoader {

    /**
     * Получает изображение из url-адресса и загружает его в ImageView.
     *
     * @param url       адресс изображения.
     * @param imageView вьюшка, которая хранит изображение.
     */
    public static void loadFromPicasso(@NonNull final String url,
                                       @NonNull final ImageView imageView) {
        Picasso.get().load(url).into(imageView);
    }
}
