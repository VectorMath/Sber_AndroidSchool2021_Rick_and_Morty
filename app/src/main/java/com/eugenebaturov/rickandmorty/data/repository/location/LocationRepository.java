package com.eugenebaturov.rickandmorty.data.repository.location;

import com.eugenebaturov.rickandmorty.data.api.LocationApi;
import com.eugenebaturov.rickandmorty.models.data.LocationResponse;
import com.eugenebaturov.rickandmorty.models.data.list.ListLocationResponse;
import com.eugenebaturov.rickandmorty.models.domain.Location;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

/**
 * Интерфейс, методы которого получают данные с сервера с помощью {@link LocationApi}.
 */
public interface LocationRepository {

    /**
     * Получает данные о всех локациях с сервера.
     *
     * @return Список локаций в {@link Single} обёртке.
     */
    Single<List<Location>> getLocationsFromServer();

    /**
     * Получает данные о локации с сервера.
     *
     * @param locationId id локации.
     * @return Локация в Single {@link Single} обёртке.
     */
    Single<Location> getLocationFromServer(final int locationId);
}
