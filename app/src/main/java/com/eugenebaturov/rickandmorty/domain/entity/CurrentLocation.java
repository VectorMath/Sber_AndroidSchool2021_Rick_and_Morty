package com.eugenebaturov.rickandmorty.domain.entity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

/**
 * Подкласс, который является полем у класса-сущности {@link Character}.
 * <p>
 * Хранит в себе информацию о текущем местоположение персонажа.
 * <p>
 * [mName] - название локации.
 * <p>
 * [mUrl] - ссылка на локацию, информацию о которой хранит класс-сущность {@link Location}.
 */
public class CurrentLocation {

    @SerializedName("name")
    private String mName;

    @SerializedName("url")
    private String mUrl;

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        return super.equals(obj);
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }

    public String getName() {
        return mName;
    }

    public String getUrl() {
        return mUrl;
    }
}
