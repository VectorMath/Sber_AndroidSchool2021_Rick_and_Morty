package com.eugenebaturov.rickandmorty.data.api;

import com.eugenebaturov.rickandmorty.domain.entity.Location;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import static com.eugenebaturov.rickandmorty.data.api.RickAndMortyURL.LOCATIONS_URL;

/**
 * API которое позволяет получить информацию о локациях {@link Location} с сервера.
 */
public interface LocationApi {

    /**
     * Ручка, которая получает информацию о всех локациях с сервера.
     *
     * @return Список локаций в Call {@link Call} обёртке.
     */
    @GET(LOCATIONS_URL)
    Call<List<Location>> getAllLocations();

    /**
     * Ручка, которая получает информацию о локации по id с сервера.
     *
     * @param locationId - id локации.
     * @return локация в Call {@link Call} обёртке.
     */
    @GET(LOCATIONS_URL + "{id}")
    Call<Location> getLocationById(@Path("id") int locationId);
}