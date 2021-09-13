package com.eugenebaturov.rickandmorty.domain.interactor.episode;

import androidx.annotation.NonNull;

import com.eugenebaturov.rickandmorty.models.domain.Episode;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

/**
 * Интерактор эпизодов.
 */
public interface EpisodeInteractor {

    /**
     * Получает список эпизодов.
     *
     * @return Список эпизодов [{@link List}<{@link Episode}>] в {@link Single} обёртке.
     */
    @NonNull
    Single<List<Episode>> getEpisodes();

    /**
     * Получает список эпизодов по заданному запросу из репозитория.
     *
     * @param query строка запроса
     * @return Список эпизодов [{@link List}<{@link Episode}>] в {@link Single} обёртке.
     */
    @NonNull
    Single<List<Episode>> getEpisodes(@NonNull final String query);

    /**
     * Получает эпизод с конкретным id.
     *
     * @param episodeId id эпизода.
     * @return Эпизод [{@link Episode}] в {@link Single} обёртке.
     */
    @NonNull
    Single<Episode> getEpisodeById(final int episodeId);
}
