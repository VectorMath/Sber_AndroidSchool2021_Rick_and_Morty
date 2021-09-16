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

/**
 * Предоставляет зависимости, которые необходимы {@link CharacterSubcomponent}.
 */
@Module
public final class CharacterModule {
    /**
     * Предоставляет фабрику для {@link CharacterViewModel}.
     *
     * @param schedulerProvider   шедулер.
     * @param characterInteractor интерактор персонажей.
     * @return фабрика для {@link CharacterViewModel}.
     */
    @Provides
    CharacterViewModelFactory provideViewModelFactory(
            SchedulerProvider schedulerProvider,
            CharacterInteractor characterInteractor) {
        return new CharacterViewModelFactory(schedulerProvider, characterInteractor);
    }

    /**
     * Предоставляет фабрику для {@link CharacterListViewModel}.
     *
     * @param schedulerProvider   шедулер.
     * @param characterInteractor интерактор персонажей.
     * @return фабрика для {@link CharacterListViewModel}.
     */
    @Provides
    CharacterListViewModelFactory provideListViewModelFactory(
            SchedulerProvider schedulerProvider,
            CharacterInteractor characterInteractor) {
        return new CharacterListViewModelFactory(schedulerProvider, characterInteractor);
    }

    /**
     * Предоставляет вью-модельку {@link CharacterViewModel}
     *
     * @param schedulerProvider   шедулер.
     * @param characterInteractor интерактор персонажей.
     * @return вью-модель персонажа.
     */
    @Provides
    CharacterViewModel provideViewModel(
            SchedulerProvider schedulerProvider,
            CharacterInteractor characterInteractor) {
        return new CharacterViewModel(schedulerProvider, characterInteractor);
    }

    /**
     * Предоставляет вью-модельку {@link CharacterListViewModel}
     *
     * @param schedulerProvider   шедулер.
     * @param characterInteractor интерактор персонажей.
     * @return вью-модель списка персонажей.
     */
    @Provides
    CharacterListViewModel provideListViewModel(
            SchedulerProvider schedulerProvider,
            CharacterInteractor characterInteractor) {
        return new CharacterListViewModel(schedulerProvider, characterInteractor);
    }

    /**
     * Предоставляет интерактор персонажей {@link CharacterInteractor}.
     *
     * @param characterRepository репозиторий персонажей.
     * @return интерактор персонажей
     */
    @Provides
    CharacterInteractor provideInteractor(CharacterRepository characterRepository) {
        return new CharacterInteractorImpl(characterRepository);
    }

    /**
     * Предоставляет репозиторий персонажей {@link CharacterRepository}.
     *
     * @param characterApi апи персонажей.
     * @return репозиторий персонажей
     */
    @Provides
    CharacterRepository provideRepository(CharacterApi characterApi) {
        return new CharacterRepositoryImpl(characterApi);
    }

    /**
     * Предоставляет апи персонажей {@link CharacterApi}
     *
     * @param retrofit ретрофит.
     * @return апи с реализованными методами.
     */
    @Provides
    CharacterApi provideApi(Retrofit retrofit) {
        return retrofit.create(CharacterApi.class);
    }
}
