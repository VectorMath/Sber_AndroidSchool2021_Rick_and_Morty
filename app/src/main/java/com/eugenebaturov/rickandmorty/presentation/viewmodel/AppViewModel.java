package com.eugenebaturov.rickandmorty.presentation.viewmodel;

import androidx.lifecycle.ViewModel;

import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;

/**
 * Класс-родитель для всех ViewModel проекта.
 * Необходим, чтобы не создавать каждый раз Disposable и чистить его в каждой вью-модельке.
 */
public abstract class AppViewModel extends ViewModel {

    protected CompositeDisposable disposable = new CompositeDisposable();

    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.dispose();
    }
}
