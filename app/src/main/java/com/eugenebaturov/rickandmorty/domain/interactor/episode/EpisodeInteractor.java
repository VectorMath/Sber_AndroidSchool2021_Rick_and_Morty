package com.eugenebaturov.rickandmorty.domain.interactor.episode;

import com.eugenebaturov.rickandmorty.models.data.EpisodeRequest;
import com.eugenebaturov.rickandmorty.data.repository.episode.EpisodeRepository;
import com.eugenebaturov.rickandmorty.models.domain.Episode;

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
