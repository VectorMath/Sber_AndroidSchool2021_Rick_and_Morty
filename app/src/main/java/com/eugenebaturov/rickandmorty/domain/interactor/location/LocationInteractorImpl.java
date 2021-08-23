package com.eugenebaturov.rickandmorty.domain.interactor.location;

import com.eugenebaturov.rickandmorty.data.repository.location.LocationRepository;
import com.eugenebaturov.rickandmorty.models.domain.Location;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

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
    public Single<List<Location>> getLocationsFromRepository() {
        return mRepository.getLocationsFromServer();
    }

    @Override
    public Single<Location> getLocationFromRepository(int locationId) {
        return mRepository.getLocationFromServer(locationId);
    }
}
