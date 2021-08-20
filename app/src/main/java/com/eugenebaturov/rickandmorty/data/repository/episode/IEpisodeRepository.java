package com.eugenebaturov.rickandmorty.data.repository.episode;

import com.eugenebaturov.rickandmorty.data.api.EpisodeApi;
import com.eugenebaturov.rickandmorty.domain.entity.Episode;

import java.util.List;

import retrofit2.Call;

/**
 * Интерфейс, методы которого "дёргают" ручки в {@link EpisodeApi}.
 */
public interface IEpisodeRepository {

    /**
     * Метод, который дергает ручку getAllEpisodes.
     *
     * @return список эпизодов в Call {@link Call} обёртке.
     */
    Call<List<Episode>> getAllEpisodes();

    /**
     * Метод, который дергает ручку getEpisodeById.
     *
     * @param episodeId - id эпизода.
     * @return эпизод в Call {@link Call} обёртке.
     */
    Call<Episode> getEpisodeById(int episodeId);
}
