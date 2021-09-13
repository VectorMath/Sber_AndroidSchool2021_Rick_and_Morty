package com.eugenebaturov.rickandmorty.data.repository.location;

import androidx.annotation.NonNull;

import com.eugenebaturov.rickandmorty.models.domain.Location;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

/**
 * Репозиторий для получения локаций.
 */
public interface LocationRepository {

    /**
     * Получает данные о всех локациях.
     *
     * @return Список локаций в {@link Single} обёртке.
     */
    @NonNull
    Single<List<Location>> getLocations();

    /**
     * Получает данные об локациях, которые удоволетворяют строке запроса.
     *
     * @param query строка запроса.
     * @return Список локаций в {@link Single} обёртке.
     */
    @NonNull
    Single<List<Location>> getLocations(@NonNull final String query);

    /**
     * Получает данные о локации с конкретным id.
     *
     * @param locationId id локации.
     * @return Локация в Single {@link Single} обёртке.
     */
    @NonNull
    Single<Location> getLocationById(final int locationId);
}
