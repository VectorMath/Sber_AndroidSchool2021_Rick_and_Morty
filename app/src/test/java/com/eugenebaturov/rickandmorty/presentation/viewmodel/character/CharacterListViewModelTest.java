package com.eugenebaturov.rickandmorty.presentation.viewmodel.character;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.Observer;

import com.eugenebaturov.rickandmorty.domain.interactor.character.CharacterInteractor;
import com.eugenebaturov.rickandmorty.models.data.CurrentLocation;
import com.eugenebaturov.rickandmorty.models.data.Origin;
import com.eugenebaturov.rickandmorty.models.domain.Character;
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

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;

/**
 * Unit-тест для {@link CharacterListViewModel}.
 */
@RunWith(MockitoJUnitRunner.class)
public class CharacterListViewModelTest {

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
                .thenReturn(Single.just(createTestData()));

        // Act
        mCharacterListViewModel.loadCharacters();

        // Assert
        Mockito.verify(mCharacters).onChanged(createTestData());
    }

    /**
     * Проверка на то, что методы вызывутся в нужном порядке.
     */
    @Test
    public void testLoadCharactersInOrder() {
        // Arrange
        Mockito
                .when(mCharacterInteractor.getCharactersFromRepository())
                .thenReturn(Single.just(createTestData()));

        // Act
        mCharacterListViewModel.loadCharacters();
        InOrder inOrder = Mockito.inOrder(mError, mCharacters, mProgress);

        // Assert
        inOrder.verify(mProgress).onChanged(true);
        inOrder.verify(mCharacters).onChanged(createTestData());
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

    private List<Character> createTestData() {
        List<Character> characters = new ArrayList<>();

        List<String> firstCharactersListUrlEpisode = new ArrayList<>();
        firstCharactersListUrlEpisode.add("https://rickandmortyapi.com/api/episode/17");
        firstCharactersListUrlEpisode.add("https://rickandmortyapi.com/api/episode/13");
        firstCharactersListUrlEpisode.add("https://rickandmortyapi.com/api/episode/31");

        Character firstCharacter = new Character(
                1,
                "Rick Sanchez",
                "Alive",
                "Human",
                "Scientist",
                "Male",
                "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
                new Origin(
                        "Earth (C-137)",
                        "https://rickandmortyapi.com/api/location/1"
                ),
                new CurrentLocation(
                        "Earth (Replacement Dimension)",
                        "https://rickandmortyapi.com/api/location/20"
                ),
                firstCharactersListUrlEpisode
        );

        List<String> secondCharactersListUrlEpisode = new ArrayList<>();
        secondCharactersListUrlEpisode.add("https://rickandmortyapi.com/api/episode/7");
        secondCharactersListUrlEpisode.add("https://rickandmortyapi.com/api/episode/23");
        secondCharactersListUrlEpisode.add("https://rickandmortyapi.com/api/episode/1");

        Character secondCharacter = new Character(
                1,
                "Rick Smith",
                "Dead",
                "Human",
                "Gay",
                "Java developer",
                "https://rickandmortyapi.com/api/character/avatar/14.jpeg",
                new Origin(
                        "Earth (C-137)",
                        "https://rickandmortyapi.com/api/location/1"
                ),
                new CurrentLocation(
                        "Earth (Replacement Dimension)",
                        "https://rickandmortyapi.com/api/location/20"
                ),
                secondCharactersListUrlEpisode
        );

        characters.add(firstCharacter);
        characters.add(secondCharacter);

        return characters;
    }
}
