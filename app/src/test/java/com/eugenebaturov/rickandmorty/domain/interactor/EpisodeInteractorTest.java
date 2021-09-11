package com.eugenebaturov.rickandmorty.domain.interactor;

import com.eugenebaturov.rickandmorty.data.repository.episode.EpisodeRepository;
import com.eugenebaturov.rickandmorty.domain.interactor.episode.EpisodeInteractor;
import com.eugenebaturov.rickandmorty.domain.interactor.episode.EpisodeInteractorImpl;
import com.eugenebaturov.rickandmorty.models.domain.Episode;
import com.eugenebaturov.rickandmorty.testdata.EpisodeTestData;
import com.google.common.truth.Truth;

import org.junit.Assert;
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

/**
 * Юнит-тесты для класса {@link EpisodeInteractorImpl}
 */
@RunWith(MockitoJUnitRunner.class)
public class EpisodeInteractorTest {
    private static final int CORRECT_EPISODE_ID = 39;
    private static final int INCORRECT_EPISODE_ID = 0;
    private static final String EPISODE_NAME_QUERY = "Day";
    private static final String INCORRECT_QUERY = "_3fFIK2F_JFK";

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
        Single<List<Episode>> episodesFromRepository =
                Single.just(EpisodeTestData.createEpisodes());
        Mockito.when(mEpisodeRepository.getEpisodesFromServer()).thenReturn(episodesFromRepository);

        // Act
        Single<List<Episode>> actual = mEpisodeInteractor.getEpisodesFromRepository();

        // Assert
        Truth.assertThat(actual).isEqualTo(episodesFromRepository);
    }

    /**
     * Проверка на то, что если с репозитория придёт ошибка, мы получим {@link RuntimeException}.
     */
    @Test
    public void testGetErrorFromRepository() {
        // Arrange
        String EXPECTED_EXCEPTION_MESSAGE = "Repository Error!";
        Mockito
                .when(mEpisodeRepository.getEpisodesFromServer())
                .thenThrow(new RuntimeException(EXPECTED_EXCEPTION_MESSAGE));

        try {
            mEpisodeInteractor.getEpisodesFromRepository();
        } catch (RuntimeException e) {
            Assert.assertEquals(EXPECTED_EXCEPTION_MESSAGE, e.getMessage());
        }
    }

    /**
     * Проверка на то, что при конкретном запросе(query)
     * с репозитория приходят нужные данные.
     */
    @Test
    public void testGetSearchedEpisodesFromServer() {
        // Arrange
        Single<List<Episode>> episodesFromRepository =
                Single.just(EpisodeTestData.createSearchedEpisodes());
        Mockito
                .when(mEpisodeRepository.getSearchedEpisodesFromServer(EPISODE_NAME_QUERY))
                .thenReturn(episodesFromRepository);

        // Act
        Single<List<Episode>> actual =
                mEpisodeInteractor.getSearchedEpisodesFromRepository(EPISODE_NAME_QUERY);

        // Assert
        Truth.assertThat(actual).isEqualTo(episodesFromRepository);
    }

    /**
     * Проверка на то, что при некорретном запросе мы получим {@link RuntimeException}.
     */
    @Test
    public void testGetSearchedErrorFromServer() {
        String EXPECTED_EXCEPTION_MESSAGE = "Repository Error! Nothing found...";
        Mockito
                .when(mEpisodeRepository.getSearchedEpisodesFromServer(INCORRECT_QUERY))
                .thenThrow(new RuntimeException(EXPECTED_EXCEPTION_MESSAGE));

        try {
            mEpisodeInteractor.getSearchedEpisodesFromRepository(INCORRECT_QUERY);
        } catch (RuntimeException exception) {
            Assert.assertEquals(EXPECTED_EXCEPTION_MESSAGE, exception.getMessage());
        }
    }

    /**
     * Проверка на то, что при указание корректного id эпизода,
     * репозиторий отдаст нам ожидаемый эпизод.
     */
    @Test
    public void testGetEpisodeFromRepositoryWithCorrectId() {
        // Arrange
        Single<Episode> expectedEpisode = Single.just(EpisodeTestData.createEpisode());
        Mockito.when(mEpisodeRepository.getEpisodeFromServer(CORRECT_EPISODE_ID))
                .thenReturn(expectedEpisode);

        // Act
        Single<Episode> actual = mEpisodeInteractor.getEpisodeFromRepository(CORRECT_EPISODE_ID);

        // Assert
        Truth.assertThat(actual).isEqualTo(expectedEpisode);
    }

    /**
     * Проверка на то, что с некорректным id эпизода, мы получим {@link RuntimeException}.
     */
    @Test
    public void testEpisodeIsNotExist() {
        String EXPECTED_EXCEPTION_MESSAGE = "Repository Error! Episode is not exist...";
        Mockito.when(mEpisodeRepository.getEpisodeFromServer(INCORRECT_EPISODE_ID))
                .thenThrow(new RuntimeException(EXPECTED_EXCEPTION_MESSAGE));
        try {
            mEpisodeInteractor.getEpisodeFromRepository(INCORRECT_EPISODE_ID);
        } catch (RuntimeException e) {
            Assert.assertEquals(EXPECTED_EXCEPTION_MESSAGE, e.getMessage());
        }
    }
}
