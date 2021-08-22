package com.eugenebaturov.rickandmorty.domain.interactor.episode;

import com.eugenebaturov.rickandmorty.data.entity.EpisodeRequest;
import com.eugenebaturov.rickandmorty.data.repository.episode.EpisodeRepository;

import java.io.IOException;
import java.util.List;

public class EpisodeInteractorImpl implements EpisodeInteractor {

    private final EpisodeRepository mRepository;

    public EpisodeInteractorImpl(EpisodeRepository repository) {
        mRepository = repository;
    }

    @Override
    public List<EpisodeRequest> getAllEpisodesFromRepository() throws IOException {
        return mRepository.getAllEpisodes().execute().body().getEpisodes();
    }

    @Override
    public EpisodeRequest getEpisodeByIdFromRepository(int episodeId) throws IOException {
        return mRepository.getEpisodeById(episodeId).execute().body();
    }
}
