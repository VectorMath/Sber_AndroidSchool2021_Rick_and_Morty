package com.eugenebaturov.rickandmorty.domain.interactor.location;

import com.eugenebaturov.rickandmorty.models.data.LocationResponse;
import com.eugenebaturov.rickandmorty.data.repository.location.LocationRepository;
import com.eugenebaturov.rickandmorty.models.domain.Location;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

/**
 * Обрабатывает информацию о локации {@link LocationResponse},
 * которая приходит из репозитория {@link LocationRepository}
 */
public interface LocationInteractor {

    /**
     * Получает обработанный список локаций из репозитория
     *
     * @return - список локаций
     */
    Single<List<Location>> parseLocationsFromRepository();

    /**
     * Получает обработанную локацию по id из репозитория
     *
     * @param locationId - id локации.
     * @return локация с конкретным id.
     */
    Single<Location> parseLocationByIdFromRepository(int locationId);
}
