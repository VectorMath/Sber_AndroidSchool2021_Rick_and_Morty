package com.eugenebaturov.rickandmorty.domain.interactor;

import com.eugenebaturov.rickandmorty.data.repository.episode.EpisodeRepository;
import com.eugenebaturov.rickandmorty.domain.interactor.episode.EpisodeInteractor;
import com.eugenebaturov.rickandmorty.domain.interactor.episode.EpisodeInteractorImpl;
import com.eugenebaturov.rickandmorty.models.domain.Episode;
import com.google.common.truth.Truth;

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

/**
 * Юнит-тесты для класса {@link EpisodeInteractorImpl}
 */
@RunWith(MockitoJUnitRunner.class)
public class EpisodeInteractorTest {
    private static final int CORRECT_EPISODE_ID = 39;
    private static final int INCORRECT_EPISODE_ID = 0;

    private EpisodeRepository mEpisodeRepository;
    private EpisodeInteractor mEpisodeInteractor;

    @Rule
    public final MockitoRule mockitoRule = MockitoJUnit.rule();

    @Before
    public void setUp() {
        mEpisodeRepository = Mockito.mock(EpisodeRepository.class);
        mEpisodeInteractor = new EpisodeInteractorImpl(mEpisodeRepository);
    }

    /**
     * Проверка на то, что из репозитория получаем список эпизодов.
     */
    @Test
    public void testGetEpisodesFromRepository() {
        // Arrange
        Single<List<Episode>> episodesFromRepository = Single.just(createEpisodes());
        Mockito.when(mEpisodeRepository.getEpisodesFromServer()).thenReturn(episodesFromRepository);

        // Act
        Single<List<Episode>> actual = mEpisodeInteractor.getEpisodesFromRepository();

        // Assert
        Truth.assertThat(actual).isEqualTo(episodesFromRepository);
    }

    /**
     * Проверка на то, что если из репозитория ничего не придёт, результат будет null.
     */
    @Test
    public void testGetNullEpisodesFromRepository() {
        // Arrange
        Mockito.when(mEpisodeRepository.getEpisodesFromServer()).thenReturn(null);

        // Act
        Single<List<Episode>> actual = mEpisodeInteractor.getEpisodesFromRepository();

        // Assert
        Truth.assertThat(actual).isNull();
    }

    /**
     * Проверка на то, что при указание корректного id эпизода,
     * репозиторий отдаст нам ожидаемый эпизод.
     */
    @Test
    public void testGetEpisodeFromRepositoryWithCorrectId() {
        // Arrange
        Single<Episode> expectedEpisode = Single.just(createEpisode());
        Mockito.when(mEpisodeRepository.getEpisodeFromServer(CORRECT_EPISODE_ID))
                .thenReturn(expectedEpisode);

        // Act
        Single<Episode> actual = mEpisodeInteractor.getEpisodeFromRepository(CORRECT_EPISODE_ID);

        // Assert
        Truth.assertThat(actual).isEqualTo(expectedEpisode);
    }

    /**
     * Проверка на то, что при указание некорректного id эпизода
     * репозиторий вернёт нам null.
     */
    @Test
    public void testGetNullEpisodeFromRepositoryWithIncorrectId() {
        // Act
        Single<Episode> actual = mEpisodeInteractor.getEpisodeFromRepository(INCORRECT_EPISODE_ID);

        // Assert
        Truth.assertThat(actual).isNull();
    }

    private List<Episode> createEpisodes() {
        List<Episode> episodes = new ArrayList<>();
        List<String> firstEpisodeCharactersUrl = new ArrayList<>();
        List<String> secondEpisodeCharactersUrl = new ArrayList<>();

        firstEpisodeCharactersUrl.add("https://rickandmortyapi.com/api/character/31");
        firstEpisodeCharactersUrl.add("https://rickandmortyapi.com/api/character/12");
        firstEpisodeCharactersUrl.add("https://rickandmortyapi.com/api/character/5");
        Episode firstEpisode = new Episode(
                1,
                "Pilot",
                "September 10, 2017",
                "S03E07",
                firstEpisodeCharactersUrl
        );

        secondEpisodeCharactersUrl.add("https://rickandmortyapi.com/api/character/31");
        secondEpisodeCharactersUrl.add("https://rickandmortyapi.com/api/character/12");
        secondEpisodeCharactersUrl.add("https://rickandmortyapi.com/api/character/5");
        Episode secondEpisode = new Episode(
                2,
                "Lawnmower Dog",
                "December 9, 2013",
                "S01E02",
                secondEpisodeCharactersUrl
        );

        episodes.add(firstEpisode);
        episodes.add(secondEpisode);

        return episodes;
    }

    private Episode createEpisode() {
        List<String> firstEpisodeCharactersUrl = new ArrayList<>();
        firstEpisodeCharactersUrl.add("https://rickandmortyapi.com/api/character/31");
        firstEpisodeCharactersUrl.add("https://rickandmortyapi.com/api/character/12");
        firstEpisodeCharactersUrl.add("https://rickandmortyapi.com/api/character/5");

        return new Episode(
                1,
                "Pilot",
                "September 10, 2017",
                "S03E07",
                firstEpisodeCharactersUrl
        );
    }
}
