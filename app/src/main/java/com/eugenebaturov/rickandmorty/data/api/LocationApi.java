package com.eugenebaturov.rickandmorty.data.api;

import com.eugenebaturov.rickandmorty.models.data.LocationResponse;
import com.eugenebaturov.rickandmorty.models.data.list.ListLocationResponse;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

import static com.eugenebaturov.rickandmorty.data.api.RickAndMortyURL.LOCATIONS_URL;

/**
 * API которое позволяет получить информацию о {@link LocationResponse} с сервера.
 */
public interface LocationApi {

    /**
     * Ручка, которая получает информацию о всех локациях с сервера.
     *
     * @return Список локаций в {@link Single} обёртке.
     */
    @GET(LOCATIONS_URL)
    Single<ListLocationResponse> getAllLocations();

    /**
     * Ручка, которая получает информацию с сервера о локациях по поисковому запросу.
     *
     * @param queryName строка запроса.
     * @return Список данных об локациях в {@link Single} обёртке.
     */
    @GET(LOCATIONS_URL)
    Single<ListLocationResponse> getSearchedLocations(@Query("name") final String queryName);

    /**
     * Ручка, которая получает информацию о локации по id с сервера.
     *
     * @param locationId id локации.
     * @return Данные о локации в {@link Single} обёртке.
     */
    @GET(LOCATIONS_URL + "{id}")
    Single<LocationResponse> getLocationById(@Path("id") final int locationId);
}