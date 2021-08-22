package com.eugenebaturov.rickandmorty.domain.interactor.character;

import com.eugenebaturov.rickandmorty.data.entity.CharacterRequest;
import com.eugenebaturov.rickandmorty.data.repository.character.CharacterRepository;

import java.io.IOException;
import java.util.List;

/**
 * Обрабатывает информацию о персонаже {@link CharacterRequest},
 * который приходит из репозитория {@link CharacterRepository}.
 */
public interface CharacterInteractor {

    /**
     * Получает список персонажей из репозитория без Call обёртки
     *
     * @return - список персонажей.
     * @throws IOException экзепшен ввода-вывода.
     */
    List<CharacterRequest> getCharactersFromRepository() throws IOException;

    /**
     * Получает персонажа из репозитория без Call обёртки
     *
     * @param characterId - id персонажа.
     * @return - персонаж с конкретным id.
     * @throws IOException экзепшен ввода-вывода.
     */
    CharacterRequest getCharacterByIdFromRepository(int characterId) throws IOException;
}
