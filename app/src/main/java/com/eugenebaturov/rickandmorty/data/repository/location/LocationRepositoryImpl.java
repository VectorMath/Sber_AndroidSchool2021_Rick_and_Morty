package com.eugenebaturov.rickandmorty.data.repository.location;

import com.eugenebaturov.rickandmorty.data.api.LocationApi;
import com.eugenebaturov.rickandmorty.models.data.LocationRequest;
import com.eugenebaturov.rickandmorty.models.data.list.ListLocationRequest;

import io.reactivex.rxjava3.core.Single;
import retrofit2.Retrofit;

/**
 * Класс-репозиторий, который является реализацией интерфейса {@link LocationRepository}.
 */
public class LocationRepositoryImpl implements LocationRepository {

    private final LocationApi mLocationApi;

    /**
     * Конструктор класса, в который мы передаёт экземпляр Retrofit, чтобы была
     * возможность использовать публичные методы данного класса.
     *
     * @param retrofit - экземпляр Ретрофита, нужен, чтобы проинициализировать mLocationApi.
     */
    public LocationRepositoryImpl(Retrofit retrofit) {
        mLocationApi = retrofit.create(LocationApi.class);
    }

    @Override
    public Single<ListLocationRequest> getAllLocation() {
        return mLocationApi.getAllLocations();
    }

    @Override
    public Single<LocationRequest> getLocationById(int locationId) {
        return mLocationApi.getLocationById(locationId);
    }
}