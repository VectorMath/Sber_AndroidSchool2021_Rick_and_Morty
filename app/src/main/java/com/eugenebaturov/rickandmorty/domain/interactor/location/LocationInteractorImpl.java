package com.eugenebaturov.rickandmorty.domain.interactor.location;

import com.eugenebaturov.rickandmorty.data.entity.LocationRequest;
import com.eugenebaturov.rickandmorty.data.repository.location.LocationRepository;

import java.io.IOException;
import java.util.List;

public class LocationInteractorImpl implements LocationInteractor {

    private final LocationRepository mRepository;

    public LocationInteractorImpl(LocationRepository repository) {
        mRepository = repository;
    }

    @Override
    public List<LocationRequest> getAllLocationFromRepository() throws IOException {
        return mRepository.getAllLocation().execute().body().getLocations();
    }

    @Override
    public LocationRequest getLocationByIdFromRepository(int locationId) throws IOException {
        return mRepository.getLocationById(locationId).execute().body();
    }
}
