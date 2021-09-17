package com.eugenebaturov.rickandmorty.models.domain;

import androidx.annotation.NonNull;

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
    private final List<String> mResidentsUrl;

    /**
     * Конструктор класса в который мы вручную передаём информацию о локации.
     *
     * @param id           id локации.
     * @param name         название локации.
     * @param type         тип локации.
     * @param dimension    измерение локации.
     * @param residentsUrl url-список персонажей, которые живут в данной локации.
     */
    public Location(
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
        Location location = (Location) o;
        return mId == location.mId &&
                Objects.equals(mName, location.mName) &&
                Objects.equals(mType, location.mType) &&
                Objects.equals(mDimension, location.mDimension) &&
                Objects.equals(mResidentsUrl, location.mResidentsUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mId, mName, mType, mDimension, mResidentsUrl);
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
