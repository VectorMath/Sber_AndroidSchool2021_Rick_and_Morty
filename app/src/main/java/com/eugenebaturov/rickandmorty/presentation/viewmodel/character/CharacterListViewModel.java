package com.eugenebaturov.rickandmorty.presentation.viewmodel.character;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.eugenebaturov.rickandmorty.domain.interactor.character.CharacterInteractor;
import com.eugenebaturov.rickandmorty.models.domain.Character;
import com.eugenebaturov.rickandmorty.presentation.viewmodel.RxViewModel;
import com.eugenebaturov.rickandmorty.utils.SchedulerProvider;

import java.util.List;

/**
 * ViewModel для списка персонажей.
 */
public final class CharacterListViewModel extends RxViewModel {

    @NonNull
    private final MutableLiveData<List<Character>> mCharacters = new MutableLiveData<>();

    @NonNull
    private final MutableLiveData<Boolean> mProgress = new MutableLiveData<>();

    @NonNull
    private final MutableLiveData<Throwable> mError = new MutableLiveData<>();

    @NonNull
    private final MutableLiveData<Throwable> mSearchError = new MutableLiveData<>();

    @NonNull
    private final SchedulerProvider mSchedulerProvider;

    @NonNull
    private final CharacterInteractor mCharacterInteractor;

    /**
     * Конструктор класса.
     *
     * @param schedulerProvider   экземпляр {@link SchedulerProvider}
     * @param characterInteractor экземпляр {@link CharacterInteractor}
     */
    public CharacterListViewModel(
            @NonNull final SchedulerProvider schedulerProvider,
            @NonNull final CharacterInteractor characterInteractor) {
        mSchedulerProvider = schedulerProvider;
        mCharacterInteractor = characterInteractor;
    }

    /**
     * Getter для приватного поля mCharacters.
     *
     * @return список персонажей в {@link LiveData} обёртке.
     */
    public LiveData<List<Character>> getCharacters() {
        return mCharacters;
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

    public LiveData<Throwable> getSearchError() {
        return mSearchError;
    }

    /**
     * Метод, в котором поле mCharacters подписывается на источник данных
     * в виде получение информации о персонажах с сервера.
     */
    public final void loadCharacters() {

//        Observable.just("")
//                .debounce()
//                .distinctUntilChanged();

        disposable.add(mCharacterInteractor
                .getCharacters()
                .subscribeOn(mSchedulerProvider.io())
                .observeOn(mSchedulerProvider.ui())
                .doFinally(() -> mProgress.setValue(false))
                .doOnSubscribe(d -> mProgress.setValue(true))
                .subscribe(mCharacters::setValue, mError::setValue));
    }

    /**
     * Метод, в котором поле mCharacters подписывается на источник данных
     * в виде получение информации о персонажах, которые удоволетворяют строке запроса с сервера.
     *
     * @param searchName строка запроса.
     */
    public final void loadCharacters(String searchName) {
        disposable.add(mCharacterInteractor
                .getCharacters(searchName)
                .subscribeOn(mSchedulerProvider.io())
                .observeOn(mSchedulerProvider.ui())
                .doFinally(() -> mProgress.setValue(false))
                .doOnSubscribe(d -> mProgress.setValue(true))
                .subscribe(mCharacters::setValue, mSearchError::setValue));

    }
}
