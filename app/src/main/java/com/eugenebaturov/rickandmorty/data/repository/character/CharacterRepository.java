package com.eugenebaturov.rickandmorty.data.repository.character;

import com.eugenebaturov.rickandmorty.data.api.CharacterApi;
import com.eugenebaturov.rickandmorty.domain.entity.Character;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;

/**
 * Класс-репозиторий, который является реализацией интерфейса {@link ICharacterRepository}.
 */
public class CharacterRepository implements ICharacterRepository {

    private final CharacterApi mCharacterApi;

    /**
     * Конструктор класса, в который мы передаёт экземпляр Retrofit, чтобы была
     * возможность использовать публичные методы данного класса.
     *
     * @param retrofit - экземпляр Ретрофита, нужен, чтобы проинициализировать mCharacterApi.
     */
    public CharacterRepository(Retrofit retrofit) {
        mCharacterApi = retrofit.create(CharacterApi.class);
    }

    @Override
    public Call<List<Character>> getAllCharacters() {
        return mCharacterApi.getAllCharacters();
    }

    @Override
    public Call<Character> getCharacterById(int characterId) {
        return mCharacterApi.getCharacterById(characterId);
    }
}