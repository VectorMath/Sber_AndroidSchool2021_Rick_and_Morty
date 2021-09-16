package com.eugenebaturov.rickandmorty.di.character;

import com.eugenebaturov.rickandmorty.di.FragmentScope;
import com.eugenebaturov.rickandmorty.presentation.ui.fragment.character.CharacterFragment;
import com.eugenebaturov.rickandmorty.presentation.ui.fragment.character.CharacterListFragment;
import com.eugenebaturov.rickandmorty.presentation.viewmodel.character.CharacterListViewModel;
import com.eugenebaturov.rickandmorty.presentation.viewmodel.character.CharacterListViewModelFactory;
import com.eugenebaturov.rickandmorty.presentation.viewmodel.character.CharacterViewModel;
import com.eugenebaturov.rickandmorty.presentation.viewmodel.character.CharacterViewModelFactory;

import dagger.Subcomponent;

/**
 * Предоставляет зависимости для персонажей.
 */
@FragmentScope
@Subcomponent(modules = CharacterModule.class)
public interface CharacterComponent {

    void inject(CharacterListFragment characterListFragment);

    void inject(CharacterFragment characterFragment);
}
