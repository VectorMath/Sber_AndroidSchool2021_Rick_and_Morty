package com.eugenebaturov.rickandmorty.models.domain;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.eugenebaturov.rickandmorty.models.data.LocationResponse;

import java.util.List;
import java.util.Objects;

/**
 * Класс-сущность, которая обрабатывает данные из класса-сущности
 * {@link LocationResponse} в data-слое
 */
public final class Location {
    private final int mId;
    @Nullable
    private final String mName;
    @Nullable
    private final String mType;
    @Nullable
    private final String mDimension;
    @Nullable
    private final List<String> mResidents;

    /**
     * Конструктор класса
     *
     * @param locationResponse - моделька, которая получила данные с api.
     */
    public Location(@NonNull final LocationResponse locationResponse) {
        mId = locationResponse.getId();
        mName = locationResponse.getName();
        mType = locationResponse.getType();
        mDimension = locationResponse.getDimension();
        mResidents = locationResponse.getResidents();
    }

    /**
     * Конструктор класса в который мы вручную передаём информацию о локации.
     *
     * @param mId        id локации.
     * @param mName      название локации.
     * @param mType      тип локации.
     * @param mDimension измерение локации.
     * @param mResidents список персонажей, которые живут в данной локации.
     */
    public Location(
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
        Location location = (Location) o;
        return mId == location.mId &&
                Objects.equals(mName, location.mName) &&
                Objects.equals(mType, location.mType) &&
                Objects.equals(mDimension, location.mDimension) &&
                Objects.equals(mResidents, location.mResidents);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mId, mName, mType, mDimension, mResidents);
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
