package com.eugenebaturov.rickandmorty.data.repository.episode;

import androidx.annotation.NonNull;

import com.eugenebaturov.rickandmorty.data.api.EpisodeApi;
import com.eugenebaturov.rickandmorty.data.utils.Converter;
import com.eugenebaturov.rickandmorty.models.domain.Episode;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import retrofit2.Retrofit;

/**
 * Класс-репозиторий, который является реализацией интерфейса {@link EpisodeRepository}.
 */
public final class EpisodeRepositoryImpl implements EpisodeRepository {

    @NonNull
    private final EpisodeApi mEpisodeApi;

    /**
     * Конструктор класса, в который мы передаём {@link EpisodeApi}, чтобы была
     * возможность получить данные с сервера.
     *
     * @param episodeApi экземпляр {@link EpisodeApi},
     *                   для его создания требуется {@link Retrofit}.
     */
    public EpisodeRepositoryImpl(@NonNull final EpisodeApi episodeApi) {
        mEpisodeApi = episodeApi;
    }

    @Override
    public Single<List<Episode>> getEpisodesFromServer() {

        return mEpisodeApi.getAllEpisodes().map(Converter::convertEpisodes);
    }

    @Override
    public Single<List<Episode>> getSearchedEpisodesFromServer(String searchName) {
        return mEpisodeApi.getSearchedEpisodes(searchName).map(Converter::convertEpisodes);
    }

    @Override
    public Single<Episode> getEpisodeFromServer(final int episodeId) {
        return mEpisodeApi.getEpisodeById(episodeId).map(Converter::convertEpisode);
    }
}