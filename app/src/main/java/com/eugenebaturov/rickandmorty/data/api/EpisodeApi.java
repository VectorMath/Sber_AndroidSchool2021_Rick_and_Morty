package com.eugenebaturov.rickandmorty.data.api;

import com.eugenebaturov.rickandmorty.models.data.EpisodeRequest;
import com.eugenebaturov.rickandmorty.models.data.list.ListEpisodeRequest;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

import static com.eugenebaturov.rickandmorty.data.api.RickAndMortyURL.EPISODES_URL;

/**
 * API которое позволяет получить информацию о эпизодах {@link EpisodeRequest} с сервера.
 */
public interface EpisodeApi {

    /**
     * Ручка, которая получает информацию о всех эпизодах с сервера.
     *
     * @return Список эпизодов в Single {@link Single} обёртке.
     */
    @GET(EPISODES_URL)
    Single<ListEpisodeRequest> getAllEpisodes();

    /**
     * Ручка, которая получает информацию о эпизоде по id с сервера.
     *
     * @param episodeId - id эпизода.
     * @return эпизод в Single {@link Single} обёртке.
     */
    @GET(EPISODES_URL + "{id}")
    Single<EpisodeRequest> getEpisodeById(@Path("id") int episodeId);
}