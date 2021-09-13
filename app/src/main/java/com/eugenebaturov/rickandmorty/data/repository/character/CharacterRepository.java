package com.eugenebaturov.rickandmorty.data.repository.character;

import androidx.annotation.NonNull;

import com.eugenebaturov.rickandmorty.models.domain.Character;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

/**
 * Репозиторий для получения персонажей.
 */
public interface CharacterRepository {

    /**
     * Получает данные о всех персонажах.
     *
     * @return Список персонажей в {@link Single} обёртке.
     */
    @NonNull
    Single<List<Character>> getCharacters();

    /**
     * Получает данные о персонажах, которые удоволетворяют строке запроса.
     *
     * @param query строка запроса.
     * @return Список персонажей в {@link Single} обёртке.
     */
    @NonNull
    Single<List<Character>> getCharacters(@NonNull final String query);

    /**
     * Получает данные о персонаже с конкретным id.
     *
     * @param characterId id персонажа.
     * @return Персонаж с данным id в {@link Single} обёртке.
     */
    @NonNull
    Single<Character> getCharacterById(final int characterId);
}
