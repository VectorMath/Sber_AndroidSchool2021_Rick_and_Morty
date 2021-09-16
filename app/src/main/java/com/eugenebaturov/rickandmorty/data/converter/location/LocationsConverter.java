package com.eugenebaturov.rickandmorty.data.converter.location;

import androidx.annotation.NonNull;

import com.eugenebaturov.rickandmorty.data.converter.Converter;
import com.eugenebaturov.rickandmorty.models.data.LocationResponse;
import com.eugenebaturov.rickandmorty.models.data.list.ListLocationResponse;
import com.eugenebaturov.rickandmorty.models.domain.Location;

import java.util.ArrayList;
import java.util.List;

/**
 * Реализация {@link Converter}.
 * В качестве входящих данных принимает {@link ListLocationResponse}.
 * В качестве выходящих данных возвращает список {@link Location}.
 */
public final class LocationsConverter
        implements Converter<ListLocationResponse, List<Location>> {
    @NonNull
    @Override
    public List<Location> convert(@NonNull final ListLocationResponse from) {
        final List<Location> locations = new ArrayList<>();

        for (LocationResponse response : from.getLocations()) {
            final Location location = new Location(
                    response.getId(),
                    response.getName(),
                    response.getType(),
                    response.getDimension(),
                    response.getResidents()
            );
            locations.add(location);
        }

        return locations;
    }
}
