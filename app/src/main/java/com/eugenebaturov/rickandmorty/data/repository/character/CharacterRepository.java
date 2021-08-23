package com.eugenebaturov.rickandmorty.data.repository.character;

import com.eugenebaturov.rickandmorty.data.api.CharacterApi;
import com.eugenebaturov.rickandmorty.models.domain.Character;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

/**
 * Интерфейс, методы которого "дёргают" ручки в {@link CharacterApi}.
 */
public interface CharacterRepository {

    /**
     * Метод, который дергает ручку getAllCharacters.
     *
     * @return список персонажей в Single {@link Single} обёртке.
     */
    Single<List<Character>> getAllCharacters();

    /**
     * Метод, который дергает ручку getCharacterById.
     *
     * @param characterId - id персонажа.
     * @return персонаж с данным id в Single {@link Single} обёртке.
     */
    Single<Character> getCharacterById(int characterId);
}
