package com.eugenebaturov.rickandmorty.models.domain;

import com.eugenebaturov.rickandmorty.models.data.LocationResponse;

import java.util.List;
import java.util.Objects;

/**
 * Класс-сущность, которая обрабатывает данные из класса-сущности
 * {@link LocationResponse} в data-слое
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
     * @param locationResponse - моделька, которая получила данные с api.
     */
    public Location(LocationResponse locationResponse) {
        mId = locationResponse.getId();
        mName = locationResponse.getName();
        mType = locationResponse.getType();
        mDimension = locationResponse.getDimension();
        mResidents = locationResponse.getResidents();
    }

    /**
     * Конструктор класса в который мы вручную передаём информацию о локации.
     * @param mId id локации.
     * @param mName название локации.
     * @param mType тип локации.
     * @param mDimension измерение локации.
     * @param mResidents список персонажей, которые живут в данной локации.
     */
    public Location(
            int mId,
            String mName,
            String mType,
            String mDimension,
            List<String> mResidents) {
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
