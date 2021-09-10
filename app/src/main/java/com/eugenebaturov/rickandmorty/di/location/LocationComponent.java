package com.eugenebaturov.rickandmorty.di.location;

import com.eugenebaturov.rickandmorty.di.AppModule;
import com.eugenebaturov.rickandmorty.presentation.viewmodel.location.LocationListViewModelFactory;
import com.eugenebaturov.rickandmorty.presentation.viewmodel.location.LocationViewModelFactory;

import dagger.Component;

@Component(modules = {LocationModule.class, AppModule.class})
public interface LocationComponent {
    LocationListViewModelFactory getListViewModelFactory();

    LocationViewModelFactory getViewModelFactory();
}
