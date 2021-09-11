package com.eugenebaturov.rickandmorty.domain.interactor.episode;

import com.eugenebaturov.rickandmorty.data.repository.episode.EpisodeRepository;
import com.eugenebaturov.rickandmorty.models.domain.Episode;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

/**
 * Получает информацию из {@link EpisodeRepository}, чтобы после передать во view-слой.
 */
public interface EpisodeInteractor {

    /**
     * Получает список эпизодов.
     *
     * @return Список эпизодов [{@link List}<{@link Episode}>] в {@link Single} обёртке.
     */
    Single<List<Episode>> getEpisodesFromRepository();

    /**
     * Получает список эпизодов по заданному запросу из репозитория.
     *
     * @param query строка запроса
     * @return Список эпизодов [{@link List}<{@link Episode}>] в {@link Single} обёртке.
     */
    Single<List<Episode>> getSearchedEpisodesFromRepository(final String query);

    /**
     * Получает эпизод с конкретным id.
     *
     * @param episodeId id эпизода.
     * @return Эпизод [{@link Episode}] в {@link Single} обёртке.
     */
    Single<Episode> getEpisodeFromRepository(final int episodeId);
}
