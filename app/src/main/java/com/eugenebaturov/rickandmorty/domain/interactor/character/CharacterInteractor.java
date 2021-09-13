package com.eugenebaturov.rickandmorty.domain.interactor.character;

import androidx.annotation.NonNull;

import com.eugenebaturov.rickandmorty.models.domain.Character;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

/**
 * Интерактор персонажей.
 */
public interface CharacterInteractor {

    /**
     * Получает список персонажей.
     *
     * @return Список персонажей [{@link List}<{@link Character}>] в {@link Single} обёртке.
     */
    @NonNull
    Single<List<Character>> getCharacters();

    /**
     * Получает список персонажей по заданному запросу.
     *
     * @param query строка запроса
     * @return Список персонажей [{@link List}<{@link Character}>] в {@link Single} обёртке.
     */
    @NonNull
    Single<List<Character>> getCharacters(@NonNull final String query);

    /**
     * Получает персонажа с конкретным id.
     *
     * @param characterId id персонажа.
     * @return Персонаж [{@link Character}] в {@link Single} обёртке.
     */
    @NonNull
    Single<Character> getCharacterById(final int characterId);
}
