package com.eugenebaturov.rickandmorty.di;

import android.content.Context;

import com.eugenebaturov.rickandmorty.di.character.CharacterSubcomponent;
import com.eugenebaturov.rickandmorty.di.episode.EpisodeSubcomponent;
import com.eugenebaturov.rickandmorty.di.location.LocationSubcomponent;
import com.eugenebaturov.rickandmorty.di.main.MainActivitySubcomponent;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

/**
 * Основной компонент зависимостей.
 */
@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    /**
     * Предоставляет подкомпонент с зависимостями для главной активити.
     *
     * @return подкомпонент {@link MainActivitySubcomponent}.
     */
    MainActivitySubcomponent getMainActivitySubcomponent();

    /**
     * Предоставляет подкомпонент с зависимостями для персонажей.
     *
     * @return подкомпонент {@link CharacterSubcomponent}.
     */
    CharacterSubcomponent getCharacterSubcomponent();

    /**
     * Предоставляет подкомпонент с зависимостями для эпизодов.
     *
     * @return подкомпонент {@link EpisodeSubcomponent}.
     */
    EpisodeSubcomponent getEpisodeSubcomponent();

    /**
     * Предоставляет подкомпонент с зависимостями для локаций.
     *
     * @return подкомпонент {@link LocationSubcomponent}.
     */
    LocationSubcomponent getLocationSubcomponent();

    /**
     * Фабрика.
     */
    @Component.Factory
    interface Factory {
        AppComponent create(@BindsInstance Context context);
    }
}
