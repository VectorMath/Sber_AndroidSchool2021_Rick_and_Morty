package com.eugenebaturov.rickandmorty.di.character;

import com.eugenebaturov.rickandmorty.di.AppModule;
import com.eugenebaturov.rickandmorty.presentation.viewmodel.character.CharacterListViewModel;
import com.eugenebaturov.rickandmorty.presentation.viewmodel.character.CharacterListViewModelFactory;
import com.eugenebaturov.rickandmorty.presentation.viewmodel.character.CharacterViewModel;
import com.eugenebaturov.rickandmorty.presentation.viewmodel.character.CharacterViewModelFactory;

import dagger.Component;

/**
 * Предоставляет зависимости для персонажей.
 */
@Component(modules = {CharacterModule.class, AppModule.class})
public interface CharacterComponent {

    /**
     * Предоставляет фабрику для {@link CharacterViewModel}.
     *
     * @return фабрика для вью-модельки
     */
    CharacterViewModelFactory getViewModelFactory();

    /**
     * Предоставляет фабрику для {@link CharacterListViewModel}.
     *
     * @return фабрика для вью-модельки
     */
    CharacterListViewModelFactory getListViewModelFactory();
}
