package com.eugenebaturov.rickandmorty.presentation.viewmodel.episode;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.eugenebaturov.rickandmorty.domain.interactor.episode.EpisodeInteractor;
import com.eugenebaturov.rickandmorty.models.domain.Episode;
import com.eugenebaturov.rickandmorty.presentation.viewmodel.RxViewModel;
import com.eugenebaturov.rickandmorty.utils.SchedulerProvider;

import java.util.List;

/**
 * ViewModel для списка эпизодов.
 */
public final class EpisodeListViewModel extends RxViewModel {

    @NonNull
    private final MutableLiveData<List<Episode>> mEpisodes = new MutableLiveData<>();

    @NonNull
    private final MutableLiveData<Boolean> mProgress = new MutableLiveData<>();

    @NonNull
    private final MutableLiveData<Throwable> mError = new MutableLiveData<>();

    @NonNull
    private final MutableLiveData<Throwable> mSearchError = new MutableLiveData<>();

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
    public EpisodeListViewModel(
            @NonNull final SchedulerProvider schedulerProvider,
            @NonNull final EpisodeInteractor episodeInteractor) {
        mSchedulerProvider = schedulerProvider;
        mEpisodeInteractor = episodeInteractor;
    }

    /**
     * Getter для mEpisodes.
     *
     * @return список эпизодов в {@link LiveData} обёртке.
     */
    public LiveData<List<Episode>> getEpisodes() {
        return mEpisodes;
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
     * Getter для приватного поля mSearchError.
     *
     * @return ошибку поиска в {@link LiveData} обёртке.
     */
    public LiveData<Throwable> getSearchError() {
        return mSearchError;
    }

    /**
     * Метод в котором поле mEpisodes подписывается на источник данных
     * в виде получение информации об эпизодах с сервера.
     */
    public void loadEpisodes() {
        disposable.add(mEpisodeInteractor
                .getEpisodes()
                .subscribeOn(mSchedulerProvider.io())
                .observeOn(mSchedulerProvider.ui())
                .doFinally(() -> mProgress.setValue(false))
                .doOnSubscribe(d -> mProgress.setValue(true) )
                .subscribe(mEpisodes::setValue, mError::setValue));
    }

    /**
     * Метод, в котором поле mEpisodes подписывается на источник данных
     * в виде получение информации об эпизодах, которые удоволетворяют строке запроса с сервера.
     *
     * @param query строка запроса.
     */
    public void loadEpisodes(String query) {
        disposable.add(mEpisodeInteractor
                .getEpisodes(query)
                .subscribeOn(mSchedulerProvider.io())
                .observeOn(mSchedulerProvider.ui())
                .doFinally(() -> mProgress.setValue(false))
                .doOnSubscribe(d -> mProgress.setValue(true))
                .subscribe(mEpisodes::setValue, mSearchError::setValue));
    }
}
