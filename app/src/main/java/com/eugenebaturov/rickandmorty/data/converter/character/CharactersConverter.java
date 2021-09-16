package com.eugenebaturov.rickandmorty.data.converter.character;

import androidx.annotation.NonNull;

import com.eugenebaturov.rickandmorty.data.converter.Converter;
import com.eugenebaturov.rickandmorty.data.converter.Taker;
import com.eugenebaturov.rickandmorty.models.data.CharacterResponse;
import com.eugenebaturov.rickandmorty.models.data.list.ListCharacterResponse;
import com.eugenebaturov.rickandmorty.models.domain.Character;

import java.util.ArrayList;
import java.util.List;

/**
 * Реализация {@link Converter}.
 * В качестве входящих данных принимает {@link ListCharacterResponse}.
 * В качестве выходящих данных возвращает список {@link Character}.
 */
public final class CharactersConverter
        implements Converter<ListCharacterResponse, List<Character>> {

    @NonNull
    @Override
    public List<Character> convert(@NonNull final ListCharacterResponse from) {
        final List<Character> characters = new ArrayList<>();

        for (CharacterResponse response : from.getCharacters()) {
            final Character character = new Character(
                    response.getId(),
                    response.getName(),
                    response.getStatus(),
                    Taker.getCharacterImageStatusResource(response.getStatus()),
                    response.getSpecies(),
                    response.getType(),
                    response.getGender(),
                    response.getImage(),
                    response.getOrigin(),
                    Taker.getLocationId(response.getOrigin().getUrl()),
                    response.getCurrentLocation(),
                    Taker.getLocationId(response.getCurrentLocation().getUrl()),
                    response.getEpisodesUrl()
            );
            characters.add(character);
        }

        return characters;
    }
}
