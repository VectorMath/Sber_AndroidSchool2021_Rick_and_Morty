package com.eugenebaturov.rickandmorty.di.episode;

import com.eugenebaturov.rickandmorty.di.AppModule;
import com.eugenebaturov.rickandmorty.presentation.viewmodel.episode.EpisodeListViewModel;
import com.eugenebaturov.rickandmorty.presentation.viewmodel.episode.EpisodeListViewModelFactory;
import com.eugenebaturov.rickandmorty.presentation.viewmodel.episode.EpisodeViewModel;
import com.eugenebaturov.rickandmorty.presentation.viewmodel.episode.EpisodeViewModelFactory;
import com.eugenebaturov.rickandmorty.presentation.viewmodel.location.LocationViewModel;

import dagger.Component;

/**
 * Предоставляет зависимости для эпизодов.
 */
@Component(modules = {EpisodeModule.class, AppModule.class})
public interface EpisodeComponent {

    /**
     * Предоставляет фабрику для {@link EpisodeViewModel}.
     *
     * @return фабрика для вью-модельки
     */
    EpisodeViewModelFactory getViewModelFactory();

    /**
     * Предоставляет фабрику для {@link EpisodeListViewModel}.
     *
     * @return фабрика для вью-модельки
     */
    EpisodeListViewModelFactory getListViewModelFactory();
}
