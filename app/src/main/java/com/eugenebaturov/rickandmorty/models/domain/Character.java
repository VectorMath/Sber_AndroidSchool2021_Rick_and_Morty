package com.eugenebaturov.rickandmorty.models.domain;

import com.eugenebaturov.rickandmorty.models.data.CharacterResponse;
import com.eugenebaturov.rickandmorty.models.data.CurrentLocation;
import com.eugenebaturov.rickandmorty.models.data.Origin;

import java.util.List;
import java.util.Objects;

/**
 * Класс-сущность, которая обрабатывает данные из класса-сущности
 * {@link CharacterResponse} в data-слое
 */
public class Character {
    private final int mId;
    private final String mName;
    private final String mStatus;
    private final String mSpecies;
    private final String mType;
    private final String mGender;
    private final String mImage;
    private final Origin mOrigin;
    private final CurrentLocation mCurrentLocation;
    private final List<String> mEpisodes;

    /**
     * Конструктор класса
     *
     * @param characterResponse - моделька, которая получила данные с api.
     */
    public Character(CharacterResponse characterResponse) {
        mId = characterResponse.getId();
        mName = characterResponse.getName();
        mStatus = characterResponse.getStatus();
        mSpecies = characterResponse.getSpecies();
        mType = characterResponse.getType();
        mGender = characterResponse.getGender();
        mImage = characterResponse.getImage();
        mOrigin = characterResponse.getOrigin();
        mCurrentLocation = characterResponse.getCurrentLocation();
        mEpisodes = characterResponse.getEpisodes();
    }

    /**
     * Конструктор класса в который мы вручную передаём все параметры персонажа.
     *
     * @param mId id персонажа.
     * @param mName имя персонажа.
     * @param mStatus статус персонажа.
     * @param mSpecies раса персонажа
     * @param mType отличительная черта персонажа.
     * @param mGender пол персонажа.
     * @param mImage аватарка персонажа
     * @param mOrigin место рождения персонажа.
     * @param mCurrentLocation текущая локация в которой находится персонаж.
     * @param mEpisodes список URL эпизодов в которых персонаж появился.
     */
    public Character(
            int mId,
            String mName,
            String mStatus,
            String mSpecies,
            String mType,
            String mGender,
            String mImage,
            Origin mOrigin,
            CurrentLocation mCurrentLocation,
            List<String> mEpisodes) {
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
