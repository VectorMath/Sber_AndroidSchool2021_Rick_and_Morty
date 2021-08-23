package com.eugenebaturov.rickandmorty.data.repository.location;

import com.eugenebaturov.rickandmorty.data.api.LocationApi;
import com.eugenebaturov.rickandmorty.models.data.LocationResponse;
import com.eugenebaturov.rickandmorty.models.data.list.ListLocationResponse;
import com.eugenebaturov.rickandmorty.models.domain.Location;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

/**
 * Интерфейс, методы которого "дёргают" ручки в {@link LocationApi}.
 */
public interface LocationRepository {

    /**
     * Метод, который дергает ручку getAllLocation.
     *
     * @return локация в Single {@link Single} обёртке.
     */
    Single<List<Location>> getAllLocation();

    /**
     * Метод, который дергает ручку getLocationById.
     *
     * @param locationId - id локации.
     * @return локация в Single {@link Single} обёртке.
     */
    Single<Location> getLocationById(int locationId);
}
