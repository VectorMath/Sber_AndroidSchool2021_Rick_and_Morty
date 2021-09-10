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

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;

/**
 * Unit-тест для {@link CharacterViewModel}.
 */
@RunWith(MockitoJUnitRunner.class)
public class CharacterViewModelTest {
    private final static int CORRECT_ID = 1;
    private final static int INCORRECT_ID = -2;

    @Mock
    private SchedulerProvider mSchedulerProvider;

    @Mock
    private CharacterInteractor mCharacterInteractor;

    @Mock
    private Observer<Character> mCharacter;

    @Mock
    private Observer<Boolean> mProgress;

    @Mock
    private Observer<Throwable> mError;

    private CharacterViewModel mCharacterViewModel;

    @Rule
    public final InstantTaskExecutorRule mRule = new InstantTaskExecutorRule();

    @Before
    public void setUp() {
        mCharacterViewModel = new CharacterViewModel(mSchedulerProvider, mCharacterInteractor);

        mCharacterViewModel.getCharacter().observeForever(mCharacter);
        mCharacterViewModel.getProgress().observeForever(mProgress);
        mCharacterViewModel.getError().observeForever(mError);

        Mockito.when(mSchedulerProvider.io()).thenReturn(Schedulers.trampoline());
        Mockito.when(mSchedulerProvider.ui()).thenReturn(Schedulers.trampoline());
    }

    /**
     * Проверка на то, что после подписки мы получим ожидаемую информацию о персонаже.
     */
    @Test
    public void testLoadCharacterById() {
        // Arrange
        Mockito
                .when(mCharacterInteractor.getCharacterFromRepository(CORRECT_ID))
                .thenReturn(Single.just(CharacterTestData.createCharacter()));

        // Act
        InOrder inOrder = Mockito.inOrder(mError, mCharacter, mProgress);
        mCharacterViewModel.loadCharacterById(CORRECT_ID);

        // Assert
        inOrder.verify(mProgress).onChanged(true);
        inOrder.verify(mCharacter).onChanged(CharacterTestData.createCharacter());
        inOrder.verify(mProgress).onChanged(false);
        inOrder.verifyNoMoreInteractions();
    }

    /**
     * Проверка на то, что при указание неверного id при подписке, мы получим
     * {@link NullPointerException}.
     */
    @Test
    public void testLoadCharacterByIncorrectId() {
        Mockito
                .when(mCharacterInteractor.getCharacterFromRepository(INCORRECT_ID))
                .thenReturn(Single.error(NullPointerException::new));

        mCharacterViewModel.loadCharacterById(INCORRECT_ID);

        Mockito.verify(mError).onChanged(ArgumentMatchers.isA(NullPointerException.class));
    }
}
