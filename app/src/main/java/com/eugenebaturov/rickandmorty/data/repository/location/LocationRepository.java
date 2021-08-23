package com.eugenebaturov.rickandmorty.data.repository.location;

import com.eugenebaturov.rickandmorty.data.api.EpisodeApi;
import com.eugenebaturov.rickandmorty.data.api.LocationApi;
import com.eugenebaturov.rickandmorty.models.data.EpisodeResponse;
import com.eugenebaturov.rickandmorty.models.data.LocationResponse;
import com.eugenebaturov.rickandmorty.models.data.list.ListEpisodeResponse;
import com.eugenebaturov.rickandmorty.models.data.list.ListLocationResponse;
import com.eugenebaturov.rickandmorty.models.domain.Episode;
import com.eugenebaturov.rickandmorty.models.domain.Location;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

/**
 * Интерфейс, методы которого получают данные с сервера с помощью {@link LocationApi}
 * в виде {@link LocationResponse}, а после форматируют это в {@link Location}
 */
public interface LocationRepository {

    /**
     * Получает данные о всех локациях с сервера в виде {@link ListLocationResponse}, а после
     * форматирует их в {@link List}<{@link Location}>.
     *
     * @return список локаций в {@link Single} обёртке.
     */
    Single<List<Location>> getLocationsFromServer();

    /**
     * Получает данные о локации с сервера в виде {@link LocationResponse}, а после
     * форматирует их в {@link Location}.
     *
     * @param locationId id локации.
     * @return локация в Single {@link Single} обёртке.
     */
    Single<Location> getLocationFromServer(int locationId);
}
