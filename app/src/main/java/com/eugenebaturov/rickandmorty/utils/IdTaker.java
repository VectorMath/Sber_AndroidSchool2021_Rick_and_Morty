package com.eugenebaturov.rickandmorty.utils;

import static com.eugenebaturov.rickandmorty.data.api.RickAndMortyURL.BASE_URL;
import static com.eugenebaturov.rickandmorty.data.api.RickAndMortyURL.CHARACTERS_URL;
import static com.eugenebaturov.rickandmorty.data.api.RickAndMortyURL.EPISODES_URL;
import static com.eugenebaturov.rickandmorty.data.api.RickAndMortyURL.LOCATIONS_URL;

/**
 * Класс, который вытаскивает id из url-строки.
 */
public final class IdTaker {
    private static final int CHARACTER_URL_LENGTH = BASE_URL.length() + CHARACTERS_URL.length();
    private static final int EPISODE_URL_LENGTH = BASE_URL.length() + EPISODES_URL.length();
    private static final int LOCATION_URL_LENGTH = BASE_URL.length() + LOCATIONS_URL.length();

    /**
     * Получает id персонажа из url-строки.
     *
     * @param url адресс персонажа.
     * @return id персонажа.
     */
    public static int getCharacterId(String url) {
        String id = url.substring(CHARACTER_URL_LENGTH);
        return Integer.parseInt(id);
    }

    /**
     * Получает id локации из url-строки.
     *
     * @param url адресс локации.
     * @return id локации.
     */
    public static int getLocationId(String url) {
        String id = url.substring(LOCATION_URL_LENGTH);
        return Integer.parseInt(id);
    }

    /**
     * Получает id эпизода из url-строки.
     *
     * @param url адресс эпизода.
     * @return id эпизода.
     */
    public static int getEpisodeId(String url) {
        String id = url.substring(EPISODE_URL_LENGTH);
        return Integer.parseInt(id);
    }
}
