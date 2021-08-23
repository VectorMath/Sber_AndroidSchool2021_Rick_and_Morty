package com.eugenebaturov.rickandmorty.domain.interactor.character;

import com.eugenebaturov.rickandmorty.models.data.CharacterResponse;
import com.eugenebaturov.rickandmorty.data.repository.character.CharacterRepository;
import com.eugenebaturov.rickandmorty.models.domain.Character;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

/**
 * Обрабатывает информацию о персонаже {@link CharacterResponse},
 * который приходит из репозитория {@link CharacterRepository}.
 */
public interface CharacterInteractor {

    /**
     * Получает обработанный список персонажей из репозитория
     *
     * @return - список персонажей.
     */
    Single<List<Character>> parseCharactersFromRepository();

    /**
     * Получает обработанного персонажа из репозитория
     *
     * @param characterId - id персонажа.
     * @return - персонаж с конкретным id.
     */
    Single<Character> parseCharacterByIdFromRepository(int characterId);
}
