package com.eugenebaturov.rickandmorty.data.converter.location;

import com.eugenebaturov.rickandmorty.data.converter.Converter;
import com.eugenebaturov.rickandmorty.models.data.list.ListLocationResponse;
import com.eugenebaturov.rickandmorty.models.domain.Location;
import com.eugenebaturov.rickandmorty.testdata.LocationTestData;
import com.google.common.truth.Truth;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Unit-тест для {@link LocationsConverter}.
 */
@RunWith(MockitoJUnitRunner.class)
public class LocationsConverterTest {
    private Converter<ListLocationResponse, List<Location>> mConverter;

    @Before
    public void setUp() {
        mConverter = new LocationsConverter();
    }

    /**
     * Проверка на то, что конвертер правильно преобразует ожидаемые данные.
     */
    @Test
    public void testCorrectConvert() {
        // Arrange
        ListLocationResponse response = LocationTestData.createListResponse();

        // Act
        List<Location> actual = mConverter.convert(response);
        List<Location> expected = LocationTestData.createLocations();

        // Assert
        Truth.assertThat(actual).isEqualTo(expected);
    }

    /**
     * Проверка на то, что конвертер неправильно преобразует ожидаемые данные.
     */
    @Test
    public void testIncorrectConvert() {
        // Arrange
        ListLocationResponse response = LocationTestData.createListResponse();

        // Act
        List<Location> actual = mConverter.convert(response);
        List<String> charactersUrl = new ArrayList<>();
        charactersUrl.add("https://rickandmortyapi.com/api/character/35");
        charactersUrl.add("https://rickandmortyapi.com/api/character/15");
        Location location = new Location(
                252,
                "Unexpected name",
                "Unexpected type",
                "Unexpected dimension",
                charactersUrl
        );
        List<Location> unexpected = new ArrayList<>();
        unexpected.add(location);

        // Assert
        Truth.assertThat(actual).isNotEqualTo(unexpected);
    }
}
