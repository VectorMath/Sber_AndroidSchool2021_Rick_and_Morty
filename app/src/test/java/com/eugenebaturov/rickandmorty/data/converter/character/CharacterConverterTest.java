package com.eugenebaturov.rickandmorty.data.converter.character;

import com.eugenebaturov.rickandmorty.data.utils.Converter;
import com.eugenebaturov.rickandmorty.data.utils.character.CharacterConverter;
import com.eugenebaturov.rickandmorty.models.data.CharacterResponse;
import com.eugenebaturov.rickandmorty.models.data.CurrentLocation;
import com.eugenebaturov.rickandmorty.models.data.Origin;
import com.eugenebaturov.rickandmorty.models.domain.Character;
import com.eugenebaturov.rickandmorty.testdata.CharacterTestData;
import com.google.common.truth.Truth;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Unit-тесты для {@link CharacterConverter}.
 */
@RunWith(MockitoJUnitRunner.class)
public class CharacterConverterTest {

    private Converter<CharacterResponse, Character> mConverter;

    @Before
    public void setUp() {
        mConverter = new CharacterConverter();
    }

    /**
     * Проверка на то, что конвертер правильно преобразует ожидаемые данные.
     */
    @Test
    public void testCorrectConvert() {
        // Arrange
        CharacterResponse response = CharacterTestData.createResponse();

        // Act
        Character actual = mConverter.convert(response);
        Character expected = CharacterTestData.createCharacter();

        // Assert
        Truth.assertThat(actual).isEqualTo(expected);
    }

    /**
     * Проверка на то некорректную конвертацию.
     */
    @Test
    public void testIncorrectConvert() {
        // Arrange
        CharacterResponse response = CharacterTestData.createResponse();

        // Act
        Character actual = mConverter.convert(response);

        Origin testOrigin = new Origin(
                "Earth (C-137)",
                "https://rickandmortyapi.com/api/location/1");
        CurrentLocation testCurrentLocation = new CurrentLocation(
                "Earth (Replacement Dimension)",
                "https://rickandmortyapi.com/api/location/20");
        List<String> testEpisodesUrl = new ArrayList<>();
        testEpisodesUrl.add("https://rickandmortyapi.com/api/episode/20");
        testEpisodesUrl.add("https://rickandmortyapi.com/api/episode/16");
        testEpisodesUrl.add("https://rickandmortyapi.com/api/episode/5");

        Character unexpected = new Character(1,
                "Not Rick",
                "Alive",
                "Human",
                "Scientist",
                "Male",
                "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
                testOrigin,
                testCurrentLocation,
                testEpisodesUrl);

        // Assert
        Truth.assertThat(actual).isNotEqualTo(unexpected);
    }
}
