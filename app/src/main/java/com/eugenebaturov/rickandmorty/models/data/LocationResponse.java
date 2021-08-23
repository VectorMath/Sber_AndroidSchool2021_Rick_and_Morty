package com.eugenebaturov.rickandmorty.models.data;

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
public class LocationResponse {

    @SerializedName("id")
    private int mId;

    @SerializedName("name")
    private String mName;

    @SerializedName("type")
    private String mType;

    @SerializedName("dimension")
    private String mDimension;

    @SerializedName("residents")
    private List<String> mResidents;

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
