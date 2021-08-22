package com.eugenebaturov.rickandmorty.domain.interactor.episode;

import com.eugenebaturov.rickandmorty.data.entity.EpisodeRequest;
import com.eugenebaturov.rickandmorty.data.repository.episode.EpisodeRepository;

import java.io.IOException;
import java.util.List;

/**
 * Обрабатывает информацию об эпизодах из класса {@link EpisodeRequest},
 * которые приходят из репозитория {@link EpisodeRepository}.
 */
public interface EpisodeInteractor {

    /**
     * Получает список эпизодов из репозитория без Single обёртки.
     *
     * @return - список эпизодов.
     * @throws IOException экзепшен ввода-вывода.
     */
    List<EpisodeRequest> getAllEpisodesFromRepository() throws IOException;

    /**
     * Получает эпизод по id из репозитория без Single обёртки.
     *
     * @param episodeId - id эпизода.
     * @return эпизод с конкретным id.
     * @throws IOException экзепшен ввода-вывода.
     */
    EpisodeRequest getEpisodeByIdFromRepository(int episodeId) throws IOException;
}
