package com.eugenebaturov.rickandmorty.data.repository.location;

import com.eugenebaturov.rickandmorty.data.api.LocationApi;
import com.eugenebaturov.rickandmorty.data.entity.LocationRequest;
import com.eugenebaturov.rickandmorty.data.entity.list.ListLocationRequest;

import retrofit2.Call;
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
    public Call<ListLocationRequest> getAllLocation() {
        return mLocationApi.getAllLocations();
    }

    @Override
    public Call<LocationRequest> getLocationById(int locationId) {
        return mLocationApi.getLocationById(locationId);
    }
}