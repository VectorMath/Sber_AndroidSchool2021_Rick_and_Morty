package com.eugenebaturov.rickandmorty.di.main;

import com.eugenebaturov.rickandmorty.di.annotations.ActivityScope;
import com.eugenebaturov.rickandmorty.presentation.ui.MainActivity;

import dagger.Subcomponent;

/**
 * Предоставляет зависимости для {@link MainActivity}.
 */
@ActivityScope
@Subcomponent(modules = MainActivityModule.class)
public interface MainActivitySubcomponent {

    /**
     * Внедряет необходимые зависимости в {@link MainActivity}
     *
     * @param mainActivity образец главной активити.
     */
    void inject(MainActivity mainActivity);
}
