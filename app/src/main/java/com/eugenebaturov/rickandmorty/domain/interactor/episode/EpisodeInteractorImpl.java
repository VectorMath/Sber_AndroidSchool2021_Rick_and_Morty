package com.eugenebaturov.rickandmorty.domain.interactor.episode;

import com.eugenebaturov.rickandmorty.data.entity.EpisodeRequest;
import com.eugenebaturov.rickandmorty.data.repository.episode.EpisodeRepository;
import com.eugenebaturov.rickandmorty.domain.entity.Episode;

import java.io.IOException;
import java.util.ArrayList;
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
    public List<Episode> parseEpisodesFromRepository() {
        List<EpisodeRequest> request = mRepository
                .getAllEpisodes().blockingGet().getEpisodes();
        List<Episode> episodes = new ArrayList<>();

        for (EpisodeRequest episode : request) {
            episodes.add(new Episode(episode));
        }
        return episodes;
    }

    @Override
    public Episode parseEpisodeByIdFromRepository(int episodeId) {
        EpisodeRequest request = mRepository.getEpisodeById(episodeId).blockingGet();
        return new Episode(request);
    }
}
