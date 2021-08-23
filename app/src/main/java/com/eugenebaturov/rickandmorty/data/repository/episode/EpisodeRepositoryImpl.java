package com.eugenebaturov.rickandmorty.data.repository.episode;

import com.eugenebaturov.rickandmorty.data.api.EpisodeApi;
import com.eugenebaturov.rickandmorty.models.data.EpisodeResponse;
import com.eugenebaturov.rickandmorty.models.domain.Episode;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.core.Single;

/**
 * Класс-репозиторий, который является реализацией интерфейса {@link EpisodeRepository}.
 */
public class EpisodeRepositoryImpl implements EpisodeRepository {

    private final EpisodeApi mEpisodeApi;

    /**
     * Конструктор класса, в который мы передаёт экземпляр Retrofit, чтобы была
     * возможность использовать публичные методы данного класса.
     *
     * @param episodeApi - экземпляр Ретрофита, нужен, чтобы проинициализировать mEpisodeApi.
     */
    public EpisodeRepositoryImpl(EpisodeApi episodeApi) {
        mEpisodeApi = episodeApi;
    }

    @Override
    public Single<List<Episode>> getAllEpisodes() {

        return mEpisodeApi.getAllEpisodes().map(response -> {
            List<Episode> episodes = new ArrayList<>();

            for (EpisodeResponse episode : response.getEpisodes()) {
                episodes.add(new Episode(episode));
            }

            return episodes;
        });
    }

    @Override
    public Single<Episode> getEpisodeById(int episodeId) {
        return mEpisodeApi.getEpisodeById(episodeId).map(Episode::new);
    }
}