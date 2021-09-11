package com.eugenebaturov.rickandmorty.presentation.viewmodel.character;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.Observer;

import com.eugenebaturov.rickandmorty.domain.interactor.character.CharacterInteractor;
import com.eugenebaturov.rickandmorty.models.domain.Character;
import com.eugenebaturov.rickandmorty.testdata.CharacterTestData;
import com.eugenebaturov.rickandmorty.utils.SchedulerProvider;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;

/**
 * Unit-тест для {@link CharacterListViewModel}.
 */
@RunWith(MockitoJUnitRunner.class)
public class CharacterListViewModelTest {
    private static final String CHARACTER_NAME_QUERY = "Rick Sanchez";
    private static final String INCORRECT_QUERY = "_30RS_FJDFIK2F_JEFK";

    @Mock
    private SchedulerProvider mSchedulerProvider;

    @Mock
    private CharacterInteractor mCharacterInteractor;

    @Mock
    private Observer<List<Character>> mCharacters;

    @Mock
    private Observer<Boolean> mProgress;

    @Mock
    private Observer<Throwable> mError;

    private CharacterListViewModel mCharacterListViewModel;


    @Rule
    public final InstantTaskExecutorRule mRule = new InstantTaskExecutorRule();

    @Before
    public void setUp() {
        Mockito.when(mSchedulerProvider.io()).thenReturn(Schedulers.trampoline());
        Mockito.when(mSchedulerProvider.ui()).thenReturn(Schedulers.trampoline());

        mCharacterListViewModel =
                new CharacterListViewModel(mSchedulerProvider, mCharacterInteractor);

        mCharacterListViewModel
                .getCharacters().observeForever(mCharacters);
        mCharacterListViewModel
                .getError().observeForever(mError);
        mCharacterListViewModel
                .getProgress().observeForever(mProgress);
    }

    /**
     * Проверка на то, что после подписки мы получим ожидаемые тестовые данные.
     */
    @Test
    public void testLoadCharacters() {
        // Arrange
        Mockito
                .when(mCharacterInteractor.getCharactersFromRepository())
                .thenReturn(Single.just(CharacterTestData.createListCharacter()));

        // Act
        mCharacterListViewModel.loadCharacters();
        InOrder inOrder = Mockito.inOrder(mError, mCharacters, mProgress);

        // Assert
        inOrder.verify(mProgress).onChanged(true);
        inOrder.verify(mCharacters).onChanged(CharacterTestData.createListCharacter());
        inOrder.verify(mProgress).onChanged(false);
        inOrder.verifyNoMoreInteractions();
    }

    /**
     * Проверка на то, что после подписки с конкретным запросом
     * мы получим ожидаемые тестовые данные.
     */
    @Test
    public void testLoadCharactersWithQuery() {
        // Arrange
        Mockito
                .when(mCharacterInteractor.getSearchedCharacterFromRepository(CHARACTER_NAME_QUERY))
                .thenReturn(Single.just(CharacterTestData.createSearchedCharacter()));

        // Act
        mCharacterListViewModel.loadCharacters(CHARACTER_NAME_QUERY);
        InOrder inOrder = Mockito.inOrder(mError, mCharacters, mProgress);

        // Assert
        inOrder.verify(mProgress).onChanged(true);
        inOrder.verify(mCharacters).onChanged(CharacterTestData.createSearchedCharacter());
        inOrder.verify(mProgress).onChanged(false);
        inOrder.verifyNoMoreInteractions();
    }

    /**
     * Проверка на то, что если интерактор вернёт {@link IllegalAccessException},
     * то и наша вью-моделька получит её.
     */
    @Test
    public void testLoadCharactersWithError() {
        // Arrange
        Mockito
                .when(mCharacterInteractor.getCharactersFromRepository())
                .thenReturn(Single.error(new IllegalAccessException()));

        // Act
        mCharacterListViewModel.loadCharacters();

        // Assert
        Mockito.verify(mError).onChanged(ArgumentMatchers.isA(IllegalAccessException.class));
    }

    /**
     * Проверка на то, что если интерактор вернёт {@link IllegalAccessException},
     * то и наша вью-моделька получит её.
     */
    @Test
    public void testLoadQueryCharactersWithError() {
        // Arrange
        Mockito
                .when(mCharacterInteractor.getSearchedCharacterFromRepository(INCORRECT_QUERY))
                .thenReturn(Single.error(new IllegalAccessException()));

        // Act
        mCharacterListViewModel.loadCharacters(INCORRECT_QUERY);

        // Assert
        Mockito.verify(mError).onChanged(ArgumentMatchers.isA(IllegalAccessException.class));
    }
}
