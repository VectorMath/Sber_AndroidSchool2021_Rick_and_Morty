package com.eugenebaturov.rickandmorty.data.api;

import com.eugenebaturov.rickandmorty.domain.entity.Character;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import static com.eugenebaturov.rickandmorty.data.api.RickAndMortyURL.CHARACTERS_URL;

public interface CharacterApi {

    @GET(CHARACTERS_URL)
    Call<List<Character>> getAllCharacters();

    @GET(CHARACTERS_URL + "{id}")
    Call<Character> getCharacterById(@Path("id") int characterId);
}