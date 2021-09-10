package com.eugenebaturov.rickandmorty.models.data;

import androidx.annotation.NonNull;

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
     * @param mName название локации.
     * @param mUrl URL локации.
     */
    public CurrentLocation(@NonNull final String mName, @NonNull final String mUrl) {
        this.mName = mName;
        this.mUrl = mUrl;
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

    @NonNull
    public String getName() {
        return mName;
    }

    @NonNull
    public String getUrl() {
        return mUrl;
    }
}
