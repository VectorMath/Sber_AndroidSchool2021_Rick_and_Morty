package com.eugenebaturov.rickandmorty.di.character;

import com.eugenebaturov.rickandmorty.data.api.CharacterApi;
import com.eugenebaturov.rickandmorty.data.repository.character.CharacterRepository;
import com.eugenebaturov.rickandmorty.data.repository.character.CharacterRepositoryImpl;
import com.eugenebaturov.rickandmorty.domain.interactor.character.CharacterInteractor;
import com.eugenebaturov.rickandmorty.domain.interactor.character.CharacterInteractorImpl;
import com.eugenebaturov.rickandmorty.presentation.viewmodel.character.CharacterListViewModel;
import com.eugenebaturov.rickandmorty.presentation.viewmodel.character.CharacterListViewModelFactory;
import com.eugenebaturov.rickandmorty.presentation.viewmodel.character.CharacterViewModel;
import com.eugenebaturov.rickandmorty.presentation.viewmodel.character.CharacterViewModelFactory;
import com.eugenebaturov.rickandmorty.utils.SchedulerProvider;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public final class CharacterModule {
    @Provides
    CharacterViewModelFactory provideViewModelFactory(
            SchedulerProvider schedulerProvider,
            CharacterInteractor characterInteractor) {
        return new CharacterViewModelFactory(schedulerProvider, characterInteractor);
    }

    @Provides
    CharacterListViewModelFactory provideListViewModelFactory(
            SchedulerProvider schedulerProvider,
            CharacterInteractor characterInteractor) {
        return new CharacterListViewModelFactory(schedulerProvider, characterInteractor);
    }

    @Provides
    CharacterViewModel provideViewModel(
            SchedulerProvider schedulerProvider,
            CharacterInteractor characterInteractor) {
        return new CharacterViewModel(schedulerProvider, characterInteractor);
    }

    @Provides
    CharacterListViewModel provideListViewModel(
            SchedulerProvider schedulerProvider,
            CharacterInteractor characterInteractor) {
        return new CharacterListViewModel(schedulerProvider, characterInteractor);
    }

    @Provides
    CharacterInteractor provideInteractor(CharacterRepository characterRepository) {
        return new CharacterInteractorImpl(characterRepository);
    }

    @Provides
    CharacterRepository provideRepository(CharacterApi characterApi) {
        return new CharacterRepositoryImpl(characterApi);
    }

    @Provides
    CharacterApi provideApi(Retrofit retrofit) {
        return retrofit.create(CharacterApi.class);
    }
}
