package com.eugenebaturov.rickandmorty.models.data.list;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;

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
    @NonNull
    private final List<CharacterResponse> mCharactersResponse;

    /**
     * Конструктор класса.
     * <p>
     * Используется в unit-тестах!!!
     *
     * @param charactersResponse Список персонажей в виде ответа из сервера.
     */
    @VisibleForTesting
    public ListCharacterResponse(@NonNull final List<CharacterResponse> charactersResponse) {
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

    /**
     * Получить список персонажей.
     *
     * @return список персонажей в виде ответа из сервера.
     */
    @NonNull
    public List<CharacterResponse> getCharacters() {
        return mCharactersResponse;
    }
}
