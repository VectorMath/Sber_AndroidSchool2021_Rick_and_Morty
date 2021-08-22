package com.eugenebaturov.rickandmorty.data.repository.location;

import com.eugenebaturov.rickandmorty.data.api.LocationApi;
import com.eugenebaturov.rickandmorty.data.entity.LocationRequest;
import com.eugenebaturov.rickandmorty.data.entity.list.ListLocationRequest;

import java.util.List;

import retrofit2.Call;

/**
 * Интерфейс, методы которого "дёргают" ручки в {@link LocationApi}.
 */
public interface LocationRepository {

    /**
     * Метод, который дергает ручку getAllLocation.
     *
     * @return локация в Call {@link Call} обёртке.
     */
    Call<ListLocationRequest> getAllLocation();

    /**
     * Метод, который дергает ручку getLocationById.
     *
     * @param locationId - id локации.
     * @return локация в Call {@link Call} обёртке.
     */
    Call<LocationRequest> getLocationById(int locationId);
}
