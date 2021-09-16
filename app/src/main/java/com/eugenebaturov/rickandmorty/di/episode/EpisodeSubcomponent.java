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
public interface EpisodeSubcomponent {

    /**
     * Внедряет необходимые зависимости в {@link EpisodeListFragment}
     *
     * @param episodeListFragment образец фрагмента со списком эпизодов.
     */
    void inject(EpisodeListFragment episodeListFragment);

    /**
     * Внедряет необходимые зависимости в {@link EpisodeFragment}
     *
     * @param episodeFragment образец фрагмента с конкретным эпизодом.
     */
    void inject(EpisodeFragment episodeFragment);
}
