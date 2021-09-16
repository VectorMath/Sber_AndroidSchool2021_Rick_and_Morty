package com.eugenebaturov.rickandmorty.di.location;

import com.eugenebaturov.rickandmorty.di.FragmentScope;
import com.eugenebaturov.rickandmorty.presentation.ui.fragment.location.LocationFragment;
import com.eugenebaturov.rickandmorty.presentation.ui.fragment.location.LocationListFragment;

import dagger.Subcomponent;

/**
 * Предоставляет зависимости для локаций.
 */
@FragmentScope
@Subcomponent(modules = LocationModule.class)
public interface LocationComponent {

    void inject(LocationListFragment locationListFragment);

    void inject(LocationFragment locationFragment);
}
