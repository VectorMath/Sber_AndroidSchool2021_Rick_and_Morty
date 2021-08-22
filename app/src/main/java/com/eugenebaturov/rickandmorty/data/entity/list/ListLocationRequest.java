package com.eugenebaturov.rickandmorty.data.entity.list;

import com.eugenebaturov.rickandmorty.data.entity.LocationRequest;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Objects;

/**
 * Класс-сущность, который хранит информацию о локациях мульт-сериала "Рик и Морти".
 * <p>
 * [mLocations] - список локаций {@link LocationRequest}
 */
public class ListLocationRequest {

    @SerializedName("results")
    private List<LocationRequest> mLocations;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListLocationRequest that = (ListLocationRequest) o;
        return Objects.equals(mLocations, that.mLocations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mLocations);
    }

    @Override
    public String toString() {
        return "ListLocationRequest{" +
                "mLocations=" + mLocations +
                '}';
    }

    public List<LocationRequest> getLocations() {
        return mLocations;
    }
}
