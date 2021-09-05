package com.eugenebaturov.rickandmorty.models.data.list;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.eugenebaturov.rickandmorty.models.data.CharacterResponse;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Objects;

/**
 * Класс-сущность, который хранит информацию о персонажах мульт-сериала "Рик и Морти".
 * <p>
 * [mCharactersResponse] - список персонажей {@link CharacterResponse}
 */
public final class ListCharacterResponse {

    @SerializedName("results")
    @Nullable
    private List<CharacterResponse> mCharactersResponse;

    /**
     * Пустой конструктор класса.
     */
    public ListCharacterResponse() {
    }

    /**
     * Конструктор класса в который передаётся {@link List}<{@link CharacterResponse}>.
     *
     * @param charactersResponse Список персонажей в виде ответа из сервера.
     */
    public ListCharacterResponse(@Nullable final List<CharacterResponse> charactersResponse) {
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
    @NonNull
    public String toString() {
        return "ListCharacterRequest{" +
                "mCharactersResponse=" + mCharactersResponse +
                '}';
    }

    @Nullable
    public List<CharacterResponse> getCharacters() {
        return mCharactersResponse;
    }

    public void setCharacters(@NonNull final List<CharacterResponse> mCharacters) {
        this.mCharactersResponse = mCharacters;
    }
}
