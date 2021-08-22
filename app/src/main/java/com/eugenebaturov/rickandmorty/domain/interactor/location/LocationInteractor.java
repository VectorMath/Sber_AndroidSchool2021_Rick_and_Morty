package com.eugenebaturov.rickandmorty.domain.interactor.location;

import com.eugenebaturov.rickandmorty.models.data.LocationRequest;
import com.eugenebaturov.rickandmorty.data.repository.location.LocationRepository;
import com.eugenebaturov.rickandmorty.models.domain.Location;

import java.util.List;

/**
 * Обрабатывает информацию о локации {@link LocationRequest},
 * которая приходит из репозитория {@link LocationRepository}
 */
public interface LocationInteractor {

    /**
     * Получает обработанный список локаций из репозитория
     *
     * @return - список локаций
     */
    List<Location> parseLocationsFromRepository();

    /**
     * Получает обработанную локацию по id из репозитория
     *
     * @param locationId - id локации.
     * @return локация с конкретным id.
     */
    Location parseLocationByIdFromRepository(int locationId);
}
