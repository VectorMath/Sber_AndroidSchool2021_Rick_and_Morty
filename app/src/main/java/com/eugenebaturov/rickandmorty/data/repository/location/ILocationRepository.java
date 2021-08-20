package com.eugenebaturov.rickandmorty.data.repository.location;

import com.eugenebaturov.rickandmorty.data.api.LocationApi;
import com.eugenebaturov.rickandmorty.domain.entity.Location;

import java.util.List;

import retrofit2.Call;

/**
 * Интерфейс, методы которого "дёргают" ручки в {@link LocationApi}.
 */
public interface ILocationRepository {

    /**
     * Метод, который дергает ручку getAllLocation.
     *
     * @return локация в Call {@link Call} обёртке.
     */
    Call<List<Location>> getAllLocation();

    /**
     * Метод, который дергает ручку getLocationById.
     *
     * @param locationId - id локации.
     * @return локация в Call {@link Call} обёртке.
     */
    Call<Location> getLocationById(int locationId);
}
