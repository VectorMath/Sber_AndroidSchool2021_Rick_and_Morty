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

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;

/**
 * Unit-test для {@link LocationViewModel}.
 */
@RunWith(MockitoJUnitRunner.class)
public class LocationViewModelTest {
    private final static int CORRECT_ID = 11;
    private final static int INCORRECT_ID = -32;

    @Mock
    private SchedulerProvider mSchedulerProvider;

    @Mock
    private LocationInteractor mLocationInteractor;

    @Mock
    private Observer<Location> mLocation;

    @Mock
    private Observer<Boolean> mProgress;

    @Mock
    private Observer<Throwable> mError;

    private LocationViewModel mLocationListViewModel;


    @Rule
    public final InstantTaskExecutorRule mRule = new InstantTaskExecutorRule();

    @Before
    public void setUp() {
        Mockito.when(mSchedulerProvider.io()).thenReturn(Schedulers.trampoline());
        Mockito.when(mSchedulerProvider.ui()).thenReturn(Schedulers.trampoline());

        mLocationListViewModel =
                new LocationViewModel(mSchedulerProvider, mLocationInteractor);

        mLocationListViewModel
                .getLocation().observeForever(mLocation);
        mLocationListViewModel
                .getError().observeForever(mError);
        mLocationListViewModel
                .getProgress().observeForever(mProgress);
    }

    /**
     * Проверка на то, что после подписки мы получим ожидаемую информацию об локации.
     */
    @Test
    public void loadLocationById() {
        // Arrange
        Mockito
                .when(mLocationInteractor.getLocationFromRepository(CORRECT_ID))
                .thenReturn(Single.just(LocationTestData.createLocation()));

        // Act
        InOrder inOrder = Mockito.inOrder(mError, mLocation, mProgress);
        mLocationListViewModel.loadLocationById(CORRECT_ID);

        // Assert
        inOrder.verify(mProgress).onChanged(true);
        inOrder.verify(mLocation).onChanged(LocationTestData.createLocation());
        inOrder.verify(mProgress).onChanged(false);
        inOrder.verifyNoMoreInteractions();
    }

    /**
     * Проверка на то, что при указание неверного id при подписке, мы получим
     * {@link NullPointerException}.
     */
    @Test
    public void testLoadLocationByIncorrectId() {
        Mockito
                .when(mLocationInteractor.getLocationFromRepository(INCORRECT_ID))
                .thenReturn(Single.error(NullPointerException::new));

        mLocationListViewModel.loadLocationById(INCORRECT_ID);

        Mockito.verify(mError).onChanged(ArgumentMatchers.isA(NullPointerException.class));
    }
}
