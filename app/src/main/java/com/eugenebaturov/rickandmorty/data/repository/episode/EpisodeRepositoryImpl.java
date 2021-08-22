package com.eugenebaturov.rickandmorty.data.repository.episode;

import com.eugenebaturov.rickandmorty.data.api.EpisodeApi;
import com.eugenebaturov.rickandmorty.data.entity.EpisodeRequest;
import com.eugenebaturov.rickandmorty.data.entity.list.ListEpisodeRequest;

import retrofit2.Call;
import retrofit2.Retrofit;

/**
 * Класс-репозиторий, который является реализацией интерфейса {@link EpisodeRepository}.
 */
public class EpisodeRepositoryImpl implements EpisodeRepository {

    private final EpisodeApi mEpisodeApi;

    /**
     * Конструктор класса, в который мы передаёт экземпляр Retrofit, чтобы была
     * возможность использовать публичные методы данного класса.
     *
     * @param retrofit - экземпляр Ретрофита, нужен, чтобы проинициализировать mEpisodeApi.
     */
    public EpisodeRepositoryImpl(Retrofit retrofit) {
        mEpisodeApi = retrofit.create(EpisodeApi.class);
    }

    @Override
    public Call<ListEpisodeRequest> getAllEpisodes() {
        return mEpisodeApi.getAllEpisodes();
    }

    @Override
    public Call<EpisodeRequest> getEpisodeById(int episodeId) {
        return mEpisodeApi.getEpisodeById(episodeId);
    }
}