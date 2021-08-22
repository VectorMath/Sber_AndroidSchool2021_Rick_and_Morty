package com.eugenebaturov.rickandmorty.domain.interactor.character;

import com.eugenebaturov.rickandmorty.models.data.CharacterRequest;
import com.eugenebaturov.rickandmorty.data.repository.character.CharacterRepository;
import com.eugenebaturov.rickandmorty.models.domain.Character;

import java.util.List;

/**
 * Обрабатывает информацию о персонаже {@link CharacterRequest},
 * который приходит из репозитория {@link CharacterRepository}.
 */
public interface CharacterInteractor {

    /**
     * Получает обработанный список персонажей из репозитория
     *
     * @return - список персонажей.
     */
    List<Character> parseCharactersFromRepository();

    /**
     * Получает обработанного персонажа из репозитория
     *
     * @param characterId - id персонажа.
     * @return - персонаж с конкретным id.
     */
    Character parseCharacterByIdFromRepository(int characterId);
}
