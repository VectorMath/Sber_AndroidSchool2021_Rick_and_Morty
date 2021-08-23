package com.eugenebaturov.rickandmorty.models.data.list;

import com.eugenebaturov.rickandmorty.models.data.CharacterResponse;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Objects;

/**
 * Класс-сущность, который хранит информацию о персонажах мульт-сериала "Рик и Морти".
 * <p>
 * [mCharactersResponse] - список персонажей {@link CharacterResponse}
 */
public class ListCharacterResponse {

    @SerializedName("results")
    private List<CharacterResponse> mCharactersResponse;

    /**
     * Пустой конструктор класса.
     */
    public ListCharacterResponse() {
    }

    /**
     * Конструктор класса в который передаётся {@link List}<{@link CharacterResponse}>.
     * @param charactersResponse Список персонажей в виде ответа из сервера.
     */
    public ListCharacterResponse(List<CharacterResponse> charactersResponse) {
        mCharactersResponse = charactersResponse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListCharacterResponse that = (ListCharacterResponse) o;
        return Objects.equals(mCharactersResponse, that.mCharactersResponse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mCharactersResponse);
    }

    @Override
    public String toString() {
        return "ListCharacterRequest{" +
                "mCharactersResponse=" + mCharactersResponse +
                '}';
    }

    public List<CharacterResponse> getCharacters() {
        return mCharactersResponse;
    }

    public void setCharacters(List<CharacterResponse> mCharacters) {
        this.mCharactersResponse = mCharacters;
    }
}
