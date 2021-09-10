package com.eugenebaturov.rickandmorty.models.data;

import androidx.annotation.NonNull;

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
    private final List<String> mResidents;

    /**
     * Конструктор класса в который передаётся вся информация о локации.
     *
     * @param mId        id локации.
     * @param mName      название локации.
     * @param mType      тип локации.
     * @param mDimension измерение локации.
     * @param mResidents список жителей в этой локации.
     */
    public LocationResponse(
            final int mId,
            @NonNull final String mName,
            @NonNull final String mType,
            @NonNull final String mDimension,
            @NonNull final List<String> mResidents) {
        this.mId = mId;
        this.mName = mName;
        this.mType = mType;
        this.mDimension = mDimension;
        this.mResidents = mResidents;
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
                Objects.equals(mResidents, locationResponse.mResidents);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                mId,
                mName,
                mType,
                mDimension,
                mResidents
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
                ", mResidents=" + mResidents +
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
    public String getType() {
        return mType;
    }

    @NonNull
    public String getDimension() {
        return mDimension;
    }

    @NonNull
    public List<String> getResidents() {
        return mResidents;
    }
}
