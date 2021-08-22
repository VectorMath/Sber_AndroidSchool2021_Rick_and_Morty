package com.eugenebaturov.rickandmorty.domain.interactor.character;

import com.eugenebaturov.rickandmorty.data.repository.character.CharacterRepository;
import com.eugenebaturov.rickandmorty.data.entity.CharacterRequest;

import java.io.IOException;
import java.util.List;

/**
 * Реализация интерфейса {@link CharacterInteractor}
 */
public class CharacterInteractorImpl implements CharacterInteractor {

    private final CharacterRepository mRepository;

    /**
     * Конструктор класса.
     *
     * @param repository - экземпляр интерфейса-репозитория {@link CharacterRepository}
     */
    public CharacterInteractorImpl(CharacterRepository repository) {
        mRepository = repository;
    }

    @Override
    public List<CharacterRequest> getCharactersFromRepository() throws IOException {
        return mRepository.getAllCharacters().blockingGet().getCharacters();
    }

    @Override
    public CharacterRequest getCharacterByIdFromRepository(int characterId) {
        return mRepository.getCharacterById(characterId).blockingGet();
    }
}
