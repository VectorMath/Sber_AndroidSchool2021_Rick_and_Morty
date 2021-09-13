package com.eugenebaturov.rickandmorty.data.repository.episode;

import androidx.annotation.NonNull;

import com.eugenebaturov.rickandmorty.data.api.EpisodeApi;
import com.eugenebaturov.rickandmorty.data.utils.Converter;
import com.eugenebaturov.rickandmorty.data.utils.episode.EpisodeConverter;
import com.eugenebaturov.rickandmorty.data.utils.episode.EpisodesConverter;
import com.eugenebaturov.rickandmorty.models.data.EpisodeResponse;
import com.eugenebaturov.rickandmorty.models.data.list.ListEpisodeResponse;
import com.eugenebaturov.rickandmorty.models.domain.Episode;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

/**
 * Реализация {@link EpisodeRepository}.
 */
public final class EpisodeRepositoryImpl implements EpisodeRepository {

    @NonNull
    private final EpisodeApi mEpisodeApi;

    /**
     * Конструктор класса.
     *
     * @param episodeApi экземпляр {@link EpisodeApi}.
     */
    public EpisodeRepositoryImpl(@NonNull final EpisodeApi episodeApi) {
        mEpisodeApi = episodeApi;
    }

    @Override
    public @NonNull
    Single<List<Episode>> getEpisodes() {
        final Converter<ListEpisodeResponse, List<Episode>> mConverter =
                new EpisodesConverter();
        return mEpisodeApi.getAllEpisodes().map(mConverter::convert);
    }

    @Override
    public @NonNull
    Single<List<Episode>> getEpisodes(@NonNull String query) {
        final Converter<ListEpisodeResponse, List<Episode>> mConverter =
                new EpisodesConverter();
        return mEpisodeApi.getSearchedEpisodes(query).map(mConverter::convert);
    }

    @Override
    public @NonNull
    Single<Episode> getEpisodeById(final int episodeId) {
        final Converter<EpisodeResponse, Episode> mConverter =
                new EpisodeConverter();
        return mEpisodeApi.getEpisodeById(episodeId).map(mConverter::convert);
    }
}