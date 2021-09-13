package com.eugenebaturov.rickandmorty.models.domain;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;

import com.eugenebaturov.rickandmorty.models.data.CurrentLocation;
import com.eugenebaturov.rickandmorty.models.data.Origin;

import java.util.List;
import java.util.Objects;

/**
 * Класс-сущность персонажа в domain/ui - слое.
 */
public final class Character {
    private final int mId;

    @NonNull
    private final String mName;

    @NonNull
    private final String mStatus;

    @NonNull
    private final String mSpecies;

    @NonNull
    private final String mType;

    @NonNull
    private final String mGender;

    @NonNull
    private final String mImageUrl;

    @NonNull
    private final Origin mOrigin;

    @NonNull
    private final CurrentLocation mCurrentLocation;

    @NonNull
    private final List<String> mEpisodesUrl;

    /**
     * Конструктор класса в который мы вручную передаём все параметры персонажа.
     *
     * @param id              id персонажа.
     * @param name            имя персонажа.
     * @param status          статус персонажа.
     * @param species         раса персонажа
     * @param type            отличительная черта персонажа.
     * @param gender          пол персонажа.
     * @param imageUrl        url аватарки персонажа
     * @param origin          место рождения персонажа.
     * @param currentLocation текущая локация в которой находится персонаж.
     * @param episodesUrl     список URL эпизодов в которых персонаж появился.
     */
    public Character(
            final int id,
            @NonNull final String name,
            @NonNull final String status,
            @NonNull final String species,
            @NonNull final String type,
            @NonNull final String gender,
            @NonNull final String imageUrl,
            @NonNull final Origin origin,
            @NonNull final CurrentLocation currentLocation,
            @NonNull final List<String> episodesUrl) {
        mId = id;
        mName = name;
        mStatus = status;
        mSpecies = species;
        mType = type;
        mGender = gender;
        mImageUrl = imageUrl;
        mOrigin = origin;
        mCurrentLocation = currentLocation;
        mEpisodesUrl = episodesUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Character character = (Character) o;
        return mId == character.mId &&
                Objects.equals(mName, character.mName) &&
                Objects.equals(mStatus, character.mStatus) &&
                Objects.equals(mSpecies, character.mSpecies) &&
                Objects.equals(mType, character.mType) &&
                Objects.equals(mGender, character.mGender) &&
                Objects.equals(mImageUrl, character.mImageUrl) &&
                Objects.equals(mOrigin, character.mOrigin) &&
                Objects.equals(mCurrentLocation, character.mCurrentLocation) &&
                Objects.equals(mEpisodesUrl, character.mEpisodesUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mId, mName, mStatus, mSpecies, mType, mGender, mImageUrl, mOrigin, mCurrentLocation, mEpisodesUrl);
    }

    @Override
    @NonNull
    public String toString() {
        return "Character{" +
                "mId=" + mId +
                ", mName='" + mName + '\'' +
                ", mStatus='" + mStatus + '\'' +
                ", mSpecies='" + mSpecies + '\'' +
                ", mType='" + mType + '\'' +
                ", mGender='" + mGender + '\'' +
                ", mImageUrl='" + mImageUrl + '\'' +
                ", mOrigin=" + mOrigin +
                ", mCurrentLocation=" + mCurrentLocation +
                ", mEpisodesUrl=" + mEpisodesUrl +
                '}';
    }

    /**
     * Получить id персонажа.
     *
     * @return id персонажа.
     */
    public int getId() {
        return mId;
    }


    /**
     * Получить имя персонажа.
     *
     * @return имя персонажа.
     */
    @NonNull
    public String getName() {
        return mName;
    }

    /**
     * Получить статус персонажа.
     *
     * @return статус персонажа.
     */
    @NonNull
    public String getStatus() {
        return mStatus;
    }

    /**
     * Получить расу персонажа.
     *
     * @return раса персонажа.
     */
    @NonNull
    public String getSpecies() {
        return mSpecies;
    }

    /**
     * Получить отличительную черту персонажа.
     *
     * @return отличительная черта персонажа.
     */
    @NonNull
    public String getType() {
        return mType;
    }

    /**
     * Получить пол персонажа.
     *
     * @return пол персонажа.
     */
    @NonNull
    public String getGender() {
        return mGender;
    }

    /**
     * Получить url-изображение персонажа.
     *
     * @return url-изображение персонажа.
     */
    @NonNull
    public String getImage() {
        return mImageUrl;
    }

    /**
     * Получить id персонажа.
     *
     * @return id персонажа.
     */
    @NonNull
    public Origin getOrigin() {
        return mOrigin;
    }

    /**
     * Получить место рождения персонажа.
     *
     * @return место рождения персонажа.
     */
    @NonNull
    public CurrentLocation getCurrentLocation() {
        return mCurrentLocation;
    }

    /**
     * Получить url список эпизодов в которых учавствовал персонаж.
     *
     * @return список url-эпизодов.
     */
    @NonNull
    public List<String> getEpisodesUrl() {
        return mEpisodesUrl;
    }
}
