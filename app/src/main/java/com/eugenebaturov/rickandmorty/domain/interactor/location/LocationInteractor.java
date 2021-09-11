package com.eugenebaturov.rickandmorty.domain.interactor.location;

import com.eugenebaturov.rickandmorty.data.repository.location.LocationRepository;
import com.eugenebaturov.rickandmorty.models.domain.Location;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

/**
 * Получает информацию из {@link LocationRepository}, чтобы после передать во view-слой.
 */
public interface LocationInteractor {

    /**
     * Получает список локаций.
     *
     * @return Список эпизодов [{@link List}<{@link Location}>] в {@link Single} обёртке.
     */
    Single<List<Location>> getLocationsFromRepository();

    /**
     * Получает локацию с конкретным id.
     *
     * @param locationId id локации.
     * @return Локация [{@link Location}] в {@link Single} обёртке.
     */
    Single<Location> getLocationFromRepository(final int locationId);
}
