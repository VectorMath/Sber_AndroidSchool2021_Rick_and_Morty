package com.eugenebaturov.rickandmorty.data.api;

import com.eugenebaturov.rickandmorty.BuildConfig;

/**
 * Класс, который хранит в себе урлы, для Rick&MortyAPI.
 */
public final class RickAndMortyURL {

    // Можно вынести в gradle app, для настроек разных тип сборок
    public static final String BASE_URL = "https://rickandmortyapi.com/api/";

    // Characters URL.
    public static final String CHARACTERS_URL = "character/";

    // Episode URL.
    public static final String EPISODES_URL = "episode/";

    // Location URL.
    public static final String LOCATIONS_URL = "location/";
}