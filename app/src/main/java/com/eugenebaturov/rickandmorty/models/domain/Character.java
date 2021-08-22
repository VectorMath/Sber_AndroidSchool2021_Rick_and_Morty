package com.eugenebaturov.rickandmorty.models.domain;

import com.eugenebaturov.rickandmorty.models.data.CharacterRequest;
import com.eugenebaturov.rickandmorty.models.data.CurrentLocation;
import com.eugenebaturov.rickandmorty.models.data.Origin;

import java.util.List;
import java.util.Objects;

/**
 * Класс-сущность, которая обрабатывает данные из класса-сущности
 * {@link CharacterRequest} в data-слое
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
     * @param characterRequest - моделька, которая получила данные с api.
     */
    public Character(CharacterRequest characterRequest) {
        mId = characterRequest.getId();
        mName = characterRequest.getName();
        mStatus = characterRequest.getStatus();
        mSpecies = characterRequest.getSpecies();
        mType = characterRequest.getType();
        mGender = characterRequest.getGender();
        mImage = characterRequest.getImage();
        mOrigin = characterRequest.getOrigin();
        mCurrentLocation = characterRequest.getCurrentLocation();
        mEpisodes = characterRequest.getEpisodes();
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
