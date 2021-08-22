package com.eugenebaturov.rickandmorty.data.repository.character;

import com.eugenebaturov.rickandmorty.data.api.CharacterApi;
import com.eugenebaturov.rickandmorty.data.entity.CharacterRequest;
import com.eugenebaturov.rickandmorty.data.entity.list.ListCharacterRequest;

import io.reactivex.rxjava3.core.Single;
import retrofit2.Retrofit;

/**
 * Класс-репозиторий, который является реализацией интерфейса {@link CharacterRepository}.
 */
public class CharacterRepositoryImpl implements CharacterRepository {

    private final CharacterApi mCharacterApi;

    /**
     * Конструктор класса, в который мы передаёт экземпляр Retrofit, чтобы была
     * возможность использовать публичные методы данного класса.
     *
     * @param retrofit - экземпляр Ретрофита, нужен, чтобы проинициализировать mCharacterApi.
     */
    public CharacterRepositoryImpl(Retrofit retrofit) {
        mCharacterApi = retrofit.create(CharacterApi.class);
    }

    @Override
    public Single<ListCharacterRequest> getAllCharacters() {
        return mCharacterApi.getAllCharacters();
    }

    @Override
    public Single<CharacterRequest> getCharacterById(int characterId) {
        return mCharacterApi.getCharacterById(characterId);
    }
}