package com.eugenebaturov.rickandmorty.domain.interactor.location;

import com.eugenebaturov.rickandmorty.data.entity.LocationRequest;
import com.eugenebaturov.rickandmorty.data.repository.location.LocationRepository;

import java.io.IOException;
import java.util.List;

/**
 * Реализация интерфейса {@link LocationInteractor}
 */
public class LocationInteractorImpl implements LocationInteractor {

    private final LocationRepository mRepository;

    /**
     * Конструктор класса.
     *
     * @param repository - экземпляр интрефейса-репозитория {@link LocationRepository}
     */
    public LocationInteractorImpl(LocationRepository repository) {
        mRepository = repository;
    }

    @Override
    public List<LocationRequest> getAllLocationFromRepository() throws IOException {
        return mRepository.getAllLocation().blockingGet().getLocations();
    }

    @Override
    public LocationRequest getLocationByIdFromRepository(int locationId) throws IOException {
        return mRepository.getLocationById(locationId).blockingGet();
    }
}