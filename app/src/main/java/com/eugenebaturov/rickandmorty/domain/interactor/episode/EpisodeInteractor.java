package com.eugenebaturov.rickandmorty.domain.interactor.episode;

import com.eugenebaturov.rickandmorty.data.entity.EpisodeRequest;
import com.eugenebaturov.rickandmorty.data.repository.episode.EpisodeRepository;
import com.eugenebaturov.rickandmorty.domain.entity.Episode;

import java.io.IOException;
import java.util.List;

/**
 * Обрабатывает информацию об эпизодах из класса {@link EpisodeRequest},
 * которые приходят из репозитория {@link EpisodeRepository}.
 */
public interface EpisodeInteractor {

    /**
     * Получает обработанный список эпизодов из репозитория
     *
     * @return - список эпизодов.
     */
    List<Episode> parseEpisodesFromRepository();

    /**
     * Получает обработанный эпизод по id из репозитория
     *
     * @param episodeId - id эпизода.
     * @return эпизод с конкретным id.
     */
    Episode parseEpisodeByIdFromRepository(int episodeId);
}
