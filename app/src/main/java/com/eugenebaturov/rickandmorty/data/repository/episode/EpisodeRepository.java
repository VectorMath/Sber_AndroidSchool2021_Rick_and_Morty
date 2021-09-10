package com.eugenebaturov.rickandmorty.data.repository.episode;

import com.eugenebaturov.rickandmorty.data.api.EpisodeApi;
import com.eugenebaturov.rickandmorty.models.data.EpisodeResponse;
import com.eugenebaturov.rickandmorty.models.data.list.ListEpisodeResponse;
import com.eugenebaturov.rickandmorty.models.domain.Episode;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

/**
 * Интерфейс, методы которого получают данные с сервера с помощью {@link EpisodeApi}.
 */
public interface EpisodeRepository {

    /**
     * Получает данные о всех эпизодах с сервера.
     *
     * @return Список эпизодов в {@link Single} обёртке.
     */
    Single<List<Episode>> getEpisodesFromServer();

    /**
     * Получает данные об эпизоде с сервера.
     *
     * @param episodeId id эпизода.
     * @return Эпизод в {@link Single} обёртке.
     */
    Single<Episode> getEpisodeFromServer(final int episodeId);
}
