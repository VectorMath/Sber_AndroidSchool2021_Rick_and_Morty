package com.eugenebaturov.rickandmorty.domain.interactor.episode;

import com.eugenebaturov.rickandmorty.data.entity.EpisodeRequest;
import com.eugenebaturov.rickandmorty.data.repository.episode.EpisodeRepository;

import java.io.IOException;
import java.util.List;

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
    public List<EpisodeRequest> getAllEpisodesFromRepository() throws IOException {
        return mRepository.getAllEpisodes().blockingGet().getEpisodes();
    }

    @Override
    public EpisodeRequest getEpisodeByIdFromRepository(int episodeId) throws IOException {
        return mRepository.getEpisodeById(episodeId).blockingGet();
    }
}
