package com.eugenebaturov.rickandmorty.data.converter.character;

import androidx.annotation.NonNull;

import com.eugenebaturov.rickandmorty.data.converter.Converter;
import com.eugenebaturov.rickandmorty.data.converter.Taker;
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
                Taker.getCharacterImageStatusResource(from.getStatus()),
                from.getSpecies(),
                from.getType(),
                from.getGender(),
                from.getImage(),
                from.getOrigin(),
                Taker.getLocationId(from.getOrigin().getUrl()),
                from.getCurrentLocation(),
                Taker.getLocationId(from.getCurrentLocation().getUrl()),
                from.getEpisodesUrl());
    }
}
