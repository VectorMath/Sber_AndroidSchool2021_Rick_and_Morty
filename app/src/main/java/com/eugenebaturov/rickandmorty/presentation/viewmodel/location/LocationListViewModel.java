package com.eugenebaturov.rickandmorty.presentation.viewmodel.location;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.eugenebaturov.rickandmorty.domain.interactor.location.LocationInteractor;
import com.eugenebaturov.rickandmorty.models.domain.Location;
import com.eugenebaturov.rickandmorty.presentation.viewmodel.AppViewModel;
import com.eugenebaturov.rickandmorty.utils.SchedulerProvider;

import java.util.List;

import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;

/**
 * ViewModel для списка локаций.
 */
public final class LocationListViewModel extends AppViewModel {

    @NonNull
    private final MutableLiveData<List<Location>> mLocations = new MutableLiveData<>();

    @NonNull
    private final MutableLiveData<Boolean> mProgress = new MutableLiveData<>();

    @NonNull
    private final MutableLiveData<Throwable> mError = new MutableLiveData<>();

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
     * Getter для приватного поля mProgress.
     *
     * @return прогресс в {@link LiveData} обёртке.
     */
    public LiveData<Boolean> getProgress() {
        return mProgress;
    }

    /**
     * Getter для приватного поля mError.
     *
     * @return ошибку в {@link LiveData} обёртке.
     */
    public LiveData<Throwable> getError() {
        return mError;
    }

    /**
     * Метод, в котором поле mLocations подписывается на источник данных
     * в виде получения информации о всех локациях с сервера.
     */
    public void loadLocations() {
        disposable.add(mLocationInteractor
                .getLocationsFromRepository()
                .subscribeOn(mSchedulerProvider.io())
                .observeOn(mSchedulerProvider.ui())
                .doFinally(() -> mProgress.setValue(false))
                .doOnSubscribe(d -> mProgress.setValue(true))
                .subscribe(mLocations::setValue, mError::setValue));
    }
}
