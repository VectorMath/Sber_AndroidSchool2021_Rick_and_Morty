package com.eugenebaturov.rickandmorty.presentation.viewmodel.character;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.eugenebaturov.rickandmorty.domain.interactor.character.CharacterInteractor;
import com.eugenebaturov.rickandmorty.models.domain.Character;
import com.eugenebaturov.rickandmorty.presentation.viewmodel.AppViewModel;
import com.eugenebaturov.rickandmorty.utils.SchedulerProvider;

/**
 * ViewModel для персонажа.
 */
public final class CharacterViewModel extends AppViewModel {

    @NonNull
    private final MutableLiveData<Character> mCharacter = new MutableLiveData<>();

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
     * Метод, в котором поле mCharacter подписывается на источник данных
     * в виде получение информации о персонаже с конкретным id с сервера.
     *
     * @param characterId id персонажа.
     */
    public final void loadCharacterById(final int characterId) {
        disposable = mCharacterInteractor
                .getCharacterFromRepository(characterId)
                .subscribeOn(mSchedulerProvider.io())
                .observeOn(mSchedulerProvider.ui())
                .subscribe(mCharacter::setValue);
    }
}