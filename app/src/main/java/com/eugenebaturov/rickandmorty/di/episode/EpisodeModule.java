package com.eugenebaturov.rickandmorty.di.episode;

import com.eugenebaturov.rickandmorty.data.api.EpisodeApi;
import com.eugenebaturov.rickandmorty.data.repository.episode.EpisodeRepository;
import com.eugenebaturov.rickandmorty.data.repository.episode.EpisodeRepositoryImpl;
import com.eugenebaturov.rickandmorty.di.AppModule;
import com.eugenebaturov.rickandmorty.domain.interactor.episode.EpisodeInteractor;
import com.eugenebaturov.rickandmorty.domain.interactor.episode.EpisodeInteractorImpl;
import com.eugenebaturov.rickandmorty.presentation.viewmodel.episode.EpisodeListViewModel;
import com.eugenebaturov.rickandmorty.presentation.viewmodel.episode.EpisodeListViewModelFactory;
import com.eugenebaturov.rickandmorty.presentation.viewmodel.episode.EpisodeViewModel;
import com.eugenebaturov.rickandmorty.presentation.viewmodel.episode.EpisodeViewModelFactory;
import com.eugenebaturov.rickandmorty.utils.SchedulerProvider;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public final class EpisodeModule {
    @Provides
    EpisodeListViewModelFactory provideListViewModelFactory(
            SchedulerProvider schedulerProvider,
            EpisodeInteractor episodeInteractor) {
        return new EpisodeListViewModelFactory(schedulerProvider, episodeInteractor);
    }

    @Provides
    EpisodeViewModelFactory provideFactory(
            SchedulerProvider schedulerProvider,
            EpisodeInteractor episodeInteractor) {
        return new EpisodeViewModelFactory(schedulerProvider, episodeInteractor);
    }

    @Provides
    EpisodeListViewModel provideListViewModel(
            SchedulerProvider schedulerProvider,
            EpisodeInteractor episodeInteractor) {
        return new EpisodeListViewModel(schedulerProvider, episodeInteractor);
    }

    @Provides
    EpisodeViewModel provideViewModel(
            SchedulerProvider schedulerProvider,
            EpisodeInteractor episodeInteractor) {
        return new EpisodeViewModel(schedulerProvider, episodeInteractor);
    }

    @Provides
    EpisodeInteractor provideInteractor(EpisodeRepository episodeRepository) {
        return new EpisodeInteractorImpl(episodeRepository);
    }

    @Provides
    EpisodeRepository provideRepository(EpisodeApi episodeApi) {
        return new EpisodeRepositoryImpl(episodeApi);
    }

    @Provides
    EpisodeApi provideApi(Retrofit retrofit) {
        return retrofit.create(EpisodeApi.class);
    }
}
