package com.eugenebaturov.rickandmorty.domain.interactor.character;

import com.eugenebaturov.rickandmorty.data.repository.character.CharacterRepository;
import com.eugenebaturov.rickandmorty.models.domain.Character;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

/**
 * Получает информацию из {@link CharacterRepository}, чтобы после передать во view-слой.
 */
public interface CharacterInteractor {

    /**
     * Получает список персонажей.
     *
     * @return Список персонажей [{@link List}<{@link Character}>] в {@link Single} обёртке.
     */
    Single<List<Character>> getCharactersFromRepository();

    /**
     * Получает персонажа с конкретным id.
     *
     * @param characterId id персонажа.
     * @return Персонаж [{@link Character}] в {@link Single} обёртке.
     */
    Single<Character> getCharacterFromRepository(int characterId);
}
