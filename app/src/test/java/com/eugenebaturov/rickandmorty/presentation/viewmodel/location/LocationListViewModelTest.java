package com.eugenebaturov.rickandmorty.presentation.viewmodel.location;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.Observer;

import com.eugenebaturov.rickandmorty.domain.interactor.location.LocationInteractor;
import com.eugenebaturov.rickandmorty.models.domain.Location;
import com.eugenebaturov.rickandmorty.testdata.LocationTestData;
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

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;

/**
 * Unit-test для {@link LocationListViewModel}
 */
@RunWith(MockitoJUnitRunner.class)
public class LocationListViewModelTest {
    private static final String LOCATION_NAME_QUERY = "Earth";
    private static final String INCORRECT_QUERY = "_3fFIK2F_JFK";

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

    @Mock
    private Observer<Throwable> mSearchError;

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
        mLocationListViewModel
                .getSearchError().observeForever(mSearchError);
    }

    /**
     * Проверка на то, что после подписки мы получим ожидаемые тестовые данные о локациях.
     */
    @Test
    public void testLoadLocations() {
        // Arrange
        Mockito
                .when(mLocationInteractor.getLocations())
                .thenReturn(Single.just(LocationTestData.createLocations()));

        // Act
        mLocationListViewModel.loadLocations();
        InOrder inOrder = Mockito.inOrder(mError, mLocations, mProgress);

        // Assert
        inOrder.verify(mProgress).onChanged(true);
        inOrder.verify(mLocations).onChanged(LocationTestData.createLocations());
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
                .when(mLocationInteractor.getLocations())
                .thenReturn(Single.error(new IllegalAccessException()));

        // Act
        mLocationListViewModel.loadLocations();

        // Assert
        Mockito.verify(mError).onChanged(ArgumentMatchers.isA(IllegalAccessException.class));
    }

    /**
     * Проверка на то, что после подписки мы получим ожидаемые тестовые данные о локациях.
     */
    @Test
    public void testLoadLocationsWithQuery() {
        // Arrange
        Mockito
                .when(mLocationInteractor.getLocations(LOCATION_NAME_QUERY))
                .thenReturn(Single.just(LocationTestData.createSearchedLocations()));

        // Act
        mLocationListViewModel.loadLocations(LOCATION_NAME_QUERY);
        InOrder inOrder = Mockito.inOrder(mSearchError, mLocations, mProgress);

        // Assert
        inOrder.verify(mProgress).onChanged(true);
        inOrder.verify(mLocations).onChanged(LocationTestData.createSearchedLocations());
        inOrder.verify(mProgress).onChanged(false);
        inOrder.verifyNoMoreInteractions();
    }

    /**
     * Проверка на то, что если интерактор вернёт {@link IllegalAccessException},
     * то и наша вью-моделька получит её.
     */
    @Test
    public void testLoadSearchedLocationsWithError() {
        // Arrange
        Mockito
                .when(mLocationInteractor.getLocations(INCORRECT_QUERY))
                .thenReturn(Single.error(new IllegalAccessException()));

        // Act
        mLocationListViewModel.loadLocations(INCORRECT_QUERY);

        // Assert
        Mockito.verify(mSearchError).onChanged(ArgumentMatchers.isA(IllegalAccessException.class));
    }
}
