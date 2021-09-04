package com.eugenebaturov.rickandmorty.presentation.viewmodel.location;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.Observer;

import com.eugenebaturov.rickandmorty.domain.interactor.location.LocationInteractor;
import com.eugenebaturov.rickandmorty.models.data.LocationResponse;
import com.eugenebaturov.rickandmorty.models.domain.Location;
import com.eugenebaturov.rickandmorty.utils.SchedulerProvider;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;

/**
 * Unit-test для {@link LocationListViewModel}
 */
@RunWith(MockitoJUnitRunner.class)
public class LocationListViewModelTest {

    @Mock
    private SchedulerProvider mSchedulerProvider;

    @Mock
    private LocationInteractor mLocationInteractor;

    @Mock
    private Observer<List<Location>> mLocations;

    @Mock
    private Observer<Boolean> mProgress;

    @Mock
    private Observer<Throwable> mError;

    private LocationListViewModel mLocationListViewModel;


    @Rule
    public final InstantTaskExecutorRule mRule = new InstantTaskExecutorRule();

    @Before
    public void setUp() {
        Mockito.when(mSchedulerProvider.io()).thenReturn(Schedulers.trampoline());
        Mockito.when(mSchedulerProvider.ui()).thenReturn(Schedulers.trampoline());

        mLocationListViewModel =
                new LocationListViewModel(mSchedulerProvider, mLocationInteractor);

        mLocationListViewModel
                .getLocations().observeForever(mLocations);
        mLocationListViewModel
                .getError().observeForever(mError);
        mLocationListViewModel
                .getProgress().observeForever(mProgress);
    }

    /**
     * Проверка на то, что после подписки мы получим ожидаемые тестовые данные о локациях.
     */
    @Test
    public void testLoadLocations() {
        // Arrange
        Mockito
                .when(mLocationInteractor.getLocationsFromRepository())
                .thenReturn(Single.just(createTestData()));

        // Act
        mLocationListViewModel.loadLocations();

        // Assert
        Mockito.verify(mLocations).onChanged(createTestData());
    }

    /**
     * Проверка на то, что методы вызывутся в нужном порядке.
     */
    @Test
    public void testLoadLocationsInOrder() {
        // Arrange
        Mockito
                .when(mLocationInteractor.getLocationsFromRepository())
                .thenReturn(Single.just(createTestData()));

        // Act
        mLocationListViewModel.loadLocations();
        InOrder inOrder = Mockito.inOrder(mError, mLocations, mProgress);

        // Assert
        inOrder.verify(mProgress).onChanged(true);
        inOrder.verify(mLocations).onChanged(createTestData());
        inOrder.verify(mProgress).onChanged(false);
        inOrder.verifyNoMoreInteractions();
    }

    /**
     * Проверка на то, что если интерактор вернёт {@link IllegalAccessException},
     * то и наша вью-моделька получит её.
     */
    @Test
    public void testLoadLocationsWithError() {
        // Arrange
        Mockito
                .when(mLocationInteractor.getLocationsFromRepository())
                .thenReturn(Single.error(new IllegalAccessException()));

        // Act
        mLocationListViewModel.loadLocations();

        // Assert
        Mockito.verify(mError).onChanged(ArgumentMatchers.isA(IllegalAccessException.class));
    }

    private List<Location> createTestData() {
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
}
