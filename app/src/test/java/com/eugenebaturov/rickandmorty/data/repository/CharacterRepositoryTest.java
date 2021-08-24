package com.eugenebaturov.rickandmorty.data.repository;

import com.eugenebaturov.rickandmorty.data.api.CharacterApi;
import com.eugenebaturov.rickandmorty.data.repository.character.CharacterRepository;
import com.eugenebaturov.rickandmorty.data.repository.character.CharacterRepositoryImpl;
import com.eugenebaturov.rickandmorty.models.data.CharacterResponse;
import com.eugenebaturov.rickandmorty.models.data.CurrentLocation;
import com.eugenebaturov.rickandmorty.models.data.Origin;
import com.eugenebaturov.rickandmorty.models.data.list.ListCharacterResponse;
import com.eugenebaturov.rickandmorty.models.domain.Character;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.core.Single;

/**
 * Юнит-тесты для {@link CharacterRepositoryImpl}.
 */
@RunWith(MockitoJUnitRunner.class)
public class CharacterRepositoryTest {

    @Rule
    public final MockitoRule mockitoRule = MockitoJUnit.rule();

    private static final int CORRECT_CHARACTER_ID = 1;
    private static final int INCORRECT_CHARACTER_ID = -225;

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
                Single.just(createTestListCharacterResponse());
        Mockito.when(mApi.getAllCharacters()).thenReturn(serverResponse);

        // Act
        Single<List<Character>> actual = mRepository.getCharactersFromServer();
        List<Character> expected = createExpectedCharactersList();

        // Assert
        actual.test().assertValue(expected);
    }

    /**
     * Проверка на то, что если с сервера придёт null, мы получим {@link NullPointerException}.
     */
    @Test(expected = NullPointerException.class)
    public void testGetNullCharactersFromServer() {
        Single<ListCharacterResponse> serverResponse =
                Single.just(null);
        Mockito.when(mApi.getAllCharacters()).thenReturn(serverResponse);

        mRepository.getCharactersFromServer();
    }

    /**
     * Проверка на то, что с сервера придут нужные данные о персонаже
     * виде {@link CharacterResponse}, и после мы обрабатываем в ожидаемый {@link Character}.
     */
    @Test
    public void testGetCharacterFromServerWithCorrectId() {
        // Arrange
        Single<CharacterResponse> serverResponse =
                Single.just(createTestCharacterResponse());
        Mockito.when(mApi.getCharacterById(CORRECT_CHARACTER_ID)).thenReturn(serverResponse);

        // Act
        Single<Character> actual = mRepository.getCharacterFromServer(CORRECT_CHARACTER_ID);
        Character expected = createExpectedCharacter();

        // Assert
        actual.test().assertValue(expected);
    }

    /**
     * Проверка на то, что с некорректным id персонажа, мы получим {@link NullPointerException}.
     */
    @Test(expected = NullPointerException.class)
    public void testGetNullCharacterFromServerWithIncorrectId() {
        mRepository.getCharacterFromServer(INCORRECT_CHARACTER_ID);
    }

    private ListCharacterResponse createTestListCharacterResponse() {
        List<CharacterResponse> charactersResponses = new ArrayList<>();

        Origin firstTestOrigin = new Origin(
                "Earth (C-137)",
                "https://rickandmortyapi.com/api/location/1");
        CurrentLocation firstTestCurrentLocation = new CurrentLocation(
                "Earth (Replacement Dimension)",
                "https://rickandmortyapi.com/api/location/20");
        List<String> firstTestEpisodesUrl = new ArrayList<>();
        firstTestEpisodesUrl.add("https://rickandmortyapi.com/api/episode/20");
        firstTestEpisodesUrl.add("https://rickandmortyapi.com/api/episode/16");
        firstTestEpisodesUrl.add("https://rickandmortyapi.com/api/episode/5");

        charactersResponses.add(new CharacterResponse(
                1,
                "Rick Sanchez",
                "Alive",
                "Human",
                "Scientist",
                "Male",
                "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
                firstTestOrigin,
                firstTestCurrentLocation,
                firstTestEpisodesUrl
        ));

        Origin secondTestOrigin = new Origin(
                "Earth (C-137)",
                "https://rickandmortyapi.com/api/location/1");
        CurrentLocation secondTestCurrentLocation = new CurrentLocation(
                "Earth (Replacement Dimension)",
                "https://rickandmortyapi.com/api/location/20");
        List<String> secondTestEpisodesUrl = new ArrayList<>();
        secondTestEpisodesUrl.add("https://rickandmortyapi.com/api/episode/4");
        secondTestEpisodesUrl.add("https://rickandmortyapi.com/api/episode/10");
        secondTestEpisodesUrl.add("https://rickandmortyapi.com/api/episode/17");

        charactersResponses.add(new CharacterResponse(
                2,
                "Morty Smith",
                "Alive",
                "Human",
                "Faggot",
                "Male",
                "https://rickandmortyapi.com/api/character/avatar/2.jpeg",
                secondTestOrigin,
                secondTestCurrentLocation,
                secondTestEpisodesUrl
        ));


        return new ListCharacterResponse(charactersResponses);
    }

    private List<Character> createExpectedCharactersList() {
        List<Character> characters = new ArrayList<>();

        Origin firstTestOrigin = new Origin(
                "Earth (C-137)",
                "https://rickandmortyapi.com/api/location/1");
        CurrentLocation firstTestCurrentLocation = new CurrentLocation(
                "Earth (Replacement Dimension)",
                "https://rickandmortyapi.com/api/location/20");
        List<String> firstTestEpisodesUrl = new ArrayList<>();
        firstTestEpisodesUrl.add("https://rickandmortyapi.com/api/episode/20");
        firstTestEpisodesUrl.add("https://rickandmortyapi.com/api/episode/16");
        firstTestEpisodesUrl.add("https://rickandmortyapi.com/api/episode/5");

        CharacterResponse firstTestCharacter = new CharacterResponse(
                1,
                "Rick Sanchez",
                "Alive",
                "Human",
                "Scientist",
                "Male",
                "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
                firstTestOrigin,
                firstTestCurrentLocation,
                firstTestEpisodesUrl
        );

        Origin secondTestOrigin = new Origin(
                "Earth (C-137)",
                "https://rickandmortyapi.com/api/location/1");
        CurrentLocation secondTestCurrentLocation = new CurrentLocation(
                "Earth (Replacement Dimension)",
                "https://rickandmortyapi.com/api/location/20");
        List<String> secondTestEpisodesUrl = new ArrayList<>();
        secondTestEpisodesUrl.add("https://rickandmortyapi.com/api/episode/4");
        secondTestEpisodesUrl.add("https://rickandmortyapi.com/api/episode/10");
        secondTestEpisodesUrl.add("https://rickandmortyapi.com/api/episode/17");

        CharacterResponse secondCharacterResponse = new CharacterResponse(
                2,
                "Morty Smith",
                "Alive",
                "Human",
                "Faggot",
                "Male",
                "https://rickandmortyapi.com/api/character/avatar/2.jpeg",
                secondTestOrigin,
                secondTestCurrentLocation,
                secondTestEpisodesUrl
        );

        characters.add(new Character(firstTestCharacter));
        characters.add(new Character(secondCharacterResponse));

        return characters;
    }

    private CharacterResponse createTestCharacterResponse() {
        Origin firstTestOrigin = new Origin(
                "Earth (C-137)",
                "https://rickandmortyapi.com/api/location/1");
        CurrentLocation firstTestCurrentLocation = new CurrentLocation(
                "Earth (Replacement Dimension)",
                "https://rickandmortyapi.com/api/location/20");
        List<String> firstTestEpisodesUrl = new ArrayList<>();
        firstTestEpisodesUrl.add("https://rickandmortyapi.com/api/episode/20");
        firstTestEpisodesUrl.add("https://rickandmortyapi.com/api/episode/16");
        firstTestEpisodesUrl.add("https://rickandmortyapi.com/api/episode/5");

        return new CharacterResponse(
                1,
                "Rick Sanchez",
                "Alive",
                "Human",
                "Scientist",
                "Male",
                "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
                firstTestOrigin,
                firstTestCurrentLocation,
                firstTestEpisodesUrl
        );
    }

    private Character createExpectedCharacter() {
        return new Character(createTestCharacterResponse());
    }
}
