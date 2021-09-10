package com.eugenebaturov.rickandmorty.di.character;

import com.eugenebaturov.rickandmorty.di.AppModule;
import com.eugenebaturov.rickandmorty.presentation.viewmodel.character.CharacterListViewModelFactory;
import com.eugenebaturov.rickandmorty.presentation.viewmodel.character.CharacterViewModelFactory;

import dagger.Component;

@Component(modules = {CharacterModule.class, AppModule.class})
public interface CharacterComponent {
    CharacterViewModelFactory getViewModelFactory();

    CharacterListViewModelFactory getListViewModelFactory();
}
