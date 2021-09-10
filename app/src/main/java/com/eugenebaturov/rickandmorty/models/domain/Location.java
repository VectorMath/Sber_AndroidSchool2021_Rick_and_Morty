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
    @NonNull
    private final String mName;
    @NonNull
    private final String mType;
    @NonNull
    private final String mDimension;
    @NonNull
    private final List<String> mResidents;

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
