package com.eugenebaturov.rickandmorty.models.data;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Objects;

/**
 * Класс-сущность, который хранит информацию о локации в мульт-сериале "Рик и Морти".
 * <p>
 * [mId] - id локации.
 * <p>
 * [mName] - название локации.
 * <p>
 * [mType] - тип локации.
 * <p>
 * [mDimension] - измерение локации.
 * <p>
 * [mResidents] - список персонажей, которые находятся в локации.
 */
public final class LocationResponse {

    @SerializedName("id")
    private int mId;

    @SerializedName("name")
    @Nullable
    private String mName;

    @SerializedName("type")
    @Nullable
    private String mType;

    @SerializedName("dimension")
    @Nullable
    private String mDimension;

    @SerializedName("residents")
    @Nullable
    private List<String> mResidents;

    /**
     * Пустой конструктор класса.
     */
    public LocationResponse() {

    }

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
            @Nullable final String mName,
            @Nullable final String mType,
            @Nullable final String mDimension,
            @Nullable final List<String> mResidents) {
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

    public String getName() {
        return mName;
    }

    public String getType() {
        return mType;
    }

    public String getDimension() {
        return mDimension;
    }

    public List<String> getResidents() {
        return mResidents;
    }
}
