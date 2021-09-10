package com.eugenebaturov.rickandmorty.testdata;

import com.eugenebaturov.rickandmorty.models.data.LocationResponse;
import com.eugenebaturov.rickandmorty.models.data.list.ListLocationResponse;
import com.eugenebaturov.rickandmorty.models.domain.Location;

import java.util.ArrayList;
import java.util.List;

/**
 * Создаёт тестовые данные об локации/локаций для unit-тестов.
 */
public class LocationTestData {

    public static ListLocationResponse createListResponse() {
        List<LocationResponse> locations = new ArrayList<>();

        List<String> firstResidentsList = new ArrayList<>();
        firstResidentsList.add("https://rickandmortyapi.com/api/character/38");
        firstResidentsList.add("https://rickandmortyapi.com/api/character/13");
        firstResidentsList.add("https://rickandmortyapi.com/api/character/6");

        List<String> secondResidentsList = new ArrayList<>();
        secondResidentsList.add("https://rickandmortyapi.com/api/character/6");

        LocationResponse firstLocationResponse = new LocationResponse(
                1,
                "Earth (C-137)",
                "Planet",
                "Dimension C-137",
                firstResidentsList
        );

        LocationResponse secondLocationResponse = new LocationResponse(
                2,
                "Abadango",
                "Cluster",
                "unknown",
                secondResidentsList
        );

        locations.add(firstLocationResponse);
        locations.add(secondLocationResponse);

        return new ListLocationResponse(locations);
    }

    public static List<Location> createLocations() {
        List<Location> locations = new ArrayList<>();

        List<String> firstResidentsList = new ArrayList<>();
        firstResidentsList.add("https://rickandmortyapi.com/api/character/38");
        firstResidentsList.add("https://rickandmortyapi.com/api/character/13");
        firstResidentsList.add("https://rickandmortyapi.com/api/character/6");

        List<String> secondResidentsList = new ArrayList<>();
        secondResidentsList.add("https://rickandmortyapi.com/api/character/6");

        Location firstLocationResponse = new Location(
                1,
                "Earth (C-137)",
                "Planet",
                "Dimension C-137",
                firstResidentsList
        );

        Location secondLocationResponse = new Location(
                2,
                "Abadango",
                "Cluster",
                "unknown",
                secondResidentsList
        );

        locations.add(firstLocationResponse);
        locations.add(secondLocationResponse);

        return locations;
    }

    public static LocationResponse createResponse() {
        List<String> firstResidentsList = new ArrayList<>();
        firstResidentsList.add("https://rickandmortyapi.com/api/character/38");
        firstResidentsList.add("https://rickandmortyapi.com/api/character/13");
        firstResidentsList.add("https://rickandmortyapi.com/api/character/6");

        return new LocationResponse(
                1,
                "Earth (C-137)",
                "Planet",
                "Dimension C-137",
                firstResidentsList
        );
    }

    public static Location createLocation() {
        List<String> firstResidentsList = new ArrayList<>();
        firstResidentsList.add("https://rickandmortyapi.com/api/character/38");
        firstResidentsList.add("https://rickandmortyapi.com/api/character/13");
        firstResidentsList.add("https://rickandmortyapi.com/api/character/6");

        return new Location(
                1,
                "Earth (C-137)",
                "Planet",
                "Dimension C-137",
                firstResidentsList
        );
    }
}
