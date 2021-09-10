package com.eugenebaturov.rickandmorty.domain.interactor.episode;

import androidx.annotation.NonNull;

import com.eugenebaturov.rickandmorty.data.repository.episode.EpisodeRepository;
import com.eugenebaturov.rickandmorty.models.domain.Episode;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

/**
 * Реализация интерфейса {@link EpisodeInteractor}
 */
public final class EpisodeInteractorImpl implements EpisodeInteractor {

    @NonNull
    private final EpisodeRepository mRepository;

    /**
     * Конструктор класса
     *
     * @param repository экземпляр репозитория {@link EpisodeRepository}
     */
    public EpisodeInteractorImpl(@NonNull final EpisodeRepository repository) {
        mRepository = repository;
    }

    @Override
    public Single<List<Episode>> getEpisodesFromRepository() {
        return mRepository.getEpisodesFromServer();
    }

    @Override
    public Single<Episode> getEpisodeFromRepository(final int episodeId) {
        return mRepository.getEpisodeFromServer(episodeId);
    }
}
