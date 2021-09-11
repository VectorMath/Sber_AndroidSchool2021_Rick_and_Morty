package com.eugenebaturov.rickandmorty.data.repository.character;

import com.eugenebaturov.rickandmorty.data.api.CharacterApi;
import com.eugenebaturov.rickandmorty.models.domain.Character;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

/**
 * Интерфейс, методы которого получают данные с сервера с помощью {@link CharacterApi}.
 */
public interface CharacterRepository {

    /**
     * Получает данные о всех персонажах с сервера.
     *
     * @return Список персонажей в {@link Single} обёртке.
     */
    Single<List<Character>> getCharactersFromServer();

    /**
     * Получает данные о персонаже с сервера.
     *
     * @param characterId id персонажа.
     * @return Персонаж с данным id в {@link Single} обёртке.
     */
    Single<Character> getCharacterFromServer(final int characterId);

    Single<List<Character>> getSearchedCharacter(final String searchName);
}
