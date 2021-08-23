package com.eugenebaturov.rickandmorty.domain.interactor.character;

import com.eugenebaturov.rickandmorty.data.repository.character.CharacterRepository;
import com.eugenebaturov.rickandmorty.models.domain.Character;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

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
    public Single<List<Character>> parseCharactersFromRepository() {
        return mRepository.getCharactersFromServer();
    }

    @Override
    public Single<Character> parseCharacterByIdFromRepository(int characterId) {
        return mRepository.getCharacterFromServer(characterId);
    }
}
