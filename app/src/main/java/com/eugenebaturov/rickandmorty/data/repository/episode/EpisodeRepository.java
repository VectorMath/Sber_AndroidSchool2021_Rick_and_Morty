package com.eugenebaturov.rickandmorty.data.repository.episode;

import androidx.annotation.NonNull;

import com.eugenebaturov.rickandmorty.models.domain.Episode;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

/**
 * Репозиторий для получения эпизодов.
 */
public interface EpisodeRepository {

    /**
     * Получает данные о всех эпизодах.
     *
     * @return Список эпизодов в {@link Single} обёртке.
     */
    @NonNull
    Single<List<Episode>> getEpisodes();

    /**
     * Получает данные об эпизодах, которые удоволетворяют строке запроса.
     *
     * @param query строка запроса.
     * @return Список эпизодов в {@link Single} обёртке.
     */
    @NonNull
    Single<List<Episode>> getEpisodes(@NonNull final String query);

    /**
     * Получает данные об эпизоде с сервера.
     *
     * @param episodeId id эпизода.
     * @return Эпизод в {@link Single} обёртке.
     */
    @NonNull
    Single<Episode> getEpisodeById(final int episodeId);
}
