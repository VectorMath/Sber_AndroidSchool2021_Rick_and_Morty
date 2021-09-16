package com.eugenebaturov.rickandmorty.data.converter.episode;

import com.eugenebaturov.rickandmorty.data.converter.Converter;
import com.eugenebaturov.rickandmorty.models.data.EpisodeResponse;
import com.eugenebaturov.rickandmorty.models.domain.Episode;
import com.eugenebaturov.rickandmorty.testdata.EpisodeTestData;
import com.google.common.truth.Truth;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Unit-тест для {@link EpisodeConverter}.
 */
@RunWith(MockitoJUnitRunner.class)
public class EpisodeConverterTest {
    private Converter<EpisodeResponse, Episode> mConverter;

    @Before
    public void setUp() {
        mConverter = new EpisodeConverter();
    }

    /**
     * Проверка на то, что конвертер правильно преобразует ожидаемые данные.
     */
    @Test
    public void testCorrectConvert() {
        // Arrange
        EpisodeResponse response = EpisodeTestData.createResponse();

        // Act
        Episode actual = mConverter.convert(response);
        Episode expected = EpisodeTestData.createEpisode();

        // Assert
        Truth.assertThat(actual).isEqualTo(expected);
    }

    /**
     * Проверка на то, что конвертер неправильно преобразует ожидаемые данные.
     */
    @Test
    public void testIncorrectConvert() {
        // Arrange
        EpisodeResponse response = EpisodeTestData.createResponse();

        // Act
        Episode actual = mConverter.convert(response);
        List<String> charactersUrl = new ArrayList<>();
        charactersUrl.add("https://rickandmortyapi.com/api/character/35");
        Episode unexpected = new Episode(
                252,
                "Unexpected title",
                "September 9 1998",
                "S02E04",
                charactersUrl
        );

        // Assert
        Truth.assertThat(actual).isNotEqualTo(unexpected);
    }
}
