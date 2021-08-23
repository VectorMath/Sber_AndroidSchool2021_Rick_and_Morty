package com.eugenebaturov.rickandmorty.domain.interactor.episode;

import com.eugenebaturov.rickandmorty.models.data.EpisodeResponse;
import com.eugenebaturov.rickandmorty.data.repository.episode.EpisodeRepository;
import com.eugenebaturov.rickandmorty.models.domain.Episode;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

/**
 * Обрабатывает информацию об эпизодах из класса {@link EpisodeResponse},
 * которые приходят из репозитория {@link EpisodeRepository}.
 */
public interface EpisodeInteractor {

    /**
     * Получает обработанный список эпизодов из репозитория
     *
     * @return - список эпизодов.
     */
    Single<List<Episode>> parseEpisodesFromRepository();

    /**
     * Получает обработанный эпизод по id из репозитория
     *
     * @param episodeId - id эпизода.
     * @return эпизод с конкретным id.
     */
    Single<Episode> parseEpisodeByIdFromRepository(int episodeId);
}
