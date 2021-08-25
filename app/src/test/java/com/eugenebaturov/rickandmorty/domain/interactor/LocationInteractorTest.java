package com.eugenebaturov.rickandmorty.domain.interactor;

import com.eugenebaturov.rickandmorty.data.repository.location.LocationRepository;
import com.eugenebaturov.rickandmorty.domain.interactor.location.LocationInteractor;
import com.eugenebaturov.rickandmorty.domain.interactor.location.LocationInteractorImpl;
import com.eugenebaturov.rickandmorty.models.domain.Location;
import com.google.common.truth.Truth;

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

/**
 * Юнит-тест для класса {@link LocationInteractorImpl}.
 */
@RunWith(MockitoJUnitRunner.class)
public class LocationInteractorTest {
    private static final int CORRECT_LOCATION_ID = 5;
    private static final int INCORRECT_LOCATION_ID = -51;

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
                Single.just(createTestLocations());
        Mockito.when(mLocationRepository.getLocationsFromServer()).thenReturn(expectedLocations);

        // Act
        Single<List<Location>> actual = mLocationInteractor.getLocationsFromRepository();

        // Assert
        Truth.assertThat(actual).isEqualTo(expectedLocations);
    }

    /**
     * Проверка на то, что если из репозитория ничего не придёт, мы получим null.
     */
    @Test
    public void testGetNullLocationsFromRepository() {
        // Arrange
        Mockito.when(mLocationRepository.getLocationsFromServer()).thenReturn(null);

        // Act
        Single<List<Location>> actual = mLocationInteractor.getLocationsFromRepository();

        // Assert
        Truth.assertThat(actual).isNull();
    }

    /**
     * Проверка на то, что при передаче правильного id, мы получим ожидаемую локацию из репозитория.
     */
    @Test
    public void testGetLocationFromRepositoryWithCorrectId() {
        // Arrange
        Single<Location> expectedLocation =
                Single.just(createLocation());
        Mockito.when(mLocationRepository.getLocationFromServer(CORRECT_LOCATION_ID))
                .thenReturn(expectedLocation);

        // Act
        Single<Location> actual =
                mLocationInteractor.getLocationFromRepository(CORRECT_LOCATION_ID);

        // Assert
        Truth.assertThat(actual).isEqualTo(expectedLocation);
    }

    @Test
    public void testGetNullLocationFromRepositoryWithIncorrectId() {
        // Arrange
        Mockito.when(mLocationRepository.getLocationFromServer(INCORRECT_LOCATION_ID))
                .thenReturn(null);

        // Act
        Single<Location> actual =
                mLocationInteractor.getLocationFromRepository(INCORRECT_LOCATION_ID);

        // Assert
        Truth.assertThat(actual).isNull();
    }

    private List<Location> createTestLocations() {
        List<Location> locations = new ArrayList<>();

        List<String> firstResidentsUrl = new ArrayList<>();
        firstResidentsUrl.add("https://rickandmortyapi.com/api/character/38");
        firstResidentsUrl.add("https://rickandmortyapi.com/api/character/31");
        firstResidentsUrl.add("https://rickandmortyapi.com/api/character/6");
        Location firstLocation = new Location(
                13,
                "Nuptia 4",
                "Planet",
                "unknown",
                firstResidentsUrl
        );

        List<String> secondResidentsUrl = new ArrayList<>();
        secondResidentsUrl.add("https://rickandmortyapi.com/api/character/18");
        secondResidentsUrl.add("https://rickandmortyapi.com/api/character/11");
        secondResidentsUrl.add("https://rickandmortyapi.com/api/character/5");
        Location secondLocation = new Location(
                1,
                "Earth",
                "Planet",
                "Dimension C-137",
                secondResidentsUrl
        );

        locations.add(firstLocation);
        locations.add(secondLocation);

        return locations;
    }

    private Location createLocation() {
        List<String> testResidentsUrl = new ArrayList<>();
        testResidentsUrl.add("https://rickandmortyapi.com/api/character/38");
        testResidentsUrl.add("https://rickandmortyapi.com/api/character/31");
        testResidentsUrl.add("https://rickandmortyapi.com/api/character/6");
        return new Location(
                13,
                "Nuptia 4",
                "Planet",
                "unknown",
                testResidentsUrl
        );
    }
}
