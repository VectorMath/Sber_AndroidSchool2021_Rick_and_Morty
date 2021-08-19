package com.eugenebaturov.rickandmorty.data.api;

import com.eugenebaturov.rickandmorty.domain.entity.Episode;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import static com.eugenebaturov.rickandmorty.data.api.RickAndMortyURL.EPISODES_URL;

public interface EpisodeApi {

    @GET(EPISODES_URL)
    Call<List<Episode>> getAllEpisodes();

    @GET(EPISODES_URL + "{id}")
    Call<Episode> getEpisodeById(@Path("id") int episodeId);
}