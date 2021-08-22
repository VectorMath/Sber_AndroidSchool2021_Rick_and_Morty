package com.eugenebaturov.rickandmorty.data.api;

import com.eugenebaturov.rickandmorty.data.entity.CharacterRequest;
import com.eugenebaturov.rickandmorty.data.entity.list.ListCharacterRequest;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import static com.eugenebaturov.rickandmorty.data.api.RickAndMortyURL.CHARACTERS_URL;

/**
 * API которое позволяет получить информацию о персонажах {@link CharacterRequest} с сервера.
 */
public interface CharacterApi {

    /**
     * Ручка, которая получает информацию о всех персонажах с сервера.
     *
     * @return Список персонажей в Call {@link Call} обёртке.
     */
    @GET(CHARACTERS_URL)
    Call<ListCharacterRequest> getAllCharacters();

    /**
     * Ручка, которая получает информацию о персонаже по id с сервера.
     *
     * @param characterId - id персонажа.
     * @return персонаж в Call {@link Call} обёртке.
     */
    @GET(CHARACTERS_URL + "{id}")
    Call<CharacterRequest> getCharacterById(@Path("id") int characterId);
}