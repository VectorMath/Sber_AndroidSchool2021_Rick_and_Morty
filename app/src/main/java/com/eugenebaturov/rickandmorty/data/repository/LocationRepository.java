package com.eugenebaturov.rickandmorty.data.repository;

import com.eugenebaturov.rickandmorty.data.api.LocationApi;
import com.eugenebaturov.rickandmorty.domain.entity.Location;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;

public class LocationRepository {

    private final LocationApi mLocationApi;

    public LocationRepository(Retrofit retrofit) {
        mLocationApi = retrofit.create(LocationApi.class);
    }

    public Call<List<Location>> getAllLocation() {
        return mLocationApi.getAllLocations();
    }

    public Call<Location> getLocationById(int locationId) {
        return mLocationApi.getLocationById(locationId);
    }
}