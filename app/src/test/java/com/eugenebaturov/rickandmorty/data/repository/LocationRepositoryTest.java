package com.eugenebaturov.rickandmorty.data.repository;

import com.eugenebaturov.rickandmorty.data.api.LocationApi;
import com.eugenebaturov.rickandmorty.data.repository.location.LocationRepository;
import com.eugenebaturov.rickandmorty.data.repository.location.LocationRepositoryImpl;
import com.eugenebaturov.rickandmorty.models.data.LocationResponse;
import com.eugenebaturov.rickandmorty.models.data.list.ListLocationResponse;
import com.eugenebaturov.rickandmorty.models.domain.Location;
import com.eugenebaturov.rickandmorty.testdata.LocationTestData;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

import static com.eugenebaturov.rickandmorty.testdata.LocationTestData.createListResponse;
import static com.eugenebaturov.rickandmorty.testdata.LocationTestData.createLocation;
import static com.eugenebaturov.rickandmorty.testdata.LocationTestData.createLocations;
import static com.eugenebaturov.rickandmorty.testdata.LocationTestData.createResponse;
import static org.mockito.Mockito.when;

/**
 * Юнит-тесты для класса {@link LocationRepositoryImpl}.
 */
@RunWith(MockitoJUnitRunner.class)
public class LocationRepositoryTest {
    private static final int CORRECT_LOCATION_ID = 3;
    private static final int INCORRECT_LOCATION_ID = -69;
    private static final String LOCATION_NAME_QUERY = "Earth";
    private static final String INCORRECT_QUERY = "_3fFIK2F_JFK";

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
                Single.just(createListResponse());
        when(mLocationApi.getAllLocations()).thenReturn(serverResponse);

        // Act
        Single<List<Location>> actual = mLocationRepository.getLocations();
        List<Location> expected = createLocations();

        // Assert
        actual.test().assertValue(expected);
    }

    /**
     * Проверка на то, что при конкретном запросе(query)
     * с сервера приходят нужные данные в виде {@link ListLocationResponse}
     * и после они обрабатываются в ожидаемый {@link List}<{@link Location}>.
     */
    @Test
    public void testGetSearchedLocationsFromServer() {
        // Arrange
        Single<ListLocationResponse> serverResponse =
                Single.just(LocationTestData.createSearchedResponse());
        Mockito
                .when(mLocationApi.getSearchedLocations(LOCATION_NAME_QUERY))
                .thenReturn(serverResponse);

        // Act
        List<Location> excepted = LocationTestData.createSearchedLocations();
        Single<List<Location>> actual =
                mLocationRepository.getLocations(LOCATION_NAME_QUERY);

        // Assert
        actual.test().assertValue(excepted);
    }

    /**
     * Проверка на то, что если с сервера придёт ошибка, мы получим {@link RuntimeException}
     */
    @Test
    public void testErrorFromServer() {
        String EXPECTED_EXCEPTION_MESSAGE = "Server Error!";
        when(mLocationApi.getAllLocations())
                .thenThrow(new RuntimeException(EXPECTED_EXCEPTION_MESSAGE));

        try {
            mLocationRepository.getLocations();
        } catch (RuntimeException e) {
            Assert.assertEquals(EXPECTED_EXCEPTION_MESSAGE, e.getMessage());
        }
    }

    /**
     * Проверка на то, что при некорретном запросе мы получим {@link RuntimeException}.
     */
    @Test
    public void testGetSearchedErrorFromServer() {
        String EXPECTED_EXCEPTION_MESSAGE = "Server Error! Nothing found...";
        Mockito
                .when(mLocationApi.getSearchedLocations(INCORRECT_QUERY))
                .thenThrow(new RuntimeException(EXPECTED_EXCEPTION_MESSAGE));

        try {
            mLocationRepository.getLocations(INCORRECT_QUERY);
        } catch (RuntimeException exception) {
            Assert.assertEquals(EXPECTED_EXCEPTION_MESSAGE, exception.getMessage());
        }
    }

    /**
     * Проверка на то, что с сервера придут нужные данные об локации
     * виде {@link LocationResponse}, и после мы обрабатываем в ожидаемый {@link Location}.
     */
    @Test
    public void testGetLocationWithCorrectId() {
        // Arrange
        Single<LocationResponse> serverResponse =
                Single.just(createResponse());
        when(mLocationApi.getLocationById(CORRECT_LOCATION_ID)).thenReturn(serverResponse);

        // Act
        Single<Location> actual = mLocationRepository.getLocationById(CORRECT_LOCATION_ID);
        Location expected = createLocation();

        // Assert
        actual.test().assertValue(expected);
    }

    /**
     * Проверка на то, что с некорректным id локации, мы получим {@link RuntimeException}.
     */
    @Test
    public void testLocationIsNotExist() {
        // Arrange
        String EXPECTED_EXCEPTION_MESSAGE = "Server Error! Location is not exist...";
        when(mLocationApi.getLocationById(INCORRECT_LOCATION_ID))
                .thenThrow(new RuntimeException(EXPECTED_EXCEPTION_MESSAGE));

        try {
            mLocationRepository.getLocationById(INCORRECT_LOCATION_ID);
        } catch (RuntimeException e) {
            Assert.assertEquals(EXPECTED_EXCEPTION_MESSAGE, e.getMessage());
        }
    }
}
