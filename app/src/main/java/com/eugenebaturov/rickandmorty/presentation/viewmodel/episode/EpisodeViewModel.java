package com.eugenebaturov.rickandmorty.presentation.viewmodel.episode;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.eugenebaturov.rickandmorty.domain.interactor.episode.EpisodeInteractor;
import com.eugenebaturov.rickandmorty.models.domain.Episode;
import com.eugenebaturov.rickandmorty.presentation.viewmodel.AppViewModel;
import com.eugenebaturov.rickandmorty.utils.SchedulerProvider;

import io.reactivex.rxjava3.disposables.CompositeDisposable;

/**
 * ViewModel для эпизода.
 */
public final class EpisodeViewModel extends AppViewModel {

    @NonNull
    private final MutableLiveData<Episode> mEpisode = new MutableLiveData<>();

    @NonNull
    private final MutableLiveData<Boolean> mProgress = new MutableLiveData<>();

    @NonNull
    private final MutableLiveData<Throwable> mError = new MutableLiveData<>();

    @NonNull
    private final SchedulerProvider mSchedulerProvider;

    @NonNull
    private final EpisodeInteractor mEpisodeInteractor;

    /**
     * Конструктор класса.
     *
     * @param schedulerProvider экземпляр {@link SchedulerProvider}
     * @param episodeInteractor экземпляр {@link EpisodeInteractor}
     */
    public EpisodeViewModel(
            @NonNull final SchedulerProvider schedulerProvider,
            @NonNull final EpisodeInteractor episodeInteractor) {
        mSchedulerProvider = schedulerProvider;
        mEpisodeInteractor = episodeInteractor;
    }

    /**
     * Getter для поля mEpisode.
     *
     * @return эпизод в {@link LiveData} обёртке.
     */
    public LiveData<Episode> getEpisode() {
        return mEpisode;
    }

    /**
     * Getter для приватного поля mProgress.
     *
     * @return прогресс в {@link LiveData} обёртке.
     */
    public LiveData<Boolean> getProgress() {
        return mProgress;
    }

    /**
     * Getter для приватного поля mError.
     *
     * @return ошибку в {@link LiveData} обёртке.
     */
    public LiveData<Throwable> getError() {
        return mError;
    }

    /**
     * Метод, в котором поле mEpisode подписывается на источник данных
     * в виде получения информация с сервера об эпизоде с конкретным id.
     *
     * @param episodeId id эпизода.
     */
    public final void loadEpisodeById(final int episodeId) {
        disposable.add(mEpisodeInteractor
                .getEpisodeFromRepository(episodeId)
                .subscribeOn(mSchedulerProvider.io())
                .observeOn(mSchedulerProvider.ui())
                .doFinally(() -> mProgress.setValue(false))
                .doOnSubscribe(d -> mProgress.setValue(true))
                .subscribe(mEpisode::setValue, mError::setValue));
    }
}
