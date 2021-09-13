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
    private final LocationRepository mLocationRepository;

    /**
     * Конструктор класса.
     *
     * @param locationRepository - экземпляр репозитория {@link LocationRepository}
     */
    public LocationInteractorImpl(@NonNull final LocationRepository locationRepository) {
        mLocationRepository = locationRepository;
    }

    @Override
    public @NonNull
    Single<List<Location>> getLocations() {
        return mLocationRepository.getLocations();
    }

    @Override
    public @NonNull
    Single<List<Location>> getLocations(@NonNull String query) {
        return mLocationRepository.getLocations(query);
    }

    @Override
    public @NonNull
    Single<Location> getLocationById(final int locationId) {
        return mLocationRepository.getLocationById(locationId);
    }
}
