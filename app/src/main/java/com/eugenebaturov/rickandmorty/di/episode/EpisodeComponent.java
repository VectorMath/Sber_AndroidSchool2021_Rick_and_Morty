package com.eugenebaturov.rickandmorty.di.episode;

import com.eugenebaturov.rickandmorty.di.AppModule;
import com.eugenebaturov.rickandmorty.presentation.viewmodel.episode.EpisodeListViewModelFactory;
import com.eugenebaturov.rickandmorty.presentation.viewmodel.episode.EpisodeViewModelFactory;

import dagger.Component;

@Component(modules = {EpisodeModule.class, AppModule.class})
public interface EpisodeComponent {
    EpisodeViewModelFactory getViewModelFactory();

    EpisodeListViewModelFactory getListViewModelFactory();
}
