package com.eugenebaturov.rickandmorty.domain.interactor.location;

import androidx.annotation.NonNull;

import com.eugenebaturov.rickandmorty.data.repository.location.LocationRepository;
import com.eugenebaturov.rickandmorty.models.domain.Location;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

/**
 * Реализация интерфейса {@link LocationInteractor}
 */
public final class LocationInteractorImpl implements LocationInteractor {

    @NonNull
    private final LocationRepository mRepository;

    /**
     * Конструктор класса.
     *
     * @param repository - экземпляр репозитория {@link LocationRepository}
     */
    public LocationInteractorImpl(@NonNull final LocationRepository repository) {
        mRepository = repository;
    }

    @Override
    public Single<List<Location>> getLocationsFromRepository() {
        return mRepository.getLocationsFromServer();
    }

    @Override
    public Single<Location> getLocationFromRepository(final int locationId) {
        return mRepository.getLocationFromServer(locationId);
    }
}
