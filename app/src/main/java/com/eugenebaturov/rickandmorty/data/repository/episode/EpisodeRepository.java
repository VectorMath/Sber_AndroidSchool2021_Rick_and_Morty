package com.eugenebaturov.rickandmorty.data.repository.episode;

import com.eugenebaturov.rickandmorty.data.api.EpisodeApi;
import com.eugenebaturov.rickandmorty.models.domain.Episode;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

/**
 * Интерфейс, методы которого "дёргают" ручки в {@link EpisodeApi}.
 */
public interface EpisodeRepository {

    /**
     * Метод, который дергает ручку getAllEpisodes.
     *
     * @return список эпизодов в Single {@link Single} обёртке.
     */
    Single<List<Episode>> getAllEpisodes();

    /**
     * Метод, который дергает ручку getEpisodeById.
     *
     * @param episodeId - id эпизода.
     * @return эпизод в Single {@link Single} обёртке.
     */
    Single<Episode> getEpisodeById(int episodeId);
}
