package com.eugenebaturov.rickandmorty.data.repository;

import com.eugenebaturov.rickandmorty.data.api.EpisodeApi;
import com.eugenebaturov.rickandmorty.data.repository.episode.EpisodeRepository;
import com.eugenebaturov.rickandmorty.data.repository.episode.EpisodeRepositoryImpl;
import com.eugenebaturov.rickandmorty.models.data.EpisodeResponse;
import com.eugenebaturov.rickandmorty.models.data.list.ListEpisodeResponse;
import com.eugenebaturov.rickandmorty.models.domain.Episode;
import com.eugenebaturov.rickandmorty.testdata.EpisodeTestData;

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
 * Юнит-тесты для {@link EpisodeRepositoryImpl}.
 */
@RunWith(MockitoJUnitRunner.class)
public class EpisodeRepositoryTest {
    private static final int CORRECT_EPISODE_ID = 15;
    private static final int INCORRECT_EPISODE_ID = -228;

    private EpisodeApi mEpisodeApi;
    private EpisodeRepository mEpisodeRepository;

    @Rule
    public final MockitoRule mockitoRule = MockitoJUnit.rule();

    @Before
    public void setUp() {
        mEpisodeApi = Mockito.mock(EpisodeApi.class);
        mEpisodeRepository = new EpisodeRepositoryImpl(mEpisodeApi);
    }

    /**
     * Проверка на то, что с сервера приходят нужные данные в виде {@link ListEpisodeResponse}
     * и после они обрабатываются в ожидаемый {@link List}<{@link Episode}>.
     */
    @Test
    public void testGetEpisodesFromServer() {
        // Arrange
        Single<ListEpisodeResponse> serverResponse =
                Single.just(EpisodeTestData.createListResponse());
        Mockito.when(mEpisodeApi.getAllEpisodes()).thenReturn(serverResponse);

        // Act
        Single<List<Episode>> actual = mEpisodeRepository.getEpisodesFromServer();
        List<Episode> expected = EpisodeTestData.createEpisodes();

        // Assert
        actual.test().assertValue(expected);
    }

    /**
     * Проверка на то, что если с сервера придёт ошибка, мы получим {@link RuntimeException}.
     */
    @Test
    public void testGetErrorFromServer() {
        // Arrange
        String EXPECTED_EXCEPTION_MESSAGE = "Server Error!";
        Mockito
                .when(mEpisodeApi.getAllEpisodes())
                .thenThrow(new RuntimeException(EXPECTED_EXCEPTION_MESSAGE));

        try {
            mEpisodeRepository.getEpisodesFromServer();
        } catch (RuntimeException e) {
            Assert.assertEquals(EXPECTED_EXCEPTION_MESSAGE, e.getMessage());
        }
    }

    /**
     * Проверка на то, что с сервера придут нужные данные об эпизоде
     * виде {@link EpisodeResponse}, и после мы обрабатываем в ожидаемый {@link Episode}.
     */
    @Test
    public void testGetEpisodeWithCorrectId() {
        // Arrange
        Single<EpisodeResponse> serverResponse =
                Single.just(EpisodeTestData.createResponse());
        Mockito.when(mEpisodeApi.getEpisodeById(CORRECT_EPISODE_ID)).thenReturn(serverResponse);

        // Act
        Single<Episode> actual = mEpisodeRepository.getEpisodeFromServer(CORRECT_EPISODE_ID);
        Episode expected = EpisodeTestData.createEpisode();

        // Assert
        actual.test().assertValue(expected);
    }

    /**
     * Проверка на то, что с некорректным id эпизода, мы получим {@link RuntimeException}.
     */
    @Test
    public void testEpisodeIsNotExist() {
        String EXPECTED_EXCEPTION_MESSAGE = "Server Error! Episode is not exist...";
        Mockito.when(mEpisodeApi.getEpisodeById(INCORRECT_EPISODE_ID))
                .thenThrow(new RuntimeException(EXPECTED_EXCEPTION_MESSAGE));
        try {
            mEpisodeRepository.getEpisodeFromServer(INCORRECT_EPISODE_ID);
        } catch (RuntimeException e) {
            Assert.assertEquals(EXPECTED_EXCEPTION_MESSAGE, e.getMessage());
        }
    }
}
