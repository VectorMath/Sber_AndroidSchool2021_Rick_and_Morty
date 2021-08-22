package com.eugenebaturov.rickandmorty.domain.entity;

import com.eugenebaturov.rickandmorty.data.entity.LocationRequest;

import java.util.List;
import java.util.Objects;

/**
 * Класс-сущность, которая обрабатывает данные из класса-сущности
 * {@link LocationRequest} в data-слое
 */
public class Location {
    private final int mId;
    private final String mName;
    private final String mType;
    private final String mDimension;
    private final List<String> mResidents;

    /**
     * Конструктор класса
     *
     * @param locationRequest - моделька, которая получила данные с api.
     */
    public Location(LocationRequest locationRequest) {
        mId = locationRequest.getId();
        mName = locationRequest.getName();
        mType = locationRequest.getType();
        mDimension = locationRequest.getDimension();
        mResidents = locationRequest.getResidents();
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
