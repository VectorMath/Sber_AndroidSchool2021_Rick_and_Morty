package com.eugenebaturov.rickandmorty.data.repository.character;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.eugenebaturov.rickandmorty.data.api.CharacterApi;
import com.eugenebaturov.rickandmorty.models.data.CharacterResponse;
import com.eugenebaturov.rickandmorty.models.domain.Character;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.core.Single;
import retrofit2.Retrofit;

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
     * @param characterApi экземпляр {@link CharacterApi},
     *                     для его создания требуется {@link Retrofit}.
     */
    public CharacterRepositoryImpl(@NonNull final CharacterApi characterApi) {
        mCharacterApi = characterApi;
    }

    @Override
    public Single<List<Character>> getCharactersFromServer() {
        return mCharacterApi.getAllCharacters().map(response -> {
            List<Character> characters = new ArrayList<>();

            for (CharacterResponse character : response.getCharacters()) {
                characters.add(new Character(character));
            }

            return characters;
        });
    }

    @Override
    public Single<Character> getCharacterFromServer(final int characterId) {
        return mCharacterApi.getCharacterById(characterId).map(Character::new);
    }
}