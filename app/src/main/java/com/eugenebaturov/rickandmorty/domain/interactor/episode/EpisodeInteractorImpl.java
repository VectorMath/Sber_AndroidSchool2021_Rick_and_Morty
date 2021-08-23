package com.eugenebaturov.rickandmorty.domain.interactor.episode;

import com.eugenebaturov.rickandmorty.models.data.EpisodeResponse;
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
     * @param repository - экземпляр интрефейса-репозитория {@link EpisodeRepository}
     */
    public EpisodeInteractorImpl(EpisodeRepository repository) {
        mRepository = repository;
    }

    @Override
    public Single<List<Episode>> parseEpisodesFromRepository() {
        return mRepository.getAllEpisodes();
    }

    @Override
    public Single<Episode> parseEpisodeByIdFromRepository(int episodeId) {
        return mRepository.getEpisodeById(episodeId);
    }
}
