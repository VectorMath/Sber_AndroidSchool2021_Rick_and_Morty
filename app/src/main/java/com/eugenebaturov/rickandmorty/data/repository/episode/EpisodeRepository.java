package com.eugenebaturov.rickandmorty.data.repository.episode;

import com.eugenebaturov.rickandmorty.data.api.EpisodeApi;
import com.eugenebaturov.rickandmorty.domain.entity.Episode;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;

/**
 * Класс-репозиторий, который является реализацией интерфейса {@link IEpisodeRepository}.
 */
public class EpisodeRepository implements IEpisodeRepository {

    private final EpisodeApi mEpisodeApi;

    /**
     * Конструктор класса, в который мы передаёт экземпляр Retrofit, чтобы была
     * возможность использовать публичные методы данного класса.
     *
     * @param retrofit - экземпляр Ретрофита, нужен, чтобы проинициализировать mEpisodeApi.
     */
    public EpisodeRepository(Retrofit retrofit) {
        mEpisodeApi = retrofit.create(EpisodeApi.class);
    }

    @Override
    public Call<List<Episode>> getAllEpisodes() {
        return mEpisodeApi.getAllEpisodes();
    }

    @Override
    public Call<Episode> getEpisodeById(int episodeId) {
        return mEpisodeApi.getEpisodeById(episodeId);
    }
}