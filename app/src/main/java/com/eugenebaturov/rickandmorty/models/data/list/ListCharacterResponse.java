package com.eugenebaturov.rickandmorty.models.data.list;

import com.eugenebaturov.rickandmorty.models.data.CharacterResponse;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Objects;

/**
 * Класс-сущность, который хранит информацию о персонажах мульт-сериала "Рик и Морти".
 * <p>
 * [mCharacters] - список персонажей {@link CharacterResponse}
 */
public class ListCharacterResponse {

    @SerializedName("results")
    private List<CharacterResponse> mCharacters;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListCharacterResponse that = (ListCharacterResponse) o;
        return Objects.equals(mCharacters, that.mCharacters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mCharacters);
    }

    @Override
    public String toString() {
        return "ListCharacterRequest{" +
                "mCharacters=" + mCharacters +
                '}';
    }

    public List<CharacterResponse> getCharacters() {
        return mCharacters;
    }

    public void setCharacters(List<CharacterResponse> mCharacters) {
        this.mCharacters = mCharacters;
    }
}
