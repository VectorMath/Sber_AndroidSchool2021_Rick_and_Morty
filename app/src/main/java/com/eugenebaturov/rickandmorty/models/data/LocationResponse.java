package com.eugenebaturov.rickandmorty.models.data;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Objects;

/**
 * Класс-сущность, который хранит информацию о локации в мульт-сериале "Рик и Морти".
 */
public final class LocationResponse {

    @SerializedName("id")
    private final int mId;

    @SerializedName("name")
    @NonNull
    private final String mName;

    @SerializedName("type")
    @NonNull
    private final String mType;

    @SerializedName("dimension")
    @NonNull
    private final String mDimension;

    @SerializedName("residents")
    @NonNull
    private final List<String> mResidentsUrl;

    /**
     * Конструктор класса в который передаётся вся информация о локации.
     * <p>
     * Используется в unit-тестах!!!
     *
     * @param id           id локации.
     * @param name         название локации.
     * @param type         тип локации.
     * @param dimension    измерение локации.
     * @param residentsUrl url-список жителей в этой локации.
     */
    @VisibleForTesting
    public LocationResponse(
            final int id,
            @NonNull final String name,
            @NonNull final String type,
            @NonNull final String dimension,
            @NonNull final List<String> residentsUrl) {
        mId = id;
        mName = name;
        mType = type;
        mDimension = dimension;
        mResidentsUrl = residentsUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LocationResponse locationResponse = (LocationResponse) o;
        return mId == locationResponse.mId &&
                Objects.equals(mName, locationResponse.mName) &&
                Objects.equals(mType, locationResponse.mType) &&
                Objects.equals(mDimension, locationResponse.mDimension) &&
                Objects.equals(mResidentsUrl, locationResponse.mResidentsUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                mId,
                mName,
                mType,
                mDimension,
                mResidentsUrl
        );
    }

    @Override
    @NonNull
    public String toString() {
        return "Location{" +
                "mId=" + mId +
                ", mName='" + mName + '\'' +
                ", mType='" + mType + '\'' +
                ", mDimension='" + mDimension + '\'' +
                ", mResidentsUrl=" + mResidentsUrl +
                '}';
    }

    /**
     * Получить id локации.
     *
     * @return id локации.
     */
    public int getId() {
        return mId;
    }

    /**
     * Получить название локации.
     *
     * @return название локации.
     */
    @NonNull
    public String getName() {
        return mName;
    }

    /**
     * Получить тип локации.
     *
     * @return тип локации.
     */
    @NonNull
    public String getType() {
        return mType;
    }

    /**
     * Получить измерение локации.
     *
     * @return измерение локации.
     */
    @NonNull
    public String getDimension() {
        return mDimension;
    }

    /**
     * Получить список url-ссылок персонажей, которые живут в этой локации.
     *
     * @return url-список персонажей.
     */
    @NonNull
    public List<String> getResidents() {
        return mResidentsUrl;
    }
}
