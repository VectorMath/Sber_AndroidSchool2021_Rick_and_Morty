package com.eugenebaturov.rickandmorty.data.converter.episode;

import androidx.annotation.NonNull;

import com.eugenebaturov.rickandmorty.data.converter.Converter;
import com.eugenebaturov.rickandmorty.models.data.EpisodeResponse;
import com.eugenebaturov.rickandmorty.models.data.list.ListEpisodeResponse;
import com.eugenebaturov.rickandmorty.models.domain.Episode;

import java.util.ArrayList;
import java.util.List;

/**
 * Реализация {@link Converter}.
 * В качестве входящих данных принимает {@link ListEpisodeResponse}.
 * В качестве выходящих данных возвращает список {@link Episode}.
 */
public final class EpisodesConverter implements Converter<ListEpisodeResponse, List<Episode>> {
    @Override
    @NonNull
    public List<Episode> convert(@NonNull final ListEpisodeResponse from) {
        final List<Episode> episodes = new ArrayList<>();

        for (EpisodeResponse response : from.getEpisodes()) {
            final Episode episode = new Episode(
                    response.getId(),
                    response.getTitle(),
                    response.getAirDate(),
                    response.getEpisodeNumber(),
                    response.getCharacters()
            );

            episodes.add(episode);
        }

        return episodes;
    }
}
