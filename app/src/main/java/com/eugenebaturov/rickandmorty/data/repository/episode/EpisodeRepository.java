package com.eugenebaturov.rickandmorty.data.repository.episode;

import com.eugenebaturov.rickandmorty.data.api.EpisodeApi;
import com.eugenebaturov.rickandmorty.models.data.EpisodeResponse;
import com.eugenebaturov.rickandmorty.models.data.list.ListEpisodeResponse;
import com.eugenebaturov.rickandmorty.models.domain.Episode;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

/**
 * Интерфейс, методы которого получают данные с сервера с помощью {@link EpisodeApi}
 * в виде {@link EpisodeResponse}, а после форматируют это в {@link Episode}
 */
public interface EpisodeRepository {

    /**
     * Получает данные о всех эпизодах с сервера в виде {@link ListEpisodeResponse}, а после
     * форматирует их в {@link List}<{@link Episode}>.
     *
     * @return Список эпизодов в {@link Single} обёртке.
     */
    Single<List<Episode>> getEpisodesFromServer();

    /**
     * Получает данные об эпизоде с сервера в виде {@link EpisodeResponse}, а после
     * форматирует их в {@link Episode}.
     *
     * @param episodeId id эпизода.
     * @return Эпизод в {@link Single} обёртке.
     */
    Single<Episode> getEpisodeFromServer(int episodeId);
}
