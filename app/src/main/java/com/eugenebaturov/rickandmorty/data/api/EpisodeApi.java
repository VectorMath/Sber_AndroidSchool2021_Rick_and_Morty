package com.eugenebaturov.rickandmorty.data.api;

import com.eugenebaturov.rickandmorty.models.data.EpisodeResponse;
import com.eugenebaturov.rickandmorty.models.data.list.ListEpisodeResponse;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

import static com.eugenebaturov.rickandmorty.data.api.RickAndMortyURL.EPISODES_URL;

/**
 * API которое позволяет получить информацию об эпизодах с сервера.
 */
public interface EpisodeApi {

    /**
     * Получить информацию о всех эпизодах с сервера.
     *
     * @return Список данных об эпизодах в {@link Single} обёртке.
     */
    @GET(EPISODES_URL)
    Single<ListEpisodeResponse> getAllEpisodes();

    /**
     * Получить информацию о всех эпизодах с сервера, которые удоволетворяют строке запроса.
     *
     * @param queryName строка запроса.
     * @return Список данных об эпизодах в {@link Single} обёртке.
     */
    @GET(EPISODES_URL)
    Single<ListEpisodeResponse> getSearchedEpisodes(@Query("name") String queryName);

    /**
     * Получить информацию об эпизоде с конкретным id.
     *
     * @param episodeId id эпизода.
     * @return Данные об эпизоде в {@link Single} обёртке.
     */
    @GET(EPISODES_URL + "{id}")
    Single<EpisodeResponse> getEpisodeById(@Path("id") int episodeId);
}