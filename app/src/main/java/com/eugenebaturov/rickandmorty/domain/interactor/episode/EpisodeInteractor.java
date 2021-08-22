package com.eugenebaturov.rickandmorty.domain.interactor.episode;

import com.eugenebaturov.rickandmorty.data.entity.EpisodeRequest;

import java.io.IOException;
import java.util.List;

public interface EpisodeInteractor {

    List<EpisodeRequest> getAllEpisodesFromRepository() throws IOException;

    EpisodeRequest getEpisodeByIdFromRepository(int episodeId) throws IOException;
}
