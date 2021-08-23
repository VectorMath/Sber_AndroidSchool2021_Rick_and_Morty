package com.eugenebaturov.rickandmorty.data.api;

import com.eugenebaturov.rickandmorty.models.data.CharacterResponse;
import com.eugenebaturov.rickandmorty.models.data.list.ListCharacterResponse;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

import static com.eugenebaturov.rickandmorty.data.api.RickAndMortyURL.CHARACTERS_URL;

/**
 * API которое позволяет получить информацию о персонажах {@link CharacterResponse} с сервера.
 */
public interface CharacterApi {

    /**
     * Ручка, которая получает информацию о всех персонажах с сервера.
     *
     * @return Список персонажей в Single {@link Single} обёртке.
     */
    @GET(CHARACTERS_URL)
    Single<ListCharacterResponse> getAllCharacters();

    /**
     * Ручка, которая получает информацию о персонаже по id с сервера.
     *
     * @param characterId - id персонажа.
     * @return персонаж в Single {@link Single} обёртке.
     */
    @GET(CHARACTERS_URL + "{id}")
    Single<CharacterResponse> getCharacterById(@Path("id") int characterId);
}