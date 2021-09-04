package com.eugenebaturov.rickandmorty.presentation.viewmodel.location;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.eugenebaturov.rickandmorty.domain.interactor.location.LocationInteractor;
import com.eugenebaturov.rickandmorty.models.domain.Location;
import com.eugenebaturov.rickandmorty.presentation.viewmodel.AppViewModel;
import com.eugenebaturov.rickandmorty.utils.SchedulerProvider;

/**
 * ViewModel для локации.
 */
public final class LocationViewModel extends AppViewModel {

    @NonNull
    private final MutableLiveData<Location> mLocation = new MutableLiveData<>();

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
    public LocationViewModel(
            @NonNull final SchedulerProvider schedulerProvider,
            @NonNull final LocationInteractor locationInteractor) {
        mSchedulerProvider = schedulerProvider;
        mLocationInteractor = locationInteractor;
    }

    /**
     * Getter для поля mLocation
     *
     * @return локация в {@link LiveData} обёртке.
     */
    public LiveData<Location> getLocation() {
        return mLocation;
    }

    /**
     * Метод, в котором поле mLocation подписывается на источник данных
     * в виде получения информации с сервера о локации с конкретным id.
     *
     * @param locationId id локации.
     */
    public void loadLocationById(final int locationId) {
        disposable = mLocationInteractor
                .getLocationFromRepository(locationId)
                .subscribeOn(mSchedulerProvider.io())
                .observeOn(mSchedulerProvider.ui())
                .subscribe(mLocation::setValue);
    }
}