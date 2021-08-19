package com.eugenebaturov.rickandmorty.data.repository;

import com.eugenebaturov.rickandmorty.data.api.CharacterApi;
import com.eugenebaturov.rickandmorty.domain.entity.Character;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;

public class CharacterRepository {

    private final CharacterApi mCharacterApi;

    public CharacterRepository(Retrofit retrofit) {
        mCharacterApi = retrofit.create(CharacterApi.class);
    }

    public Call<List<Character>> getAllCharacters() {
        return mCharacterApi.getAllCharacters();
    }

    public Call<Character> getCharacterById(int characterId) {
        return mCharacterApi.getCharacterById(characterId);
    }
}