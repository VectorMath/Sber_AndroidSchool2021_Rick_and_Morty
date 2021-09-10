package com.eugenebaturov.rickandmorty.presentation.viewmodel.character;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.eugenebaturov.rickandmorty.domain.interactor.character.CharacterInteractor;
import com.eugenebaturov.rickandmorty.models.domain.Character;
import com.eugenebaturov.rickandmorty.presentation.viewmodel.AppViewModel;
import com.eugenebaturov.rickandmorty.utils.SchedulerProvider;

import io.reactivex.rxjava3.disposables.CompositeDisposable;

/**
 * ViewModel для персонажа.
 */
public final class CharacterViewModel extends AppViewModel {

    @NonNull
    private final MutableLiveData<Character> mCharacter = new MutableLiveData<>();

    @NonNull
    private final MutableLiveData<Boolean> mProgress = new MutableLiveData<>();

    @NonNull
    private final MutableLiveData<Throwable> mError = new MutableLiveData<>();

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
    public CharacterViewModel(
            @NonNull final SchedulerProvider schedulerProvider,
            @NonNull final CharacterInteractor characterInteractor) {
        mSchedulerProvider = schedulerProvider;
        mCharacterInteractor = characterInteractor;
    }

    /**
     * Getter для приватного поля mCharacter.
     *
     * @return персонаж в {@link LiveData} обёртке.
     */
    public LiveData<Character> getCharacter() {
        return mCharacter;
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
     * @return ошибка в {@link LiveData} обёртке.
     */
    public LiveData<Throwable> getError() {
        return mError;
    }

    /**
     * Метод, в котором поле mCharacter подписывается на источник данных
     * в виде получение информации о персонаже с конкретным id с сервера.
     *
     * @param characterId id персонажа.
     */
    public final void loadCharacterById(final int characterId) {
        disposable.add(mCharacterInteractor
                .getCharacterFromRepository(characterId)
                .subscribeOn(mSchedulerProvider.io())
                .observeOn(mSchedulerProvider.ui())
                .doFinally(() -> mProgress.setValue(false))
                .doOnSubscribe(d -> mProgress.setValue(true))
                .subscribe(mCharacter::setValue, mError::setValue));
    }
}
