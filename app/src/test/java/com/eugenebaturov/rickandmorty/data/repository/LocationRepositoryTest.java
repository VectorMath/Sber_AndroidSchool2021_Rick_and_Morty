package com.eugenebaturov.rickandmorty.data.repository;

import com.eugenebaturov.rickandmorty.data.api.LocationApi;
import com.eugenebaturov.rickandmorty.data.repository.location.LocationRepository;
import com.eugenebaturov.rickandmorty.data.repository.location.LocationRepositoryImpl;
import com.eugenebaturov.rickandmorty.models.data.EpisodeResponse;
import com.eugenebaturov.rickandmorty.models.data.LocationResponse;
import com.eugenebaturov.rickandmorty.models.data.list.ListLocationResponse;
import com.eugenebaturov.rickandmorty.models.domain.Episode;
import com.eugenebaturov.rickandmorty.models.domain.Location;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.core.Single;

import static org.mockito.Mockito.when;

/**
 * Юнит-тесты для класса {@link LocationRepositoryImpl}.
 */
@RunWith(MockitoJUnitRunner.class)
public class LocationRepositoryTest {
    private static final int CORRECT_LOCATION_ID = 3;
    private static final int INCORRECT_LOCATION_ID = -69;

    private LocationApi mLocationApi;
    private LocationRepository mLocationRepository;

    @Rule
    public final MockitoRule mockitoRule = MockitoJUnit.rule();

    @Before
    public void setUp() {
        mLocationApi = Mockito.mock(LocationApi.class);
        mLocationRepository = new LocationRepositoryImpl(mLocationApi);
    }

    /**
     * Проверка на то, что с сервера приходят данные о локациях в виде {@link ListLocationResponse},
     * и после обрабатываются в ожидаемый {@link List}<{@link Location}>.
     */
    @Test
    public void testGetLocationsFromServer() {
        // Arrange
        Single<ListLocationResponse> serverResponse =
                Single.just(createTestLocationResponse());
        when(mLocationApi.getAllLocations()).thenReturn(serverResponse);

        // Act
        Single<List<Location>> actual = mLocationRepository.getLocationsFromServer();
        List<Location> expected = createExpectedLocations();

        // Assert
        actual.test().assertValue(expected);
    }

    /**
     * Проверка на то, что если с сервера придёт null, мы получим {@link NullPointerException}
     */
    @Test(expected = NullPointerException.class)
    public void testGetNullLocationsFromServer() {
        // Arrange
        Single<ListLocationResponse> serverResponse =
                Single.just(null);
        when(mLocationApi.getAllLocations()).thenReturn(serverResponse);

        // Act
        mLocationRepository.getLocationsFromServer();
    }

    /**
     * Проверка на то, что с сервера придут нужные данные об локации
     * виде {@link LocationResponse}, и после мы обрабатываем в ожидаемый {@link Location}.
     */
    @Test
    public void testGetLocationWithCorrectId() {
        // Arrange
        Single<LocationResponse> serverResponse =
                Single.just(createLocationResponse());
        when(mLocationApi.getLocationById(CORRECT_LOCATION_ID)).thenReturn(serverResponse);

        // Act
        Single<Location> actual = mLocationRepository.getLocationFromServer(CORRECT_LOCATION_ID);
        Location expected = createExpectedLocation();

        // Assert
        actual.test().assertValue(expected);
    }

    /**
     * Проверка на то, что с некорректным id локации, мы получим {@link NullPointerException}.
     */
    @Test(expected = NullPointerException.class)
    public void testGetNullLocationWithIncorrectId() {
        // Arrange
        Single<LocationResponse> serverResponse =
                Single.just(null);
        when(mLocationApi.getLocationById(INCORRECT_LOCATION_ID)).thenReturn(serverResponse);

        // Act
        mLocationRepository.getLocationFromServer(INCORRECT_LOCATION_ID);
    }

    private ListLocationResponse createTestLocationResponse() {
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

    private List<Location> createExpectedLocations() {
        List<Location> locations = new ArrayList<>();

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

        locations.add(new Location(firstLocationResponse));
        locations.add(new Location(secondLocationResponse));

        return locations;
    }

    private LocationResponse createLocationResponse() {
        List<String> firstResidentsList = new ArrayList<>();
        firstResidentsList.add("https://rickandmortyapi.com/api/character/38");
        firstResidentsList.add("https://rickandmortyapi.com/api/character/13");
        firstResidentsList.add("https://rickandmortyapi.com/api/character/6");

        return new LocationResponse(
                CORRECT_LOCATION_ID,
                "Earth (C-137)",
                "Planet",
                "Dimension C-137",
                firstResidentsList
        );
    }

    private Location createExpectedLocation() {
        return new Location(createLocationResponse());
    }
}
