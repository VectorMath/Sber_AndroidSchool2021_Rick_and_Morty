package com.eugenebaturov.rickandmorty.data.repository.character;

import com.eugenebaturov.rickandmorty.data.api.CharacterApi;
import com.eugenebaturov.rickandmorty.data.entity.CharacterRequest;
import com.eugenebaturov.rickandmorty.data.entity.list.ListCharacterRequest;

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
    Single<ListCharacterRequest> getAllCharacters();

    /**
     * Метод, который дергает ручку getCharacterById.
     *
     * @param characterId - id персонажа.
     * @return персонаж с данным id в Single {@link Single} обёртке.
     */
    Single<CharacterRequest> getCharacterById(int characterId);
}
