package com.eugenebaturov.rickandmorty.data.repository.episode;

import com.eugenebaturov.rickandmorty.data.api.EpisodeApi;
import com.eugenebaturov.rickandmorty.data.entity.EpisodeRequest;
import com.eugenebaturov.rickandmorty.data.entity.list.ListEpisodeRequest;

import java.util.List;

import retrofit2.Call;

/**
 * Интерфейс, методы которого "дёргают" ручки в {@link EpisodeApi}.
 */
public interface EpisodeRepository {

    /**
     * Метод, который дергает ручку getAllEpisodes.
     *
     * @return список эпизодов в Call {@link Call} обёртке.
     */
    Call<ListEpisodeRequest> getAllEpisodes();

    /**
     * Метод, который дергает ручку getEpisodeById.
     *
     * @param episodeId - id эпизода.
     * @return эпизод в Call {@link Call} обёртке.
     */
    Call<EpisodeRequest> getEpisodeById(int episodeId);
}
