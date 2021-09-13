package com.eugenebaturov.rickandmorty.domain.interactor.episode;

import androidx.annotation.NonNull;

import com.eugenebaturov.rickandmorty.data.repository.episode.EpisodeRepository;
import com.eugenebaturov.rickandmorty.models.domain.Episode;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

/**
 * Реализация {@link EpisodeInteractor}
 */
public final class EpisodeInteractorImpl implements EpisodeInteractor {

    @NonNull
    private final EpisodeRepository mEpisodeRepository;

    /**
     * Конструктор класса
     *
     * @param episodeRepository экземпляр репозитория {@link EpisodeRepository}
     */
    public EpisodeInteractorImpl(@NonNull final EpisodeRepository episodeRepository) {
        mEpisodeRepository = episodeRepository;
    }

    @Override
    public @NonNull Single<List<Episode>> getEpisodes() {
        return mEpisodeRepository.getEpisodes();
    }

    @Override
    public @NonNull Single<List<Episode>> getEpisodes(@NonNull String query) {
        return mEpisodeRepository.getEpisodes(query);
    }

    @Override
    public @NonNull Single<Episode> getEpisodeById(final int episodeId) {
        return mEpisodeRepository.getEpisodeById(episodeId);
    }
}
