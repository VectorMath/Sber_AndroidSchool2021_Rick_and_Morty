package com.eugenebaturov.rickandmorty.models.domain;

import androidx.annotation.NonNull;

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

    private final int mImageStatusResource;

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

    private final int mOriginId;

    @NonNull
    private final CurrentLocation mCurrentLocation;

    private final int mCurrentLocationId;

    @NonNull
    private final List<String> mEpisodesUrl;

    /**
     * Конструктор класса в который мы вручную передаём все параметры персонажа.
     *
     * @param id                id персонажа.
     * @param name              имя персонажа.
     * @param status            статус персонажа.
     * @param species           раса персонажа
     * @param type              отличительная черта персонажа.
     * @param gender            пол персонажа.
     * @param imageUrl          url аватарки персонажа
     * @param origin            место рождения персонажа.
     * @param originId          id локации места рождения.
     * @param currentLocation   текущая локация в которой находится персонаж.
     * @param currentLocationId id текущей локации.
     * @param episodesUrl       список URL эпизодов в которых персонаж появился.
     */
    public Character(
            final int id,
            @NonNull final String name,
            @NonNull final String status,
            final int imageStatusResource,
            @NonNull final String species,
            @NonNull final String type,
            @NonNull final String gender,
            @NonNull final String imageUrl,
            @NonNull final Origin origin,
            final int originId,
            @NonNull final CurrentLocation currentLocation,
            final int currentLocationId,
            @NonNull final List<String> episodesUrl) {
        mId = id;
        mName = name;
        mStatus = status;
        mImageStatusResource = imageStatusResource;
        mSpecies = species;
        mType = type;
        mGender = gender;
        mImageUrl = imageUrl;
        mOrigin = origin;
        mOriginId = originId;
        mCurrentLocation = currentLocation;
        mCurrentLocationId = currentLocationId;
        mEpisodesUrl = episodesUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Character character = (Character) o;
        return mId == character.mId &&
                mImageStatusResource == character.mImageStatusResource &&
                mOriginId == character.mOriginId &&
                mCurrentLocationId == character.mCurrentLocationId &&
                mName.equals(character.mName) &&
                mStatus.equals(character.mStatus) &&
                mSpecies.equals(character.mSpecies) &&
                mType.equals(character.mType) &&
                mGender.equals(character.mGender) &&
                mImageUrl.equals(character.mImageUrl) &&
                mOrigin.equals(character.mOrigin) &&
                mCurrentLocation.equals(character.mCurrentLocation) &&
                mEpisodesUrl.equals(character.mEpisodesUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mId, mName, mStatus, mImageStatusResource, mSpecies, mType, mGender, mImageUrl, mOrigin, mOriginId, mCurrentLocation, mCurrentLocationId, mEpisodesUrl);
    }

    @Override
    public String toString() {
        return "Character{" +
                "mId=" + mId +
                ", mName='" + mName + '\'' +
                ", mStatus='" + mStatus + '\'' +
                ", mImageStatusResource=" + mImageStatusResource +
                ", mSpecies='" + mSpecies + '\'' +
                ", mType='" + mType + '\'' +
                ", mGender='" + mGender + '\'' +
                ", mImageUrl='" + mImageUrl + '\'' +
                ", mOrigin=" + mOrigin +
                ", mOriginId=" + mOriginId +
                ", mCurrentLocation=" + mCurrentLocation +
                ", mCurrentLocationId=" + mCurrentLocationId +
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
     * Получить ресурс изображения статуса персонажа.
     *
     * @return ресурс изображения статуса персонажа.
     */
    public int getImageStatusResource() {
        return mImageStatusResource;
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

    /**
     * Получить id места рождения.
     *
     * @return id места рождения.
     */
    public int getOriginId() {
        return mOriginId;
    }

    /**
     * Получить id текущей локации.
     *
     * @return id текущей локации.
     */
    public int getCurrentLocationId() {
        return mCurrentLocationId;
    }
}
