package com.eugenebaturov.rickandmorty.domain.interactor.episode;

import com.eugenebaturov.rickandmorty.data.repository.episode.EpisodeRepository;
import com.eugenebaturov.rickandmorty.models.domain.Episode;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

/**
 * Реализация интерфейса {@link EpisodeInteractor}
 */
public class EpisodeInteractorImpl implements EpisodeInteractor {

    private final EpisodeRepository mRepository;

    /**
     * Конструктор класса
     *
     * @param repository экземпляр интрефейса-репозитория {@link EpisodeRepository}
     */
    public EpisodeInteractorImpl(EpisodeRepository repository) {
        mRepository = repository;
    }

    @Override
    public Single<List<Episode>> getEpisodesFromRepository() {
        return mRepository.getEpisodesFromServer();
    }

    @Override
    public Single<Episode> getEpisodeFromRepository(int episodeId) {
        return mRepository.getEpisodeFromServer(episodeId);
    }
}
