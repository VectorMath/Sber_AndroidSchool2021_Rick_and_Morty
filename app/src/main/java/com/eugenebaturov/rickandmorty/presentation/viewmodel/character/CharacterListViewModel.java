package com.eugenebaturov.rickandmorty.presentation.viewmodel.character;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.eugenebaturov.rickandmorty.domain.interactor.character.CharacterInteractor;
import com.eugenebaturov.rickandmorty.models.domain.Character;
import com.eugenebaturov.rickandmorty.presentation.viewmodel.AppViewModel;
import com.eugenebaturov.rickandmorty.utils.SchedulerProvider;

import java.util.List;

/**
 * ViewModel для списка персонажей.
 */
public final class CharacterListViewModel extends AppViewModel {

    @NonNull
    private final MutableLiveData<List<Character>> mCharacters = new MutableLiveData<>();

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
     * Метод, в котором поле mCharacters подписывается на источник данных
     * в виде получение информации о персонажах с сервера.
     */
    public final void loadCharacters() {
        disposable = mCharacterInteractor.getCharactersFromRepository()
                .subscribeOn(mSchedulerProvider.io())
                .observeOn(mSchedulerProvider.ui())
                .subscribe(mCharacters::setValue);
    }
}
