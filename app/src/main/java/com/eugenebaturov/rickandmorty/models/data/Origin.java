package com.eugenebaturov.rickandmorty.models.data;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

/**
 * Подкласс, который является полем для класса-сущности {@link CharacterResponse}.
 */
public final class Origin {

    @SerializedName("name")
    @NonNull
    private final String mName;

    @SerializedName("url")
    @NonNull
    private final String mUrl;

    /**
     * Конструктор класса.
     * @param mName название локации.
     * @param mUrl Url локации.
     */
    public Origin(@NonNull final String mName, @NonNull final String mUrl) {
        this.mName = mName;
        this.mUrl = mUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Origin origin = (Origin) o;
        return Objects.equals(mName, origin.mName) &&
                Objects.equals(mUrl, origin.mUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mName, mUrl);
    }

    @Override
    @NonNull
    public String toString() {
        return "Origin{" +
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
