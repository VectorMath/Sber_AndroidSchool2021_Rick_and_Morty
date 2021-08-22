package com.eugenebaturov.rickandmorty.data.entity;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

/**
 * Подкласс, который является полем для класса-сущности {@link CharacterRequest}.
 * <p>
 * Хранит в себе информацию о месте рождения персонажа.
 * <p>
 * [mName] - название локации.
 * <p>
 * [mUrl] - ссылка на локацию, информацию о которой хранит класс-сущность {@link LocationRequest}.
 */
public class Origin {

    @SerializedName("name")
    private String mName;

    @SerializedName("url")
    private String mUrl;

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
    public String toString() {
        return "Origin{" +
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