package com.eugenebaturov.rickandmorty.di.location;

import com.eugenebaturov.rickandmorty.data.api.LocationApi;
import com.eugenebaturov.rickandmorty.data.repository.location.LocationRepository;
import com.eugenebaturov.rickandmorty.data.repository.location.LocationRepositoryImpl;
import com.eugenebaturov.rickandmorty.domain.interactor.location.LocationInteractor;
import com.eugenebaturov.rickandmorty.domain.interactor.location.LocationInteractorImpl;
import com.eugenebaturov.rickandmorty.presentation.viewmodel.location.LocationListViewModel;
import com.eugenebaturov.rickandmorty.presentation.viewmodel.location.LocationListViewModelFactory;
import com.eugenebaturov.rickandmorty.presentation.viewmodel.location.LocationViewModel;
import com.eugenebaturov.rickandmorty.presentation.viewmodel.location.LocationViewModelFactory;
import com.eugenebaturov.rickandmorty.utils.SchedulerProvider;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Внедряет зависимости, которые необходимы {@link LocationComponent}.
 */
@Module
public final class LocationModule {

    /**
     * Внедряет фабрику для {@link LocationListViewModel}.
     *
     * @param schedulerProvider  шедулер.
     * @param locationInteractor интерактор локаций.
     * @return фабрика для {@link LocationListViewModel}.
     */
    @Provides
    LocationListViewModelFactory provideListViewModelFactory(
            SchedulerProvider schedulerProvider,
            LocationInteractor locationInteractor) {
        return new LocationListViewModelFactory(schedulerProvider, locationInteractor);
    }

    /**
     * Внедряет фабрику для {@link LocationViewModel}.
     *
     * @param schedulerProvider  шедулер.
     * @param locationInteractor интерактор локаций.
     * @return фабрика для {@link LocationViewModel}.
     */
    @Provides
    LocationViewModelFactory provideFactory(
            SchedulerProvider schedulerProvider,
            LocationInteractor locationInteractor) {
        return new LocationViewModelFactory(schedulerProvider, locationInteractor);
    }

    /**
     * Внедряет вью-модельку {@link LocationListViewModel}.
     *
     * @param schedulerProvider  шедулер.
     * @param locationInteractor интерактор локаций.
     * @return вью-моделька списка локаций.
     */
    @Provides
    LocationListViewModel provideListViewModel(
            SchedulerProvider schedulerProvider,
            LocationInteractor locationInteractor) {
        return new LocationListViewModel(schedulerProvider, locationInteractor);
    }

    /**
     * Внедряет вью-модельку {@link LocationViewModel}.
     *
     * @param schedulerProvider  шедулер.
     * @param locationInteractor интерактор локаций.
     * @return вью-моделька локации.
     */
    @Provides
    LocationViewModel provideViewModel(
            SchedulerProvider schedulerProvider,
            LocationInteractor locationInteractor) {
        return new LocationViewModel(schedulerProvider, locationInteractor);
    }

    /**
     * Внедряет интерактор локаций {@link LocationInteractor}.
     *
     * @param locationRepository репозиторий локаций.
     * @return интерактор локаций.
     */
    @Provides
    LocationInteractor provideInteractor(LocationRepository locationRepository) {
        return new LocationInteractorImpl(locationRepository);
    }

    /**
     * Внедряет репозиторий локаций {@link LocationRepository}.
     *
     * @param locationApi api локаций.
     * @return репозиторий локаций.
     */
    @Provides
    LocationRepository provideRepository(LocationApi locationApi) {
        return new LocationRepositoryImpl(locationApi);
    }

    /**
     * Внедряет api локаций {@link LocationApi}.
     *
     * @param retrofit ретрофит.
     * @return api с реализованными методами.
     */
    @Provides
    LocationApi provideApi(Retrofit retrofit) {
        return retrofit.create(LocationApi.class);
    }
}
