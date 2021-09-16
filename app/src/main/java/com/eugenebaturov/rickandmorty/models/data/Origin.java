package com.eugenebaturov.rickandmorty.models.data;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.room.ColumnInfo;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

/**
 * Подкласс, который является полем для класса-сущности {@link CharacterResponse}.
 */
public final class Origin {

    @ColumnInfo(name = "origin_name")
    @SerializedName("name")
    @NonNull
    private final String mName;

    @ColumnInfo(name = "origin_url")
    @SerializedName("url")
    @NonNull
    private final String mUrl;

    /**
     * Конструктор класса.
     * <p>
     * Используется в unit-тестах!!!
     *
     * @param name название локации.
     * @param url  Url локации.
     */
    @VisibleForTesting
    public Origin(@NonNull final String name, @NonNull final String url) {
        mName = name;
        mUrl = url;
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
