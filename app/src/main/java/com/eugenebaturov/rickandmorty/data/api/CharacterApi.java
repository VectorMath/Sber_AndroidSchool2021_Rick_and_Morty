package com.eugenebaturov.rickandmorty.data.api;

import com.eugenebaturov.rickandmorty.models.data.CharacterResponse;
import com.eugenebaturov.rickandmorty.models.data.list.ListCharacterResponse;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

import static com.eugenebaturov.rickandmorty.data.api.RickAndMortyURL.CHARACTERS_URL;

/**
 * API которое позволяет получить информацию о персонажах с сервера
 */
public interface CharacterApi {

    /**
     * Получить информацию о всех персонажах с сервера
     *
     * @return Список данных о персонажах в {@link Single} обёртке
     */
    @GET(CHARACTERS_URL)
    Single<ListCharacterResponse> getCharacters();

    /**
     * Получить информацию о всех персонажах с сервера, которые удоволетворяют строке запроса.
     *
     * @param queryName строка запроса.
     * @return Список данных о персонажах в {@link Single} обёртке
     */
    @GET(CHARACTERS_URL)
    Single<ListCharacterResponse> getCharacters(@Query("name") String queryName);

    /**
     * Получить информацию о персонаже с конкретным id.
     *
     * @param characterId id персонажа
     * @return Данные о персонаже в {@link Single} обёртке
     */
    @GET(CHARACTERS_URL + "{id}")
    Single<CharacterResponse> getCharacterById(@Path("id") int characterId);
}