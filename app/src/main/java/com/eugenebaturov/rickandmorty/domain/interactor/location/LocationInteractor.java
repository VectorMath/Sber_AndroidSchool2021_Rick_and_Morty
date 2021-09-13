package com.eugenebaturov.rickandmorty.domain.interactor.location;

import androidx.annotation.NonNull;

import com.eugenebaturov.rickandmorty.models.domain.Location;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

/**
 * Интерактор локаций.
 */
public interface LocationInteractor {

    /**
     * Получает список локаций.
     *
     * @return Список эпизодов [{@link List}<{@link Location}>] в {@link Single} обёртке.
     */
    @NonNull
    Single<List<Location>> getLocations();

    /**
     * Получает список локаций по заданному запросу из репозитория.
     *
     * @param query строка запроса
     * @return Список локаций [{@link List}<{@link Location}>] в {@link Single} обёртке.
     */
    @NonNull
    Single<List<Location>> getLocations(@NonNull final String query);

    /**
     * Получает локацию с конкретным id.
     *
     * @param locationId id локации.
     * @return Локация [{@link Location}] в {@link Single} обёртке.
     */
    @NonNull
    Single<Location> getLocationById(final int locationId);
}
