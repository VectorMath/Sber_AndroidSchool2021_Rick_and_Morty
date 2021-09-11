package com.eugenebaturov.rickandmorty.domain.interactor.character;

import androidx.annotation.NonNull;

import com.eugenebaturov.rickandmorty.data.repository.character.CharacterRepository;
import com.eugenebaturov.rickandmorty.models.domain.Character;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

/**
 * Реализация интерфейса {@link CharacterInteractor}
 */
public final class CharacterInteractorImpl implements CharacterInteractor {

    @NonNull
    private final CharacterRepository mRepository;

    /**
     * Конструктор класса.
     *
     * @param repository экземпляр репозитория {@link CharacterRepository}
     */
    public CharacterInteractorImpl(@NonNull final CharacterRepository repository) {
        mRepository = repository;
    }

    @Override
    public Single<List<Character>> getCharactersFromRepository() {
        return mRepository.getCharactersFromServer();
    }

    @Override
    public Single<Character> getCharacterFromRepository(final int characterId) {
        return mRepository.getCharacterFromServer(characterId);
    }

    @Override
    public Single<List<Character>> getSearchedCharacterFromRepository(String searchName) {
        return mRepository.getSearchedCharacter(searchName);
    }
}
