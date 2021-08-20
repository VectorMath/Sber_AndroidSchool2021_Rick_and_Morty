package com.eugenebaturov.rickandmorty.data.api;

/**
 * Класс, который хранит в себе урлы, для Rick&MortyAPI.
 * <p>
 * Где используется:
 * - {@link CharacterApi}
 * - {@link EpisodeApi}
 * - {@link LocationApi}
 */
public class RickAndMortyURL {

    public static final String BASE_URL = "https://rickandmortyapi.com/api/";

    // Characters URL.
    public static final String CHARACTERS_URL = "character/";

    // Episode URL.
    public static final String EPISODES_URL = "location/";

    // Location URL.
    public static final String LOCATIONS_URL = "episode/";
}