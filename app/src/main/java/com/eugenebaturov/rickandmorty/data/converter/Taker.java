package com.eugenebaturov.rickandmorty.data.converter;

import androidx.annotation.NonNull;

import com.eugenebaturov.rickandmorty.BuildConfig;
import com.eugenebaturov.rickandmorty.R;

import static com.eugenebaturov.rickandmorty.data.api.RickAndMortyURL.LOCATIONS_URL;

/**
 * Класс, который вытаскивает дополнительные данные из сущности.
 */
public final class Taker {
    private static final int LOCATION_URL_LENGTH
            = BuildConfig.BASE_URL.length() + LOCATIONS_URL.length();

    /**
     * Получает id локации из url-строки.
     *
     * @param url адресс локации.
     * @return id локации.
     */
    public static int getLocationId(@NonNull String url) {
        if (!url.equals("")) {
            String id = url.substring(LOCATION_URL_LENGTH);
            return Integer.parseInt(id);
        }
        return 0;
    }

    /**
     * Получает ресурс изображения статуса персонажа.
     *
     * @param status статус персонажа
     * @return drawable ресурс.
     */
    public static int getCharacterImageStatusResource(String status) {
        final String STATUS_ALIVE = "Alive";
        final String STATUS_DEAD = "Dead";

        switch (status) {
            case STATUS_ALIVE: {
                return R.drawable.ic_status_alive;
            }

            case STATUS_DEAD: {
                return R.drawable.ic_status_dead;
            }

            default: {
                return R.drawable.ic_status_unknown;
            }
        }
    }
}
