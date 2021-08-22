package com.eugenebaturov.rickandmorty.domain.interactor.location;

import com.eugenebaturov.rickandmorty.data.entity.LocationRequest;
import com.eugenebaturov.rickandmorty.data.repository.location.LocationRepository;

import java.io.IOException;
import java.util.List;

/**
 * Обрабатывает информацию о локации {@link LocationRequest},
 * которая приходит из репозитория {@link LocationRepository}.
 */
public interface LocationInteractor {

    /**
     * Получает список локаций из репозитория без Single обёртки.
     *
     * @return - список локаций.
     * @throws IOException экзепшен ввода-вывода.
     */
    List<LocationRequest> getAllLocationFromRepository() throws IOException;

    /**
     * Получает локацию по id из репозитория без Single обёртки.
     *
     * @param locationId - id локации.
     * @return локация с конкретным id.
     * @throws IOException экзепшен ввода-вывода.
     */
    LocationRequest getLocationByIdFromRepository(int locationId) throws IOException;
}
