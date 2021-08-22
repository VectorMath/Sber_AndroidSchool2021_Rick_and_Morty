package com.eugenebaturov.rickandmorty.data.api;

import com.eugenebaturov.rickandmorty.data.entity.EpisodeRequest;
import com.eugenebaturov.rickandmorty.data.entity.list.ListEpisodeRequest;

import java.util.List;

import retrofit2.Call;
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
     * @return Список эпизодов в Call {@link Call} обёртке.
     */
    @GET(EPISODES_URL)
    Call<ListEpisodeRequest> getAllEpisodes();

    /**
     * Ручка, которая получает информацию о эпизоде по id с сервера.
     *
     * @param episodeId - id эпизода.
     * @return эпизод в Call {@link Call} обёртке.
     */
    @GET(EPISODES_URL + "{id}")
    Call<EpisodeRequest> getEpisodeById(@Path("id") int episodeId);
}