package com.eugenebaturov.rickandmorty.data.repository.character;

import com.eugenebaturov.rickandmorty.data.api.CharacterApi;
import com.eugenebaturov.rickandmorty.models.data.CharacterResponse;
import com.eugenebaturov.rickandmorty.models.domain.Character;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.core.Single;

/**
 * Класс-репозиторий, который является реализацией интерфейса {@link CharacterRepository}.
 */
public class CharacterRepositoryImpl implements CharacterRepository {

    private final CharacterApi mCharacterApi;

    /**
     * Конструктор класса, в который мы передаёт экземпляр Retrofit, чтобы была
     * возможность использовать публичные методы данного класса.
     *
     * @param characterApi - экземпляр Ретрофита, нужен, чтобы проинициализировать mCharacterApi.
     */
    public CharacterRepositoryImpl(CharacterApi characterApi) {
        mCharacterApi = characterApi;
    }

    @Override
    public Single<List<Character>> getAllCharacters() {
        return mCharacterApi.getAllCharacters().map(response -> {
            List<Character> characters = new ArrayList<>();

            for (CharacterResponse character : response.getCharacters()) {
                characters.add(new Character(character));
            }

            return characters;
        });
    }

    @Override
    public Single<Character> getCharacterById(int characterId) {
        return mCharacterApi.getCharacterById(characterId).map(Character::new);
    }
}