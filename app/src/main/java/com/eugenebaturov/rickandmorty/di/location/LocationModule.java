package com.eugenebaturov.rickandmorty.di.location;

import com.eugenebaturov.rickandmorty.data.api.LocationApi;
import com.eugenebaturov.rickandmorty.data.repository.location.LocationRepository;
import com.eugenebaturov.rickandmorty.data.repository.location.LocationRepositoryImpl;
import com.eugenebaturov.rickandmorty.di.AppModule;
import com.eugenebaturov.rickandmorty.domain.interactor.location.LocationInteractor;
import com.eugenebaturov.rickandmorty.domain.interactor.location.LocationInteractorImpl;
import com.eugenebaturov.rickandmorty.models.domain.Location;
import com.eugenebaturov.rickandmorty.presentation.viewmodel.location.LocationListViewModel;
import com.eugenebaturov.rickandmorty.presentation.viewmodel.location.LocationListViewModelFactory;
import com.eugenebaturov.rickandmorty.presentation.viewmodel.location.LocationViewModel;
import com.eugenebaturov.rickandmorty.presentation.viewmodel.location.LocationViewModelFactory;
import com.eugenebaturov.rickandmorty.utils.SchedulerProvider;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public final class LocationModule {
    @Provides
    LocationListViewModelFactory provideListViewModelFactory(
            SchedulerProvider schedulerProvider,
            LocationInteractor locationInteractor) {
        return new LocationListViewModelFactory(schedulerProvider, locationInteractor);
    }

    @Provides
    LocationViewModelFactory provideFactory(
            SchedulerProvider schedulerProvider,
            LocationInteractor locationInteractor) {
        return new LocationViewModelFactory(schedulerProvider, locationInteractor);
    }

    @Provides
    LocationListViewModel provideListViewModel(
            SchedulerProvider schedulerProvider,
            LocationInteractor locationInteractor) {
        return new LocationListViewModel(schedulerProvider, locationInteractor);
    }

    @Provides
    LocationViewModel provideViewModel(
            SchedulerProvider schedulerProvider,
            LocationInteractor locationInteractor) {
        return new LocationViewModel(schedulerProvider, locationInteractor);
    }

    @Provides
    LocationInteractor provideInteractor(LocationRepository locationRepository) {
        return new LocationInteractorImpl(locationRepository);
    }

    @Provides
    LocationRepository provideRepository(LocationApi locationApi) {
        return new LocationRepositoryImpl(locationApi);
    }

    @Provides
    LocationApi provideApi(Retrofit retrofit) {
        return retrofit.create(LocationApi.class);
    }
}
