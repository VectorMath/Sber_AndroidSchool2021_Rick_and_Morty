package com.eugenebaturov.rickandmorty.di;

import com.eugenebaturov.rickandmorty.di.character.CharacterComponent;
import com.eugenebaturov.rickandmorty.di.episode.EpisodeComponent;
import com.eugenebaturov.rickandmorty.di.location.LocationComponent;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    CharacterComponent getCharacterComponent();

    EpisodeComponent getEpisodeComponent();

    LocationComponent getLocationComponent();

    @Component.Factory
    interface Factory {
        AppComponent create();
    }
}
