package com.eugenebaturov.rickandmorty.data.repository.episode;

import com.eugenebaturov.rickandmorty.data.api.EpisodeApi;
import com.eugenebaturov.rickandmorty.models.data.EpisodeResponse;
import com.eugenebaturov.rickandmorty.models.domain.Episode;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.core.Single;
import retrofit2.Retrofit;

/**
 * Класс-репозиторий, который является реализацией интерфейса {@link EpisodeRepository}.
 */
public class EpisodeRepositoryImpl implements EpisodeRepository {

    private final EpisodeApi mEpisodeApi;

    /**
     * Конструктор класса, в который мы передаём {@link EpisodeApi}, чтобы была
     * возможность получить данные с сервера.
     *
     * @param episodeApi экземпляр {@link EpisodeApi},
     *                   для его создания требуется {@link Retrofit}.
     */
    public EpisodeRepositoryImpl(EpisodeApi episodeApi) {
        mEpisodeApi = episodeApi;
    }

    @Override
    public Single<List<Episode>> getEpisodesFromServer() {

        return mEpisodeApi.getAllEpisodes().map(response -> {
            List<Episode> episodes = new ArrayList<>();

            for (EpisodeResponse episode : response.getEpisodes()) {
                episodes.add(new Episode(episode));
            }

            return episodes;
        });
    }

    @Override
    public Single<Episode> getEpisodeFromServer(int episodeId) {
        return mEpisodeApi.getEpisodeById(episodeId).map(Episode::new);
    }
}