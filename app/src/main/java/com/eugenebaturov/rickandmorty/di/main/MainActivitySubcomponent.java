package com.eugenebaturov.rickandmorty.di.main;

import com.eugenebaturov.rickandmorty.di.ActivityScope;
import com.eugenebaturov.rickandmorty.presentation.ui.MainActivity;

import dagger.Subcomponent;

/**
 * Предоставляет зависимости для {@link MainActivity}.
 */
@ActivityScope
@Subcomponent(modules = MainActivityModule.class)
public interface MainActivitySubcomponent {
    void inject(MainActivity mainActivity);
}
