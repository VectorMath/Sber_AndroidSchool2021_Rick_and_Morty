package com.eugenebaturov.rickandmorty.models.data;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Objects;

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
public class CharacterResponse {

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CharacterResponse characterResponse = (CharacterResponse) o;
        return mId == characterResponse.mId &&
                Objects.equals(mName, characterResponse.mName) &&
                Objects.equals(mStatus, characterResponse.mStatus) &&
                Objects.equals(mSpecies, characterResponse.mSpecies) &&
                Objects.equals(mType, characterResponse.mType) &&
                Objects.equals(mGender, characterResponse.mGender) &&
                Objects.equals(mImage, characterResponse.mImage) &&
                Objects.equals(mOrigin, characterResponse.mOrigin) &&
                Objects.equals(mCurrentLocation, characterResponse.mCurrentLocation) &&
                Objects.equals(mEpisodes, characterResponse.mEpisodes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                mId,
                mName,
                mStatus,
                mSpecies,
                mType,
                mGender,
                mImage,
                mOrigin,
                mCurrentLocation,
                mEpisodes
        );
    }

    @NonNull
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
