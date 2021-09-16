package com.eugenebaturov.rickandmorty.data.converter.episode;

import com.eugenebaturov.rickandmorty.data.converter.Converter;
import com.eugenebaturov.rickandmorty.models.data.list.ListEpisodeResponse;
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
 * Unit-тест для {@link EpisodesConverter}.
 */
@RunWith(MockitoJUnitRunner.class)
public class EpisodesConverterTest {
    private Converter<ListEpisodeResponse, List<Episode>> mConverter;

    @Before
    public void setUp() {
        mConverter = new EpisodesConverter();
    }

    /**
     * Проверка на то, что конвертер правильно преобразует ожидаемые данные.
     */
    @Test
    public void testCorrectConvert() {
        // Arrange
        ListEpisodeResponse response = EpisodeTestData.createListResponse();

        // Act
        List<Episode> actual = mConverter.convert(response);
        List<Episode> expected = EpisodeTestData.createEpisodes();

        // Assert
        Truth.assertThat(actual).isEqualTo(expected);
    }

    /**
     * Проверка на то, что конвертер неправильно преобразует ожидаемые данные.
     */
    @Test
    public void testIncorrectConvert() {
        // Arrange
        ListEpisodeResponse response = EpisodeTestData.createListResponse();

        // Act
        List<Episode> actual = mConverter.convert(response);
        List<String> charactersUrl = new ArrayList<>();
        charactersUrl.add("https://rickandmortyapi.com/api/character/35");
        Episode episode = new Episode(
                252,
                "Unexpected title",
                "September 9 1998",
                "S02E04",
                charactersUrl
        );
        List<Episode> unexpected = new ArrayList<>();
        unexpected.add(episode);

        // Assert
        Truth.assertThat(actual).isNotEqualTo(unexpected);
    }
}
