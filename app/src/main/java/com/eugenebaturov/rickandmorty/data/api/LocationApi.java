package com.eugenebaturov.rickandmorty.data.api;

import com.eugenebaturov.rickandmorty.domain.entity.Location;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import static com.eugenebaturov.rickandmorty.data.api.RickAndMortyURL.LOCATIONS_URL;

public interface LocationApi {

    @GET(LOCATIONS_URL)
    Call<List<Location>> getAllLocations();

    @GET(LOCATIONS_URL + "{id}")
    Call<Location> getLocationById(@Path("id") int locationId);
}