package com.eugenebaturov.rickandmorty.di.episode;

import com.eugenebaturov.rickandmorty.data.api.EpisodeApi;
import com.eugenebaturov.rickandmorty.data.repository.episode.EpisodeRepository;
import com.eugenebaturov.rickandmorty.data.repository.episode.EpisodeRepositoryImpl;
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

/**
 * Внедряет зависимости, которые необходимы {@link EpisodeComponent}.
 */
@Module
public final class EpisodeModule {

    /**
     * Внедряет фабрику для {@link EpisodeListViewModel}.
     *
     * @param schedulerProvider шедулер.
     * @param episodeInteractor интерактор эпизодов.
     * @return фабрика для {@link EpisodeListViewModel}.
     */
    @Provides
    EpisodeListViewModelFactory provideListViewModelFactory(
            SchedulerProvider schedulerProvider,
            EpisodeInteractor episodeInteractor) {
        return new EpisodeListViewModelFactory(schedulerProvider, episodeInteractor);
    }

    /**
     * Внедряет фабрику для {@link EpisodeViewModel}.
     *
     * @param schedulerProvider шедулер.
     * @param episodeInteractor интерактор эпизодов.
     * @return фабрика для {@link EpisodeViewModel}.
     */
    @Provides
    EpisodeViewModelFactory provideFactory(
            SchedulerProvider schedulerProvider,
            EpisodeInteractor episodeInteractor) {
        return new EpisodeViewModelFactory(schedulerProvider, episodeInteractor);
    }

    /**
     * Внедряет вью-модельку {@link EpisodeListViewModel}
     *
     * @param schedulerProvider шедулер.
     * @param episodeInteractor интерактор эпизодов.
     * @return вью-модель списка эпизодов.
     */
    @Provides
    EpisodeListViewModel provideListViewModel(
            SchedulerProvider schedulerProvider,
            EpisodeInteractor episodeInteractor) {
        return new EpisodeListViewModel(schedulerProvider, episodeInteractor);
    }

    /**
     * Внедряет вью-модельку {@link EpisodeViewModel}
     *
     * @param schedulerProvider шедулер.
     * @param episodeInteractor интерактор эпизодов.
     * @return вью-модель эпизода.
     */
    @Provides
    EpisodeViewModel provideViewModel(
            SchedulerProvider schedulerProvider,
            EpisodeInteractor episodeInteractor) {
        return new EpisodeViewModel(schedulerProvider, episodeInteractor);
    }

    /**
     * Внедряет интерактор эпизодов {@link EpisodeInteractor}.
     *
     * @param episodeRepository репозиторий эпизодов.
     * @return интерактор эпизодов.
     */
    @Provides
    EpisodeInteractor provideInteractor(EpisodeRepository episodeRepository) {
        return new EpisodeInteractorImpl(episodeRepository);
    }

    /**
     * Внедряет репозиторий эпизодов {@link EpisodeRepository}.
     *
     * @param episodeApi api эпизодов.
     * @return репозиторий эпизодов.
     */
    @Provides
    EpisodeRepository provideRepository(EpisodeApi episodeApi) {
        return new EpisodeRepositoryImpl(episodeApi);
    }

    /**
     * Внедряет апи эпизодов {@link EpisodeApi}.
     *
     * @param retrofit ретрофит.
     * @return апи с реализованными методами.
     */
    @Provides
    EpisodeApi provideApi(Retrofit retrofit) {
        return retrofit.create(EpisodeApi.class);
    }
}
