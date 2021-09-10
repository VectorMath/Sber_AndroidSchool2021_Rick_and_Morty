package com.eugenebaturov.rickandmorty.data.repository.character;

import androidx.annotation.NonNull;

import com.eugenebaturov.rickandmorty.data.api.CharacterApi;
import com.eugenebaturov.rickandmorty.data.utils.Converter;
import com.eugenebaturov.rickandmorty.models.domain.Character;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

/**
 * Класс-репозиторий, который является реализацией {@link CharacterRepository}.
 */
public final class CharacterRepositoryImpl implements CharacterRepository {

    @NonNull
    private final CharacterApi mCharacterApi;

    /**
     * Конструктор класса, в который мы передаём {@link CharacterApi}, чтобы была
     * возможность получить данные с сервера.
     *
     * @param characterApi экземпляр {@link CharacterApi}.
     */
    public CharacterRepositoryImpl(@NonNull final CharacterApi characterApi) {
        mCharacterApi = characterApi;
    }

    @Override
    public Single<List<Character>> getCharactersFromServer() {
        return mCharacterApi.getAllCharacters().map(Converter::convertCharacters);
    }

    @Override
    public Single<Character> getCharacterFromServer(final int characterId) {
        return mCharacterApi.getCharacterById(characterId).map(Converter::convertCharacter);
    }
}