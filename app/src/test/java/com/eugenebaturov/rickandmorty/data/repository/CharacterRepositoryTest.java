package com.eugenebaturov.rickandmorty.data.repository;

import com.eugenebaturov.rickandmorty.data.api.CharacterApi;
import com.eugenebaturov.rickandmorty.data.repository.character.CharacterRepository;
import com.eugenebaturov.rickandmorty.data.repository.character.CharacterRepositoryImpl;
import com.eugenebaturov.rickandmorty.models.data.CharacterResponse;
import com.eugenebaturov.rickandmorty.models.data.list.ListCharacterResponse;
import com.eugenebaturov.rickandmorty.models.domain.Character;
import com.eugenebaturov.rickandmorty.testdata.CharacterTestData;

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

import static com.eugenebaturov.rickandmorty.testdata.CharacterTestData.createCharacter;
import static com.eugenebaturov.rickandmorty.testdata.CharacterTestData.createResponse;
import static org.junit.Assert.assertEquals;

/**
 * Юнит-тесты для {@link CharacterRepositoryImpl}.
 */
@RunWith(MockitoJUnitRunner.class)
public class CharacterRepositoryTest {

    @Rule
    public final MockitoRule mockitoRule = MockitoJUnit.rule();


    private static final int CORRECT_CHARACTER_ID = 1;
    private static final int INCORRECT_CHARACTER_ID = -225;
    private static final String EXCEPTION_MESSAGE_INCORRECT_ID =
            "Error! Character with this ID don't exist!";
    private static final String EXCEPTION_MESSAGE_SERVER_ERROR =
            "Server Error!";

    private CharacterApi mApi;
    private CharacterRepository mRepository;

    @Before
    public void setUp() {
        mApi = Mockito.mock(CharacterApi.class);
        mRepository = new CharacterRepositoryImpl(mApi);
    }

    /**
     * Проверка на то, что с сервера приходят нужные данные в виде {@link ListCharacterResponse}
     * и после они обрабатываются в ожидаемый {@link List}<{@link Character}>.
     */
    @Test
    public void testGetCharactersFromServer() {
        // Arrange
        Single<ListCharacterResponse> serverResponse =
                Single.just(CharacterTestData.createListResponse());
        Mockito.when(mApi.getAllCharacters()).thenReturn(serverResponse);

        // Act
        Single<List<Character>> actual = null;
        actual = mRepository.getCharactersFromServer();
        List<Character> expected = CharacterTestData.createListCharacter();

        // Assert
        actual.test().assertValue(expected);
    }

    /**
     * Проверка на то, что если с сервера придёт ошибка, мы получим {@link RuntimeException}.
     */
    @Test
    public void testGetErrorFromServer() {
        Mockito
                .when(mApi.getAllCharacters())
                .thenThrow(new RuntimeException(EXCEPTION_MESSAGE_SERVER_ERROR));

        try {
            mRepository.getCharactersFromServer();
        } catch (RuntimeException exception) {
            assertEquals(EXCEPTION_MESSAGE_SERVER_ERROR, exception.getMessage());
        }
    }

    /**
     * Проверка на то, что с сервера придут нужные данные о персонаже
     * виде {@link CharacterResponse}, и после мы обрабатываем в ожидаемый {@link Character}.
     */
    @Test
    public void testGetCharacterFromServerWithCorrectId() {
        // Arrange
        Single<CharacterResponse> serverResponse =
                Single.just(createResponse());
        Mockito.when(mApi.getCharacterById(CORRECT_CHARACTER_ID)).thenReturn(serverResponse);

        // Act
        Single<Character> actual = mRepository.getCharacterFromServer(CORRECT_CHARACTER_ID);
        Character expected = createCharacter();

        // Assert
        actual.test().assertValue(expected);
    }

    /**
     * Проверка на то, что с некорректным id персонажа, мы получим {@link RuntimeException}.
     */
    @Test
    public void testCharacterIsNotExist() {
        Mockito
                .when(mApi.getCharacterById(INCORRECT_CHARACTER_ID))
                .thenThrow(new RuntimeException(EXCEPTION_MESSAGE_INCORRECT_ID));

        try {
            mRepository.getCharacterFromServer(INCORRECT_CHARACTER_ID);
        } catch (Exception ex) {
            assertEquals(EXCEPTION_MESSAGE_INCORRECT_ID, ex.getMessage());
        }
    }
}
