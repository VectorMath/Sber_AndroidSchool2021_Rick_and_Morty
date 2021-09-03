package com.eugenebaturov.rickandmorty.presentation.viewmodel.location;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.eugenebaturov.rickandmorty.domain.interactor.location.LocationInteractor;
import com.eugenebaturov.rickandmorty.models.domain.Location;
import com.eugenebaturov.rickandmorty.presentation.viewmodel.AppViewModel;
import com.eugenebaturov.rickandmorty.utils.SchedulerProvider;

import java.util.List;

/**
 * ViewModel для списка локаций.
 */
public final class LocationListViewModel extends AppViewModel {

    @NonNull
    private final MutableLiveData<List<Location>> mLocations = new MutableLiveData<>();

    @NonNull
    private final SchedulerProvider mSchedulerProvider;

    @NonNull
    private final LocationInteractor mLocationInteractor;

    /**
     * Конструктор класса.
     *
     * @param schedulerProvider  экземпляр {@link SchedulerProvider}.
     * @param locationInteractor экземпляр {@link LocationInteractor}.
     */
    public LocationListViewModel(
            @NonNull final SchedulerProvider schedulerProvider,
            @NonNull final LocationInteractor locationInteractor) {
        mSchedulerProvider = schedulerProvider;
        mLocationInteractor = locationInteractor;
    }

    /**
     * Getter для поля mLocations.
     *
     * @return список локаций в {@link LiveData} обёртке.
     */
    public LiveData<List<Location>> getLocations() {
        return mLocations;
    }

    /**
     * Метод, в котором поле mLocations подписывается на источник данных
     * в виде получения информации о всех локациях с сервера.
     */
    public void loadLocations() {
        disposable = mLocationInteractor
                .getLocationsFromRepository()
                .subscribeOn(mSchedulerProvider.io())
                .observeOn(mSchedulerProvider.ui())
                .subscribe(mLocations::setValue);
    }
}
