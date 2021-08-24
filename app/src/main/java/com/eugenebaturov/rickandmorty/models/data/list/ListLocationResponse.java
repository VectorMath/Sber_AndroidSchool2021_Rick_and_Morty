package com.eugenebaturov.rickandmorty.models.data.list;

import com.eugenebaturov.rickandmorty.models.data.LocationResponse;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Objects;

/**
 * Класс-сущность, который хранит информацию о локациях мульт-сериала "Рик и Морти".
 * <p>
 * [mLocations] - список локаций {@link LocationResponse}
 */
public class ListLocationResponse {

    @SerializedName("results")
    private List<LocationResponse> mLocations;

    /**
     * Пустой конструктор класса.
     */
    public ListLocationResponse() {

    }

    /**
     * Конструктор класса в который мы передаём информацию о локация, полученную с сервера.
     * @param mLocations список локаций.
     */
    public ListLocationResponse(List<LocationResponse> mLocations) {
        this.mLocations = mLocations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListLocationResponse that = (ListLocationResponse) o;
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

    public List<LocationResponse> getLocations() {
        return mLocations;
    }
}
