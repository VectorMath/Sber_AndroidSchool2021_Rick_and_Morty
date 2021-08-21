package com.eugenebaturov.rickandmorty.domain.entity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

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
public class Location {

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
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getType() != null ? getType().hashCode() : 0);
        result = 31 * result + (getDimension() != null ? getDimension().hashCode() : 0);
        result = 31 * result + (getResidents() != null ? getResidents().hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Location)) {
            return false;
        }

        Location that = (Location) obj;

        if (getName() != null
                ? getName().equals(that.getName())
                : that.getName() == null)
            return false;

        if (getType() != null
                ? getType().equals(that.getType())
                : that.getType() == null)
            return false;

        if (getDimension() != null
                ? getDimension().equals(that.getDimension())
                : that.getDimension() == null)
            return false;

        if (getResidents() != null
                ? getResidents().equals(that.getResidents())
                : that.getResidents() == null)
            return false;

        return getId() == that.getId();
    }

    @NonNull
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Location{");
        sb.append("mId: ").append(mId).append('\'');
        sb.append("mName: ").append(mName).append('\'');
        sb.append("mType: ").append(mType).append('\'');
        sb.append("mDimension: ").append(mDimension).append('\'');
        sb.append("mResidents: ").append(mResidents.toString()).append('\'');
        sb.append('}');
        return sb.toString();
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
