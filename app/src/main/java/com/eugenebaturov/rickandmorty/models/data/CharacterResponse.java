package com.eugenebaturov.rickandmorty.models.data;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;

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
    // в enum все известные, остальные в unknown
    private final String mType;

    @SerializedName("gender")
    @NonNull
    private final String mGender;

    @SerializedName("image")
    @NonNull
    private final String mImageUrl;

    @SerializedName("origin")
    @NonNull
    private final Origin mOrigin;

    @SerializedName("location")
    @NonNull
    private final CurrentLocation mCurrentLocation;

    @SerializedName("episode")
    @NonNull
    private final List<String> mEpisodesUrl;

    /**
     * Конструктор класса в который передается вся информация о персонаже, пришедшая из сервера.
     * <p>
     * Используется для unit-тестов!!!
     *
     * @param id              id персонажа.
     * @param name            имя персонажа.
     * @param status          статус персонажа(Жив, Мёртв, Неизвестно).
     * @param species         раса персонажа.
     * @param type            отличительная черта персонажа.
     * @param gender          гендер персонажа.
     * @param imageUrl        url-изображение персонажа.
     * @param origin          место рождения персонажа. Реализовано через класс {@link Origin}
     * @param currentLocation текущее местоположение персонажа.
     *                        Реализовано через класс {@link CurrentLocation}
     * @param episodesUrl     ссылка на эпизоды в которых персонаж появился.
     */
    @VisibleForTesting
    public CharacterResponse(
            final int id,
            @NonNull final String name,
            @NonNull final String status,
            @NonNull final String species,
            @NonNull final String type,
            @NonNull final String gender,
            @NonNull final String imageUrl,
            @NonNull final Origin origin,
            @NonNull final CurrentLocation currentLocation,
            @NonNull final List<String> episodesUrl
    ) {
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
        CharacterResponse characterResponse = (CharacterResponse) o;
        return mId == characterResponse.mId &&
                Objects.equals(mName, characterResponse.mName) &&
                Objects.equals(mStatus, characterResponse.mStatus) &&
                Objects.equals(mSpecies, characterResponse.mSpecies) &&
                Objects.equals(mType, characterResponse.mType) &&
                Objects.equals(mGender, characterResponse.mGender) &&
                Objects.equals(mImageUrl, characterResponse.mImageUrl) &&
                Objects.equals(mOrigin, characterResponse.mOrigin) &&
                Objects.equals(mCurrentLocation, characterResponse.mCurrentLocation) &&
                Objects.equals(mEpisodesUrl, characterResponse.mEpisodesUrl);
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
                mImageUrl,
                mOrigin,
                mCurrentLocation,
                mEpisodesUrl
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
