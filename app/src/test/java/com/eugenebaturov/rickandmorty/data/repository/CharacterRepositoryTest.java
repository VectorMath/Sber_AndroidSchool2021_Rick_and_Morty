package com.eugenebaturov.rickandmorty.data.repository;

import com.eugenebaturov.rickandmorty.data.api.CharacterApi;
import com.eugenebaturov.rickandmorty.data.repository.character.CharacterRepository;
import com.eugenebaturov.rickandmorty.data.repository.character.CharacterRepositoryImpl;
import com.eugenebaturov.rickandmorty.models.data.CharacterResponse;
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

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.core.Single;

@RunWith(MockitoJUnitRunner.class)
public class CharacterRepositoryTest {

    @Rule
    public final MockitoRule mockitoRule = MockitoJUnit.rule();

    private CharacterApi mApi;
    private CharacterRepository mRepository;

    @Before
    public void setUp() {
        mApi = Mockito.mock(CharacterApi.class);
        mRepository = new CharacterRepositoryImpl(mApi);
    }

    @Test
    public void testGetCharactersFromServer() {
        // Arrange
        Single<ListCharacterResponse> serverResponse = Single.just(createTestData());
        Mockito.when(mApi.getAllCharacters()).thenReturn(serverResponse);

        // Act
        Single<List<Character>> actual = mRepository.getAllCharacters();
        List<Character> expected = createExpectedData();

        // Assert
        actual.test().assertValue(expected);
    }

    private ListCharacterResponse createTestData() {
        ListCharacterResponse listCharacterResponse = new ListCharacterResponse();
        List<CharacterResponse> characterResponses = new ArrayList<>();

        characterResponses.add(new CharacterResponse());
        listCharacterResponse.setCharacters(characterResponses);

        return listCharacterResponse;
    }

    private List<Character> createExpectedData() {
        List<Character> characters = new ArrayList<>();
        characters.add(new Character(new CharacterResponse()));

        return characters;
    }
}
