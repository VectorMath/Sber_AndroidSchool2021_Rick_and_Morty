package com.eugenebaturov.rickandmorty.di.location;

import com.eugenebaturov.rickandmorty.di.AppModule;
import com.eugenebaturov.rickandmorty.presentation.viewmodel.location.LocationListViewModel;
import com.eugenebaturov.rickandmorty.presentation.viewmodel.location.LocationListViewModelFactory;
import com.eugenebaturov.rickandmorty.presentation.viewmodel.location.LocationViewModel;
import com.eugenebaturov.rickandmorty.presentation.viewmodel.location.LocationViewModelFactory;

import dagger.Component;

/**
 * Предоставляет зависимости для локаций.
 */
@Component(modules = {LocationModule.class, AppModule.class})
public interface LocationComponent {

    /**
     * Предоставляет фабрику для {@link LocationListViewModel}.
     *
     * @return фабрика для вью-модельки
     */
    LocationListViewModelFactory getListViewModelFactory();

    /**
     * Предоставляет фабрику для {@link LocationViewModel}.
     *
     * @return фабрика для вью-модельки
     */
    LocationViewModelFactory getViewModelFactory();
}
