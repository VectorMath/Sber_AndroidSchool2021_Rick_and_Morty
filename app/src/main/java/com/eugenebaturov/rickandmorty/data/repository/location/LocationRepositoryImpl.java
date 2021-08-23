package com.eugenebaturov.rickandmorty.data.repository.location;

import com.eugenebaturov.rickandmorty.data.api.CharacterApi;
import com.eugenebaturov.rickandmorty.data.api.LocationApi;
import com.eugenebaturov.rickandmorty.models.data.LocationResponse;
import com.eugenebaturov.rickandmorty.models.domain.Location;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.core.Single;
import retrofit2.Retrofit;

/**
 * Класс-репозиторий, который является реализацией интерфейса {@link LocationRepository}.
 */
public class LocationRepositoryImpl implements LocationRepository {

    private final LocationApi mLocationApi;

    /**
     * Конструктор класса, в который мы передаём {@link LocationApi}, чтобы была
     * возможность получить данные с сервера.
     *
     * @param locationApi экземпляр {@link LocationApi},
     *                    для его создания требуется {@link Retrofit}.
     */
    public LocationRepositoryImpl(LocationApi locationApi) {
        mLocationApi = locationApi;
    }

    @Override
    public Single<List<Location>> getLocationsFromServer() {

        return mLocationApi.getAllLocations().map(response -> {
            List<Location> locations = new ArrayList<>();

            for (LocationResponse location : response.getLocations()) {
                locations.add(new Location(location));
            }

            return locations;
        });
    }

    @Override
    public Single<Location> getLocationFromServer(int locationId) {
        return mLocationApi.getLocationById(locationId).map(Location::new);
    }
}