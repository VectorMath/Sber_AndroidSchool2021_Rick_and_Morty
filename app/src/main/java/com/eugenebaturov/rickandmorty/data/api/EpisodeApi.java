package com.eugenebaturov.rickandmorty.data.api;

import com.eugenebaturov.rickandmorty.models.data.EpisodeResponse;
import com.eugenebaturov.rickandmorty.models.data.list.ListEpisodeResponse;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

import static com.eugenebaturov.rickandmorty.data.api.RickAndMortyURL.EPISODES_URL;

/**
 * API которое позволяет получить информацию о {@link EpisodeResponse} с сервера.
 */
public interface EpisodeApi {

    /**
     * Ручка, которая получает информацию о всех эпизодах с сервера.
     *
     * @return Список данных об эпизодах в {@link Single} обёртке.
     */
    @GET(EPISODES_URL)
    Single<ListEpisodeResponse> getAllEpisodes();

    /**
     * Ручка, которая получает информацию о эпизоде по id с сервера.
     *
     * @param episodeId id эпизода.
     * @return Данные об эпизоде в {@link Single} обёртке.
     */
    @GET(EPISODES_URL + "{id}")
    Single<EpisodeResponse> getEpisodeById(@Path("id") final int episodeId);
}