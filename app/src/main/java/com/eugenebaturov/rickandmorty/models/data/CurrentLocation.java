package com.eugenebaturov.rickandmorty.models.data;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

/**
 * Подкласс, который является полем у класса-сущности {@link CharacterResponse}.
 */
public final class CurrentLocation {

    @SerializedName("name")
    @NonNull
    private final String mName;

    @SerializedName("url")
    @NonNull
    private final String mUrl;

    /**
     * Конструктор класса в который передается вся информация об локации, пришедшая из сервера.
     * <p>
     * Используется в unit-тестах!!!
     *
     * @param name название локации.
     * @param url  URL локации.
     */
    @VisibleForTesting
    public CurrentLocation(@NonNull final String name, @NonNull final String url) {
        mName = name;
        mUrl = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurrentLocation that = (CurrentLocation) o;
        return Objects.equals(mName, that.mName) &&
                Objects.equals(mUrl, that.mUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mName, mUrl);
    }

    @NonNull
    @Override
    public String toString() {
        return "CurrentLocation{" +
                "mName='" + mName + '\'' +
                ", mUrl='" + mUrl + '\'' +
                '}';
    }

    /**
     * Получить название локации
     *
     * @return название локации.
     */
    @NonNull
    public String getName() {
        return mName;
    }

    /**
     * Получить ссылку на локацию
     *
     * @return url локации.
     */
    @NonNull
    public String getUrl() {
        return mUrl;
    }
}
