package com.eugenebaturov.rickandmorty.di.character;

import com.eugenebaturov.rickandmorty.di.annotations.FragmentScope;
import com.eugenebaturov.rickandmorty.presentation.ui.fragment.character.CharacterFragment;
import com.eugenebaturov.rickandmorty.presentation.ui.fragment.character.CharacterListFragment;

import dagger.Subcomponent;

/**
 * Предоставляет зависимости для персонажей.
 */
@FragmentScope
@Subcomponent(modules = CharacterModule.class)
public interface CharacterSubcomponent {

    /**
     * Внедряет необходимые зависимости в {@link CharacterListFragment}
     *
     * @param characterListFragment образец фрагмента со списком персонажей.
     */
    void inject(CharacterListFragment characterListFragment);

    /**
     * Внедряет необходимые зависимости в {@link CharacterFragment}
     *
     * @param characterFragment образец фрагмента с конкретным персонажем.
     */
    void inject(CharacterFragment characterFragment);
}
