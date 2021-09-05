package com.eugenebaturov.rickandmorty.models.data;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

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
public final class CharacterResponse {

    @SerializedName("id")
    private int mId;

    @SerializedName("name")
    @Nullable
    private String mName;

    @SerializedName("status")
    @Nullable
    private String mStatus;

    @SerializedName("species")
    @Nullable
    private String mSpecies;

    @SerializedName("type")
    @Nullable
    private String mType;

    @SerializedName("gender")
    @Nullable
    private String mGender;

    @SerializedName("image")
    @Nullable
    private String mImage;

    @SerializedName("origin")
    @Nullable
    private Origin mOrigin;

    @SerializedName("location")
    @Nullable
    private CurrentLocation mCurrentLocation;

    @SerializedName("episode")
    @Nullable
    private List<String> mEpisodes;

    public CharacterResponse() {

    }

    /**
     * Конструктор класса в который передается вся информация о персонаже, пришедшая из сервера.
     *
     * @param mId              id персонажа.
     * @param mName            имя персонажа.
     * @param mStatus          статус персонажа(Жив, Мёртв, Неизвестно).
     * @param mSpecies         раса персонажа.
     * @param mType            отличительная черта персонажа.
     * @param mGender          гендер персонажа.
     * @param mImage           изображение персонажа.
     * @param mOrigin          место рождения персонажа. Реализовано через класс {@link Origin}
     * @param mCurrentLocation текущее местоположение персонажа.
     *                         Реализовано через класс {@link CurrentLocation}
     * @param mEpisodes        ссылка на эпизоды в которых персонаж появился.
     */
    public CharacterResponse(
            final int mId,
            @Nullable final String mName,
            @Nullable final String mStatus,
            @Nullable final String mSpecies,
            @Nullable final String mType,
            @Nullable final String mGender,
            @Nullable final String mImage,
            @Nullable final Origin mOrigin,
            @Nullable final CurrentLocation mCurrentLocation,
            @Nullable final List<String> mEpisodes
    ) {
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
