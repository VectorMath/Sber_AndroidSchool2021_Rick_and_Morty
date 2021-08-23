package com.eugenebaturov.rickandmorty.models.data;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

/**
 * Подкласс, который является полем у класса-сущности {@link CharacterResponse}.
 * <p>
 * Хранит в себе информацию о текущем местоположение персонажа.
 * <p>
 * [mName] - название локации.
 * <p>
 * [mUrl] - ссылка на локацию, информацию о которой хранит класс-сущность {@link LocationResponse}.
 */
public class CurrentLocation {

    @SerializedName("name")
    private String mName;

    @SerializedName("url")
    private String mUrl;

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

    public String getName() {
        return mName;
    }

    public String getUrl() {
        return mUrl;
    }
}
