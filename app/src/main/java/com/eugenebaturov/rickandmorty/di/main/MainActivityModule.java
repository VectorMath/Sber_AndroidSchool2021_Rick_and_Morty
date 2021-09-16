package com.eugenebaturov.rickandmorty.di.main;

import com.eugenebaturov.rickandmorty.presentation.viewmodel.main.MainViewModel;
import com.eugenebaturov.rickandmorty.presentation.viewmodel.main.MainViewModelFactory;

import dagger.Module;
import dagger.Provides;

/**
 * Предоставляет зависимости, которые необходимы {@link MainActivitySubcomponent}.
 */
@Module
public final class MainActivityModule {

    /**
     * Предоставляет {@link MainViewModelFactory}.
     *
     * @return Фабрика вью-модельки активити.
     */
    @Provides
    MainViewModelFactory provideMainViewModelFactory() {
        return new MainViewModelFactory();
    }

    /**
     * Предоставляет {@link MainViewModel}.
     *
     * @return Вью-моделька активити.
     */
    @Provides
    MainViewModel provideMainViewModel() {
        return new MainViewModel();
    }
}
