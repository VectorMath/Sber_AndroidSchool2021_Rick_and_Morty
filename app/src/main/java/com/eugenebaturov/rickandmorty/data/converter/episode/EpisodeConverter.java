package com.eugenebaturov.rickandmorty.data.converter.episode;

import androidx.annotation.NonNull;

import com.eugenebaturov.rickandmorty.data.converter.Converter;
import com.eugenebaturov.rickandmorty.models.data.EpisodeResponse;
import com.eugenebaturov.rickandmorty.models.domain.Episode;

/**
 * Реализация {@link Converter}.
 * В качестве входящих данных принимает {@link EpisodeResponse}.
 * В качестве выходящих данных возвращает {@link Episode}.
 */
public final class EpisodeConverter implements Converter<EpisodeResponse, Episode> {
    @Override
    @NonNull
    public Episode convert(@NonNull final EpisodeResponse from) {
        return new Episode(
                from.getId(),
                from.getTitle(),
                from.getAirDate(),
                from.getEpisodeNumber(),
                from.getCharacters());
    }
}
