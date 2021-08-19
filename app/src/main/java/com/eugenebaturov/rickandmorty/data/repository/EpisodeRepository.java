package com.eugenebaturov.rickandmorty.data.repository;

import com.eugenebaturov.rickandmorty.data.api.EpisodeApi;
import com.eugenebaturov.rickandmorty.domain.entity.Episode;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;

public class EpisodeRepository {

    private final EpisodeApi mEpisodeApi;

    public EpisodeRepository(Retrofit retrofit) {
        mEpisodeApi = retrofit.create(EpisodeApi.class);
    }

    public Call<List<Episode>> getAllEpisodes() {
        return mEpisodeApi.getAllEpisodes();
    }

    public Call<Episode> getEpisodeById(int episodeId) {
        return mEpisodeApi.getEpisodeById(episodeId);
    }
}