package com.eugenebaturov.rickandmorty.data.converter.character;

import com.eugenebaturov.rickandmorty.R;
import com.eugenebaturov.rickandmorty.data.converter.Converter;
import com.eugenebaturov.rickandmorty.models.data.CurrentLocation;
import com.eugenebaturov.rickandmorty.models.data.Origin;
import com.eugenebaturov.rickandmorty.models.data.list.ListCharacterResponse;
import com.eugenebaturov.rickandmorty.models.domain.Character;
import com.eugenebaturov.rickandmorty.testdata.CharacterTestData;
import com.google.common.truth.Truth;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CharactersConverterTest {
    private Converter<ListCharacterResponse, List<Character>> mConverter;

    @Before
    public void setUp() {
        mConverter = new CharactersConverter();
    }

    /**
     * Проверка на то, что конвертер правильно преобразует ожидаемые данные.
     */
    @Test
    public void testCorrectConvert() {
        // Arrange
        ListCharacterResponse response = CharacterTestData.createListResponse();

        // Act
        List<Character> actual = mConverter.convert(response);
        List<Character> expected = CharacterTestData.createListCharacter();

        // Assert
        Truth.assertThat(actual).isEqualTo(expected);
    }

    /**
     * Проверка на то, что конвертер неправильно преобразует ожидаемые данные.
     */
    @Test
    public void testIncorrectConvert() {
        // Arrange
        ListCharacterResponse response = CharacterTestData.createListResponse();

        // Act
        List<Character> actual = mConverter.convert(response);
        List<Character> unexpected = new ArrayList<>();

        Origin firstOrigin = new Origin(
                "Earth (C-137)",
                "https://rickandmortyapi.com/api/location/1");
        CurrentLocation firstCurrentLocation = new CurrentLocation(
                "Earth (Replacement Dimension)",
                "https://rickandmortyapi.com/api/location/20");
        List<String> firstEpisodesUrl = new ArrayList<>();
        firstEpisodesUrl.add("https://rickandmortyapi.com/api/episode/20");
        firstEpisodesUrl.add("https://rickandmortyapi.com/api/episode/16");
        firstEpisodesUrl.add("https://rickandmortyapi.com/api/episode/5");

        Character firstCharacter = new Character(
                1,
                "Rick San",
                "Alive",
                R.drawable.ic_status_alive,
                "Human",
                "Scientist",
                "Male",
                "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
                firstOrigin,
                1,
                firstCurrentLocation,
                20,
                firstEpisodesUrl
        );

        Origin secondOrigin = new Origin(
                "Earth (C-137)",
                "https://rickandmortyapi.com/api/location/1");
        CurrentLocation secondCurrentLocation = new CurrentLocation(
                "Earth (Replacement Dimension)",
                "https://rickandmortyapi.com/api/location/20");
        List<String> secondEpisodesUrl = new ArrayList<>();
        secondEpisodesUrl.add("https://rickandmortyapi.com/api/episode/4");
        secondEpisodesUrl.add("https://rickandmortyapi.com/api/episode/10");
        secondEpisodesUrl.add("https://rickandmortyapi.com/api/episode/17");

        Character secondCharacter = new Character(
                2,
                "Morty Steve",
                "Alive",
                R.drawable.ic_status_alive,
                "Human",
                "Faggot",
                "Male",
                "https://rickandmortyapi.com/api/character/avatar/2.jpeg",
                secondOrigin,
                1,
                secondCurrentLocation,
                20,
                secondEpisodesUrl
        );

        unexpected.add(firstCharacter);
        unexpected.add(secondCharacter);

        // Assert
        Truth.assertThat(actual).isNotEqualTo(unexpected);
    }
}
