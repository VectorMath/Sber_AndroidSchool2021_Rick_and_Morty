package com.eugenebaturov.rickandmorty.data.repository.location;

import com.eugenebaturov.rickandmorty.data.api.LocationApi;
import com.eugenebaturov.rickandmorty.data.entity.LocationRequest;
import com.eugenebaturov.rickandmorty.data.entity.list.ListLocationRequest;

import io.reactivex.rxjava3.core.Single;
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
    Single<ListLocationRequest> getAllLocation();

    /**
     * Метод, который дергает ручку getLocationById.
     *
     * @param locationId - id локации.
     * @return локация в Call {@link Call} обёртке.
     */
    Single<LocationRequest> getLocationById(int locationId);
}
