package com.eugenebaturov.rickandmorty.data.repository.character;

import com.eugenebaturov.rickandmorty.data.api.CharacterApi;
import com.eugenebaturov.rickandmorty.domain.entity.Character;

import java.util.List;

import retrofit2.Call;

/**
 * Интерфейс, методы которого "дёргают" ручки в {@link CharacterApi}.
 */
public interface ICharacterRepository {

    /**
     * Метод, который дергает ручку getAllCharacters.
     *
     * @return список персонажей.
     */
    Call<List<Character>> getAllCharacters();

    /**
     * Метод, который дергает ручку getCharacterById.
     *
     * @param characterId - id персонажа.
     * @return персонаж с данным id.
     */
    Call<Character> getCharacterById(int characterId);
}
