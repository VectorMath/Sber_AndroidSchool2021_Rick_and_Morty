package com.eugenebaturov.rickandmorty.models.data;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Objects;

/**
 * Класс-сущность, который хранит информацию о персонаже мульт-сериала "Рик и Морти".
 */
public final class CharacterResponse {

    @SerializedName("id")
    private final int mId;

    @SerializedName("name")
    @NonNull
    private final String mName;

    @SerializedName("status")
    @NonNull
    private final String mStatus;

    @SerializedName("species")
    @NonNull
    private final String mSpecies;

    @SerializedName("type")
    @NonNull
    private final String mType;

    @SerializedName("gender")
    @NonNull
    private final String mGender;

    @SerializedName("image")
    @NonNull
    private final String mImage;

    @SerializedName("origin")
    @NonNull
    private final Origin mOrigin;

    @SerializedName("location")
    @NonNull
    private final CurrentLocation mCurrentLocation;

    @SerializedName("episode")
    @NonNull
    private final List<String> mEpisodes;

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
            @NonNull final String mName,
            @NonNull final String mStatus,
            @NonNull final String mSpecies,
            @NonNull final String mType,
            @NonNull final String mGender,
            @NonNull final String mImage,
            @NonNull final Origin mOrigin,
            @NonNull final CurrentLocation mCurrentLocation,
            @NonNull final List<String> mEpisodes
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
