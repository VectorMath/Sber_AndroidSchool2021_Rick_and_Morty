package com.eugenebaturov.rickandmorty.data.utils.location;

import androidx.annotation.NonNull;

import com.eugenebaturov.rickandmorty.data.utils.Converter;
import com.eugenebaturov.rickandmorty.models.data.LocationResponse;
import com.eugenebaturov.rickandmorty.models.domain.Location;

/**
 * Реализация {@link Converter}.
 * В качестве входящих данных принимает {@link LocationResponse}.
 * В качестве выходящих данных возвращает список {@link Location}.
 */
public final class LocationConverter implements Converter<LocationResponse, Location> {
    @Override
    @NonNull
    public Location convert(@NonNull final LocationResponse from) {
        return new Location(
                from.getId(),
                from.getName(),
                from.getType(),
                from.getDimension(),
                from.getResidents()
        );
    }
}
