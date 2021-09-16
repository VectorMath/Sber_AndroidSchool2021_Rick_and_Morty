package com.eugenebaturov.rickandmorty.di.episode;

import com.eugenebaturov.rickandmorty.di.FragmentScope;
import com.eugenebaturov.rickandmorty.presentation.ui.fragment.episode.EpisodeFragment;
import com.eugenebaturov.rickandmorty.presentation.ui.fragment.episode.EpisodeListFragment;

import dagger.Subcomponent;

/**
 * Предоставляет зависимости для эпизодов.
 */
@FragmentScope
@Subcomponent(modules = EpisodeModule.class)
public interface EpisodeComponent {

    void inject(EpisodeListFragment episodeListFragment);

    void inject(EpisodeFragment episodeFragment);
}
