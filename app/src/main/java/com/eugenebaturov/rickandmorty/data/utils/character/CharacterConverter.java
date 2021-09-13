package com.eugenebaturov.rickandmorty.data.utils.character;

import androidx.annotation.NonNull;

import com.eugenebaturov.rickandmorty.data.utils.Converter;
import com.eugenebaturov.rickandmorty.models.data.CharacterResponse;
import com.eugenebaturov.rickandmorty.models.domain.Character;

/**
 * Реализация {@link Converter}.
 * В качестве входящих данных принимает {@link CharacterResponse}.
 * В качестве выходящих данных возвращает {@link Character}.
 */
public final class CharacterConverter implements Converter<CharacterResponse, Character> {

    @Override
    @NonNull
    public Character convert(@NonNull final CharacterResponse from) {
        return new Character(
                from.getId(),
                from.getName(),
                from.getStatus(),
                from.getSpecies(),
                from.getType(),
                from.getGender(),
                from.getImage(),
                from.getOrigin(),
                from.getCurrentLocation(),
                from.getEpisodesUrl());
    }
}
