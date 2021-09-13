package com.eugenebaturov.rickandmorty.data.converter.location;

import com.eugenebaturov.rickandmorty.data.utils.Converter;
import com.eugenebaturov.rickandmorty.data.utils.episode.EpisodeConverter;
import com.eugenebaturov.rickandmorty.data.utils.location.LocationConverter;
import com.eugenebaturov.rickandmorty.models.data.EpisodeResponse;
import com.eugenebaturov.rickandmorty.models.data.LocationResponse;
import com.eugenebaturov.rickandmorty.models.domain.Episode;
import com.eugenebaturov.rickandmorty.models.domain.Location;
import com.eugenebaturov.rickandmorty.testdata.EpisodeTestData;
import com.eugenebaturov.rickandmorty.testdata.LocationTestData;
import com.google.common.truth.Truth;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Unit-тест для {@link LocationConverter}.
 */
@RunWith(MockitoJUnitRunner.class)
public class LocationConverterTest {
    private Converter<LocationResponse, Location> mConverter;

    @Before
    public void setUp() {
        mConverter = new LocationConverter();
    }

    /**
     * Проверка на то, что конвертер правильно преобразует ожидаемые данные.
     */
    @Test
    public void testCorrectConvert() {
        // Arrange
        LocationResponse response = LocationTestData.createResponse();

        // Act
        Location actual = mConverter.convert(response);
        Location expected = LocationTestData.createLocation();

        // Assert
        Truth.assertThat(actual).isEqualTo(expected);
    }

    /**
     * Проверка на то, что конвертер неправильно преобразует ожидаемые данные.
     */
    @Test
    public void testIncorrectConvert() {
        // Arrange
        LocationResponse response = LocationTestData.createResponse();

        // Act
        Location actual = mConverter.convert(response);
        List<String> charactersUrl = new ArrayList<>();
        charactersUrl.add("https://rickandmortyapi.com/api/character/35");
        charactersUrl.add("https://rickandmortyapi.com/api/character/15");
        Location unexpected = new Location(
                252,
                "Unexpected name",
                "Unexpected type",
                "Unexpected dimension",
                charactersUrl
        );

        // Assert
        Truth.assertThat(actual).isNotEqualTo(unexpected);
    }
}
