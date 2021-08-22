package com.eugenebaturov.rickandmorty.data.api;

import com.eugenebaturov.rickandmorty.data.entity.LocationRequest;
import com.eugenebaturov.rickandmorty.data.entity.list.ListLocationRequest;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import static com.eugenebaturov.rickandmorty.data.api.RickAndMortyURL.LOCATIONS_URL;

/**
 * API которое позволяет получить информацию о локациях {@link LocationRequest} с сервера.
 */
public interface LocationApi {

    /**
     * Ручка, которая получает информацию о всех локациях с сервера.
     *
     * @return Список локаций в Call {@link Call} обёртке.
     */
    @GET(LOCATIONS_URL)
    Single<ListLocationRequest> getAllLocations();

    /**
     * Ручка, которая получает информацию о локации по id с сервера.
     *
     * @param locationId - id локации.
     * @return локация в Call {@link Call} обёртке.
     */
    @GET(LOCATIONS_URL + "{id}")
    Single<LocationRequest> getLocationById(@Path("id") int locationId);
}