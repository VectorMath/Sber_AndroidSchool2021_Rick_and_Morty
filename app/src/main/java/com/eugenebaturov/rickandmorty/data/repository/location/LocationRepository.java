package com.eugenebaturov.rickandmorty.data.repository.location;

import com.eugenebaturov.rickandmorty.data.api.LocationApi;
import com.eugenebaturov.rickandmorty.data.repository.location.ILocationRepository;
import com.eugenebaturov.rickandmorty.domain.entity.Location;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;

/**
 * Класс-репозиторий, который является реализацией интерфейса {@link ILocationRepository}.
 */
public class LocationRepository implements ILocationRepository {

    private final LocationApi mLocationApi;

    /**
     * Конструктор класса, в который мы передаёт экземпляр Retrofit, чтобы была
     * возможность использовать публичные методы данного класса.
     *
     * @param retrofit - экземпляр Ретрофита, нужен, чтобы проинициализировать mLocationApi.
     */
    public LocationRepository(Retrofit retrofit) {
        mLocationApi = retrofit.create(LocationApi.class);
    }

    @Override
    public Call<List<Location>> getAllLocation() {
        return mLocationApi.getAllLocations();
    }

    @Override
    public Call<Location> getLocationById(int locationId) {
        return mLocationApi.getLocationById(locationId);
    }
}