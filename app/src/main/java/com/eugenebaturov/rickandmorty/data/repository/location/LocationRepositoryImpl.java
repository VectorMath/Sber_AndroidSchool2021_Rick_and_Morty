package com.eugenebaturov.rickandmorty.data.repository.location;

import androidx.annotation.NonNull;

import com.eugenebaturov.rickandmorty.data.api.LocationApi;
import com.eugenebaturov.rickandmorty.data.converter.Converter;
import com.eugenebaturov.rickandmorty.data.converter.location.LocationConverter;
import com.eugenebaturov.rickandmorty.data.converter.location.LocationsConverter;
import com.eugenebaturov.rickandmorty.models.data.LocationResponse;
import com.eugenebaturov.rickandmorty.models.data.list.ListLocationResponse;
import com.eugenebaturov.rickandmorty.models.domain.Location;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

/**
 * Реализация {@link LocationRepository}.
 */
public final class LocationRepositoryImpl implements LocationRepository {

    @NonNull
    private final LocationApi mLocationApi;

    /**
     * Конструктор класса.
     *
     * @param locationApi экземпляр {@link LocationApi}.
     */
    public LocationRepositoryImpl(@NonNull final LocationApi locationApi) {
        mLocationApi = locationApi;
    }

    @Override
    public @NonNull
    Single<List<Location>> getLocations() {
        final Converter<ListLocationResponse, List<Location>> mConverter =
                new LocationsConverter();
        return mLocationApi.getAllLocations().map(mConverter::convert);
    }

    @Override
    public @NonNull
    Single<List<Location>> getLocations(@NonNull String query) {
        final Converter<ListLocationResponse, List<Location>> mConverter =
                new LocationsConverter();
        return mLocationApi.getSearchedLocations(query).map(mConverter::convert);
    }

    @Override
    public @NonNull
    Single<Location> getLocationById(final int locationId) {
        final Converter<LocationResponse, Location> mConverter =
                new LocationConverter();
        return mLocationApi.getLocationById(locationId).map(mConverter::convert);
    }
}