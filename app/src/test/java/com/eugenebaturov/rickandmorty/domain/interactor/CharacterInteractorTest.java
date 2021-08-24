package com.eugenebaturov.rickandmorty.domain.interactor;

import com.eugenebaturov.rickandmorty.data.repository.character.CharacterRepository;
import com.eugenebaturov.rickandmorty.domain.interactor.character.CharacterInteractor;
import com.eugenebaturov.rickandmorty.domain.interactor.character.CharacterInteractorImpl;
import com.eugenebaturov.rickandmorty.models.data.CurrentLocation;
import com.eugenebaturov.rickandmorty.models.data.Origin;
import com.eugenebaturov.rickandmorty.models.domain.Character;
import com.google.common.truth.Truth;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.core.Single;

/**
 * Юнит-тест для {@link CharacterInteractorImpl}
 */
@RunWith(MockitoJUnitRunner.class)
public class CharacterInteractorTest {
    private static final int CORRECT_CHARACTER_ID = 1;
    private static final int INCORRECT_CHARACTER_ID = -32;

    private CharacterRepository mCharacterRepository;
    private CharacterInteractor mCharacterInteractor;

    @Rule
    public final MockitoRule mockitoRule = MockitoJUnit.rule();

    @Before
    public void setUp() {
        mCharacterRepository = Mockito.mock(CharacterRepository.class);
        mCharacterInteractor = new CharacterInteractorImpl(mCharacterRepository);
    }

    /**
     * Проверка на то, что из репозитория приходит ожидаемый список персонажей.
     */
    @Test
    public void testGetCharactersFromRepository() {
        // Arrange
        Single<List<Character>> expectedCharacters = createTestListCharacters();
        Mockito.when(mCharacterRepository.getCharactersFromServer()).thenReturn(expectedCharacters);

        // Act
        Single<List<Character>> actual = mCharacterInteractor.getCharactersFromRepository();

        // Assert
        Truth.assertThat(actual).isEqualTo(expectedCharacters);
    }

    /**
     * Проверка на то, что из репозитория ничего не придёт
     */
    @Test
    public void testGetNullCharactersFromRepository() {
        // Arrange
        Mockito.when(mCharacterRepository.getCharactersFromServer()).thenReturn(null);

        // Act
        Single<List<Character>> actual = mCharacterInteractor.getCharactersFromRepository();

        // Arrange
        Truth.assertThat(actual).isNull();
    }

    /**
     * Проверка на то, что репозиторий передаёт данные о персонаже с конкретным id.
     */
    @Test
    public void testGetCharacterWithCorrectIdFromRepository() {
        // Arrange
        Single<Character> expectedCharacter =
                Single.just(createExpectedCharacter());
        Mockito
                .when(mCharacterRepository.getCharacterFromServer(CORRECT_CHARACTER_ID))
                .thenReturn(expectedCharacter);

        // Act
        Single<Character> actualCharacter =
                mCharacterInteractor.getCharacterFromRepository(CORRECT_CHARACTER_ID);

        // Assert
        Truth.assertThat(actualCharacter).isEqualTo(expectedCharacter);
    }

    /**
     * Проверка на то, что при некорректном id из репозитория придёт null.
     */
    @Test(expected = NullPointerException.class)
    public void testGetNullCharacterWithIncorrectIdFromRepository() {
        // Arrange
        Single<Character> expectedNull =
                Single.just(null);
        Mockito
                .when(mCharacterRepository.getCharacterFromServer(INCORRECT_CHARACTER_ID))
                .thenReturn(expectedNull);

        // Act
        mCharacterInteractor.getCharacterFromRepository(INCORRECT_CHARACTER_ID);
    }

    private Single<List<Character>> createTestListCharacters() {
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

        return Single.just(characters);
    }

    private Character createExpectedCharacter() {
        List<String> firstCharactersListUrlEpisode = new ArrayList<>();
        firstCharactersListUrlEpisode.add("https://rickandmortyapi.com/api/episode/17");
        firstCharactersListUrlEpisode.add("https://rickandmortyapi.com/api/episode/13");
        firstCharactersListUrlEpisode.add("https://rickandmortyapi.com/api/episode/31");

        return new Character(
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
    }
}
