package com.eugenebaturov.rickandmorty.domain.entity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Класс-сущность, который хранит информацию о персонаже мульт-сериала "Рик и Морти".
 * <p>
 * [mId] - id персонажа.
 * <p>
 * [mName] - имя персонажа.
 * <p>
 * [mStatus] - статус персонажа(Жив, Мёртв, Неизвестно).
 * <p>
 * [mSpecies] - раса персонажа.
 * <p>
 * [mType] - отличительная черта персонажа.
 * <p>
 * [mGender] - гендер персонажа.
 * <p>
 * [mImage] - изображение персонажа.
 * <p>
 * [mOrigin] - место рождения персонажа. Реализовано через класс {@link Origin}
 * <p>
 * [mCurrentLocation] - текущее местоположение персонажа.
 * Реализовано через класс {@link CurrentLocation}
 * <p>
 * [mEpisodes] - ссылка на эпизоды в которых персонаж появился.
 */
public class Character {

    @SerializedName("id")
    private int mId;

    @SerializedName("name")
    private String mName;

    @SerializedName("status")
    private String mStatus;

    @SerializedName("species")
    private String mSpecies;

    @SerializedName("type")
    private String mType;

    @SerializedName("gender")
    private String mGender;

    @SerializedName("image")
    private String mImage;

    @SerializedName("origin")
    private Origin mOrigin;

    @SerializedName("location")
    private CurrentLocation mCurrentLocation;

    @SerializedName("episode")
    private List<String> mEpisodes;

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

    public int getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public String getStatus() {
        return mStatus;
    }

    public String getSpecies() {
        return mSpecies;
    }

    public String getType() {
        return mType;
    }

    public String getGender() {
        return mGender;
    }

    public String getImage() {
        return mImage;
    }

    public Origin getOrigin() {
        return mOrigin;
    }

    public CurrentLocation getCurrentLocation() {
        return mCurrentLocation;
    }

    public List<String> getEpisodes() {
        return mEpisodes;
    }
}
