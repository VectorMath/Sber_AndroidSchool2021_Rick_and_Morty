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
public interface LocationSubcomponent {

    /**
     * Внедряет необходимые зависимости в {@link LocationListFragment}
     *
     * @param locationListFragment образец фрагмента со списком локаций.
     */
    void inject(LocationListFragment locationListFragment);

    /**
     * Внедряет необходимые зависимости в {@link LocationListFragment}
     *
     * @param locationFragment образец фрагмента с конкретной локацией.
     */
    void inject(LocationFragment locationFragment);
}
