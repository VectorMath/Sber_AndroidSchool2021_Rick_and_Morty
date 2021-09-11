package com.eugenebaturov.rickandmorty.domain.interactor;

import com.eugenebaturov.rickandmorty.data.repository.character.CharacterRepository;
import com.eugenebaturov.rickandmorty.domain.interactor.character.CharacterInteractor;
import com.eugenebaturov.rickandmorty.domain.interactor.character.CharacterInteractorImpl;
import com.eugenebaturov.rickandmorty.models.domain.Character;
import com.eugenebaturov.rickandmorty.testdata.CharacterTestData;
import com.google.common.truth.Truth;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

import static org.junit.Assert.assertEquals;

/**
 * Юнит-тест для {@link CharacterInteractorImpl}
 */
@RunWith(MockitoJUnitRunner.class)
public class CharacterInteractorTest {
    private static final int CORRECT_CHARACTER_ID = 1;
    private static final int INCORRECT_CHARACTER_ID = -32;
    private static final String EXCEPTION_MESSAGE_INCORRECT_ID =
            "Error! Character with this ID don't exist!";
    private static final String EXCEPTION_MESSAGE_REPOSITORY_ERROR =
            "Repository Error!";
    private static final String EXCEPTION_MESSAGE_BAD_QUERY =
            "There is nothing here";
    private static final String CHARACTER_NAME_QUERY = "Rick Sanchez";
    private static final String INCORRECT_QUERY = "_30RS_FJDFIK2F_JEFK";

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
        Single<List<Character>> expectedCharacters =
                Single.just(CharacterTestData.createListCharacter());
        Mockito.when(mCharacterRepository.getCharactersFromServer()).thenReturn(expectedCharacters);

        // Act
        Single<List<Character>> actual = mCharacterInteractor.getCharactersFromRepository();

        // Assert
        Truth.assertThat(actual).isEqualTo(expectedCharacters);
    }

    /**
     * Проверка на то, что при конкретном запросе репозиторий выдаст нам ожидаемый список персонажей.
     */
    @Test
    public void testGetSearchedCharactersFromRepository() {
        // Arrange
        Single<List<Character>> expectedCharacters =
                Single.just(CharacterTestData.createSearchedCharacter());
        Mockito
                .when(mCharacterRepository.getSearchedCharacter(CHARACTER_NAME_QUERY))
                .thenReturn(expectedCharacters);

        // Act
        Single<List<Character>> actual =
                mCharacterInteractor.getSearchedCharacterFromRepository(CHARACTER_NAME_QUERY);

        // Assert
        Truth.assertThat(actual).isEqualTo(expectedCharacters);
    }

    /**
     * Проверка на то, что если с репозитория придёт ошибка, мы получим {@link RuntimeException}.
     */
    @Test
    public void testGetErrorFromRepository() {
        Mockito
                .when(mCharacterRepository.getCharactersFromServer())
                .thenThrow(new RuntimeException(EXCEPTION_MESSAGE_REPOSITORY_ERROR));

        try {
            mCharacterInteractor.getCharactersFromRepository();
        } catch (RuntimeException exception) {
            assertEquals(EXCEPTION_MESSAGE_REPOSITORY_ERROR, exception.getMessage());
        }
    }

    /**
     * Проверка на то, что репозиторий передаёт данные о персонаже с конкретным id.
     */
    @Test
    public void testGetCharacterWithCorrectIdFromRepository() {
        // Arrange
        Single<Character> expectedCharacter =
                Single.just(CharacterTestData.createCharacter());
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
     * Проверка на то, что при некорректном запросе из репозитория
     * мы получим {@link RuntimeException}.
     */
    @Test
    public void testGetSearchedErrorFromRepository() {
        Mockito
                .when(mCharacterRepository.getSearchedCharacter(INCORRECT_QUERY))
                .thenThrow(new RuntimeException(EXCEPTION_MESSAGE_BAD_QUERY));

        try {
            mCharacterInteractor.getSearchedCharacterFromRepository(INCORRECT_QUERY);
        } catch (RuntimeException exception) {
            assertEquals(EXCEPTION_MESSAGE_BAD_QUERY, exception.getMessage());
        }
    }

    /**
     * Проверка на то, что с некорректным id персонажа, мы получим {@link RuntimeException}.
     */
    @Test
    public void testCharacterIsNotExist() {
        Mockito
                .when(mCharacterRepository.getCharacterFromServer(INCORRECT_CHARACTER_ID))
                .thenThrow(new RuntimeException(EXCEPTION_MESSAGE_INCORRECT_ID));

        try {
            mCharacterInteractor.getCharacterFromRepository(INCORRECT_CHARACTER_ID);
        } catch (Exception ex) {
            assertEquals(EXCEPTION_MESSAGE_INCORRECT_ID, ex.getMessage());
        }
    }
}
