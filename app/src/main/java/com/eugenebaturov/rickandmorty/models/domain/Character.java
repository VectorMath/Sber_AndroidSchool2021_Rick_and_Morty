package com.eugenebaturov.rickandmorty.models.domain;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.eugenebaturov.rickandmorty.models.data.CharacterResponse;
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
    private final String mImage;

    @NonNull
    private final Origin mOrigin;

    @NonNull
    private final CurrentLocation mCurrentLocation;

    @NonNull
    private final List<String> mEpisodes;

    /**
     * Конструктор класса в который мы вручную передаём все параметры персонажа.
     *
     * @param mId              id персонажа.
     * @param mName            имя персонажа.
     * @param mStatus          статус персонажа.
     * @param mSpecies         раса персонажа
     * @param mType            отличительная черта персонажа.
     * @param mGender          пол персонажа.
     * @param mImage           аватарка персонажа
     * @param mOrigin          место рождения персонажа.
     * @param mCurrentLocation текущая локация в которой находится персонаж.
     * @param mEpisodes        список URL эпизодов в которых персонаж появился.
     */
    public Character(
            final int mId,
            @NonNull final String mName,
            @NonNull final String mStatus,
            @NonNull final String mSpecies,
            @NonNull final String mType,
            @NonNull final String mGender,
            @NonNull final String mImage,
            @NonNull final Origin mOrigin,
            @NonNull final CurrentLocation mCurrentLocation,
            @NonNull final List<String> mEpisodes) {
        this.mId = mId;
        this.mName = mName;
        this.mStatus = mStatus;
        this.mSpecies = mSpecies;
        this.mType = mType;
        this.mGender = mGender;
        this.mImage = mImage;
        this.mOrigin = mOrigin;
        this.mCurrentLocation = mCurrentLocation;
        this.mEpisodes = mEpisodes;
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
                Objects.equals(mImage, character.mImage) &&
                Objects.equals(mOrigin, character.mOrigin) &&
                Objects.equals(mCurrentLocation, character.mCurrentLocation) &&
                Objects.equals(mEpisodes, character.mEpisodes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mId, mName, mStatus, mSpecies, mType, mGender, mImage, mOrigin, mCurrentLocation, mEpisodes);
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
                ", mImage='" + mImage + '\'' +
                ", mOrigin=" + mOrigin +
                ", mCurrentLocation=" + mCurrentLocation +
                ", mEpisodes=" + mEpisodes +
                '}';
    }

    public int getId() {
        return mId;
    }

    @NonNull
    public String getName() {
        return mName;
    }

    @NonNull
    public String getStatus() {
        return mStatus;
    }

    @NonNull
    public String getSpecies() {
        return mSpecies;
    }

    @NonNull
    public String getType() {
        return mType;
    }

    @NonNull
    public String getGender() {
        return mGender;
    }

    @NonNull
    public String getImage() {
        return mImage;
    }

    @NonNull
    public Origin getOrigin() {
        return mOrigin;
    }

    @NonNull
    public CurrentLocation getCurrentLocation() {
        return mCurrentLocation;
    }

    @NonNull
    public List<String> getEpisodes() {
        return mEpisodes;
    }
}
