package com.eugenebaturov.rickandmorty.domain.interactor.location;

import com.eugenebaturov.rickandmorty.models.data.LocationRequest;
import com.eugenebaturov.rickandmorty.data.repository.location.LocationRepository;
import com.eugenebaturov.rickandmorty.models.domain.Location;

import java.util.ArrayList;
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
    public List<Location> parseLocationsFromRepository() {
        List<LocationRequest> request = mRepository
                .getAllLocation()
                .blockingGet()
                .getLocations();
        List<Location> locations = new ArrayList<>();

        for (LocationRequest location : request) {
            locations.add(new Location(location));
        }

        return locations;
    }

    @Override
    public Location parseLocationByIdFromRepository(int locationId) {
        LocationRequest request = mRepository.getLocationById(locationId).blockingGet();
        return new Location(request);
    }
}
