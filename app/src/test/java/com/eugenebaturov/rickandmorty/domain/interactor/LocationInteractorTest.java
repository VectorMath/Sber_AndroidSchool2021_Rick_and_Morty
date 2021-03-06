package com.eugenebaturov.rickandmorty.domain.interactor;

import com.eugenebaturov.rickandmorty.data.repository.location.LocationRepository;
import com.eugenebaturov.rickandmorty.domain.interactor.location.LocationInteractor;
import com.eugenebaturov.rickandmorty.domain.interactor.location.LocationInteractorImpl;
import com.eugenebaturov.rickandmorty.models.domain.Location;
import com.eugenebaturov.rickandmorty.testdata.LocationTestData;
import com.google.common.truth.Truth;

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

import static org.mockito.Mockito.when;

/**
 * Юнит-тест для класса {@link LocationInteractorImpl}.
 */
@RunWith(MockitoJUnitRunner.class)
public class LocationInteractorTest {
    private static final int CORRECT_LOCATION_ID = 5;
    private static final int INCORRECT_LOCATION_ID = -51;
    private static final String LOCATION_NAME_QUERY = "Earth";
    private static final String INCORRECT_QUERY = "_3fFIK2F_JFK";

    private LocationRepository mLocationRepository;
    private LocationInteractor mLocationInteractor;

    @Rule
    public final MockitoRule mockitoRule = MockitoJUnit.rule();

    @Before
    public void setUp() {
        mLocationRepository = Mockito.mock(LocationRepository.class);
        mLocationInteractor = new LocationInteractorImpl(mLocationRepository);
    }

    /**
     * Проверка на то, что с репозитория приходит ожидаемый список локаций.
     */
    @Test
    public void testGetLocationsFromRepository() {
        // Arrange
        Single<List<Location>> expectedLocations =
                Single.just(LocationTestData.createLocations());
        Mockito.when(mLocationRepository.getLocations()).thenReturn(expectedLocations);

        // Act
        Single<List<Location>> actual = mLocationInteractor.getLocations();

        // Assert
        Truth.assertThat(actual).isEqualTo(expectedLocations);
    }

    /**
     * Проверка на то, что при конкретном запросе репозиторий выдаст нам нужную информацию
     * о локациях, которые соответствуют данному запросу.
     */
    @Test
    public void testGetSearchedLocationsFromRepository() {
        // Arrange
        Single<List<Location>> expected =
                Single.just(LocationTestData.createSearchedLocations());
        Mockito
                .when(mLocationRepository.getLocations(LOCATION_NAME_QUERY))
                .thenReturn(expected);

        // Act
        Single<List<Location>> actual =
                mLocationInteractor.getLocations(LOCATION_NAME_QUERY);

        // Assert
        Truth.assertThat(actual).isEqualTo(expected);
    }

    /**
     * Проверка на то, что если с репозитория придёт ошибка, мы получим {@link RuntimeException}
     */
    @Test
    public void testErrorFromRepository() {
        String EXPECTED_EXCEPTION_MESSAGE = "Repository Error!";
        when(mLocationRepository.getLocations())
                .thenThrow(new RuntimeException(EXPECTED_EXCEPTION_MESSAGE));

        try {
            mLocationInteractor.getLocations();
        } catch (RuntimeException e) {
            Assert.assertEquals(EXPECTED_EXCEPTION_MESSAGE, e.getMessage());
        }
    }

    @Test
    public void testGetSearchedErrorFromRepository() {
        String EXPECTED_EXCEPTION_MESSAGE = "Repository Error! Bad query...";
        when(mLocationRepository.getLocations(INCORRECT_QUERY))
                .thenThrow(new RuntimeException(EXPECTED_EXCEPTION_MESSAGE));

        try {
            mLocationInteractor.getLocations(INCORRECT_QUERY);
        } catch (RuntimeException exception) {
            Assert.assertEquals(EXPECTED_EXCEPTION_MESSAGE, exception.getMessage());
        }
    }

    /**
     * Проверка на то, что при передаче правильного id, мы получим ожидаемую локацию из репозитория.
     */
    @Test
    public void testGetLocationFromRepositoryWithCorrectId() {
        // Arrange
        Single<Location> expectedLocation =
                Single.just(LocationTestData.createLocation());
        Mockito.when(mLocationRepository.getLocationById(CORRECT_LOCATION_ID))
                .thenReturn(expectedLocation);

        // Act
        Single<Location> actual =
                mLocationInteractor.getLocationById(CORRECT_LOCATION_ID);

        // Assert
        Truth.assertThat(actual).isEqualTo(expectedLocation);
    }

    /**
     * Проверка на то, что с некорректным id локации, мы получим {@link RuntimeException}.
     */
    @Test
    public void testLocationIsNotExist() {
        // Arrange
        String EXPECTED_EXCEPTION_MESSAGE = "Repository Error! Location is not exist...";
        when(mLocationRepository.getLocationById(INCORRECT_LOCATION_ID))
                .thenThrow(new RuntimeException(EXPECTED_EXCEPTION_MESSAGE));

        try {
            mLocationInteractor.getLocationById(INCORRECT_LOCATION_ID);
        } catch (RuntimeException e) {
            Assert.assertEquals(EXPECTED_EXCEPTION_MESSAGE, e.getMessage());
        }
    }
}
