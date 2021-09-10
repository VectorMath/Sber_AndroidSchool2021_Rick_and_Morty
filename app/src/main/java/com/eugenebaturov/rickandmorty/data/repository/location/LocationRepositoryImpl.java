package com.eugenebaturov.rickandmorty.data.repository.location;

import androidx.annotation.NonNull;

import com.eugenebaturov.rickandmorty.data.api.LocationApi;
import com.eugenebaturov.rickandmorty.data.utils.Converter;
import com.eugenebaturov.rickandmorty.models.data.LocationResponse;
import com.eugenebaturov.rickandmorty.models.domain.Location;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.core.Single;
import retrofit2.Retrofit;

/**
 * Класс-репозиторий, который является реализацией интерфейса {@link LocationRepository}.
 */
public final class LocationRepositoryImpl implements LocationRepository {

    @NonNull
    private final LocationApi mLocationApi;

    /**
     * Конструктор класса, в который мы передаём {@link LocationApi}, чтобы была
     * возможность получить данные с сервера.
     *
     * @param locationApi экземпляр {@link LocationApi},
     *                    для его создания требуется {@link Retrofit}.
     */
    public LocationRepositoryImpl(@NonNull final LocationApi locationApi) {
        mLocationApi = locationApi;
    }

    @Override
    public Single<List<Location>> getLocationsFromServer() {
        return mLocationApi.getAllLocations().map(Converter::convertLocations);
    }

    @Override
    public Single<Location> getLocationFromServer(final int locationId) {
        return mLocationApi.getLocationById(locationId).map(Converter::convertLocation);
    }
}