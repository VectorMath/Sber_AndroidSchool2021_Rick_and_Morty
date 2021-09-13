package com.eugenebaturov.rickandmorty.domain.interactor.character;

import androidx.annotation.NonNull;

import com.eugenebaturov.rickandmorty.data.repository.character.CharacterRepository;
import com.eugenebaturov.rickandmorty.models.domain.Character;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

/**
 * Реализация {@link CharacterInteractor}
 */
public final class CharacterInteractorImpl implements CharacterInteractor {

    @NonNull
    private final CharacterRepository mCharacterRepository;

    /**
     * Конструктор класса.
     *
     * @param characterRepository экземпляр репозитория {@link CharacterRepository}
     */
    public CharacterInteractorImpl(@NonNull final CharacterRepository characterRepository) {
        mCharacterRepository = characterRepository;
    }

    @NonNull
    @Override
    public Single<List<Character>> getCharacters() {
        return mCharacterRepository.getCharacters();
    }

    @Override
    public @NonNull Single<List<Character>> getCharacters(@NonNull String query) {
        return mCharacterRepository.getCharacters(query);
    }

    @Override
    public @NonNull Single<Character> getCharacterById(final int characterId) {
        return mCharacterRepository.getCharacterById(characterId);
    }
}
