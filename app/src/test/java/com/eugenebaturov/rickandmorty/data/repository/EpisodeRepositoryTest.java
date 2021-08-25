package com.eugenebaturov.rickandmorty.data.repository;

import com.eugenebaturov.rickandmorty.data.api.EpisodeApi;
import com.eugenebaturov.rickandmorty.data.repository.episode.EpisodeRepository;
import com.eugenebaturov.rickandmorty.data.repository.episode.EpisodeRepositoryImpl;
import com.eugenebaturov.rickandmorty.models.data.EpisodeResponse;
import com.eugenebaturov.rickandmorty.models.data.list.ListEpisodeResponse;
import com.eugenebaturov.rickandmorty.models.domain.Episode;

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
                Single.just(createTestListEpisodeResponse());
        Mockito.when(mEpisodeApi.getAllEpisodes()).thenReturn(serverResponse);

        // Act
        Single<List<Episode>> actual = mEpisodeRepository.getEpisodesFromServer();
        List<Episode> expected = createExpectedListEpisode();

        // Assert
        actual.test().assertValue(expected);
    }

    /**
     * Проверка на то, что если с сервера придёт null, мы получим {@link NullPointerException}.
     */
    @Test(expected = NullPointerException.class)
    public void testGetNullEpisodesFromServer() {
        // Arrange
        Single<ListEpisodeResponse> serverResponse =
                Single.just(null);
        Mockito.when(mEpisodeApi.getAllEpisodes()).thenReturn(serverResponse);

        // Act
        mEpisodeRepository.getEpisodesFromServer();
    }

    /**
     * Проверка на то, что с сервера придут нужные данные об эпизоде
     * виде {@link EpisodeResponse}, и после мы обрабатываем в ожидаемый {@link Episode}.
     */
    @Test
    public void testGetEpisodeWithCorrectId() {
        // Arrange
        Single<EpisodeResponse> serverResponse =
                Single.just(createTestEpisodeResponse());
        Mockito.when(mEpisodeApi.getEpisodeById(CORRECT_EPISODE_ID)).thenReturn(serverResponse);

        // Act
        Single<Episode> actual = mEpisodeRepository.getEpisodeFromServer(CORRECT_EPISODE_ID);
        Episode expected = createTestEpisode();

        // Assert
        actual.test().assertValue(expected);
    }

    /**
     * Проверка на то, что с некорректным id эпизода, мы получим {@link NullPointerException}.
     */
    @Test(expected = NullPointerException.class)
    public void testGetNullEpisodeWithIncorrectId() {
        // Act
        mEpisodeRepository.getEpisodeFromServer(INCORRECT_EPISODE_ID);
    }

    private ListEpisodeResponse createTestListEpisodeResponse() {
        List<EpisodeResponse> episodes = new ArrayList<>();

        List<String> firstEpisodeCharactersUrl = new ArrayList<>();
        firstEpisodeCharactersUrl.add("https://rickandmortyapi.com/api/character/1");
        firstEpisodeCharactersUrl.add("https://rickandmortyapi.com/api/character/2");
        firstEpisodeCharactersUrl.add("https://rickandmortyapi.com/api/character/35");
        EpisodeResponse firstEpisode = new EpisodeResponse(
                1,
                "Pilot",
                "December 2, 2013",
                "S01E01",
                firstEpisodeCharactersUrl
        );

        List<String> secondEpisodeCharactersUrl = new ArrayList<>();
        secondEpisodeCharactersUrl.add("https://rickandmortyapi.com/api/character/31");
        secondEpisodeCharactersUrl.add("https://rickandmortyapi.com/api/character/12");
        secondEpisodeCharactersUrl.add("https://rickandmortyapi.com/api/character/5");
        EpisodeResponse secondEpisode = new EpisodeResponse(
                2,
                "Lawnmower Dog",
                "December 9, 2013",
                "S01E02",
                secondEpisodeCharactersUrl
        );

        episodes.add(firstEpisode);
        episodes.add(secondEpisode);

        return new ListEpisodeResponse(episodes);
    }

    private List<Episode> createExpectedListEpisode() {
        List<Episode> episodes = new ArrayList<>();

        List<String> firstEpisodeCharactersUrl = new ArrayList<>();
        firstEpisodeCharactersUrl.add("https://rickandmortyapi.com/api/character/1");
        firstEpisodeCharactersUrl.add("https://rickandmortyapi.com/api/character/2");
        firstEpisodeCharactersUrl.add("https://rickandmortyapi.com/api/character/35");
        EpisodeResponse firstEpisode = new EpisodeResponse(
                1,
                "Pilot",
                "December 2, 2013",
                "S01E01",
                firstEpisodeCharactersUrl
        );

        List<String> secondEpisodeCharactersUrl = new ArrayList<>();
        secondEpisodeCharactersUrl.add("https://rickandmortyapi.com/api/character/31");
        secondEpisodeCharactersUrl.add("https://rickandmortyapi.com/api/character/12");
        secondEpisodeCharactersUrl.add("https://rickandmortyapi.com/api/character/5");
        EpisodeResponse secondEpisode = new EpisodeResponse(
                2,
                "Lawnmower Dog",
                "December 9, 2013",
                "S01E02",
                secondEpisodeCharactersUrl
        );

        episodes.add(new Episode(firstEpisode));
        episodes.add(new Episode(secondEpisode));

        return episodes;
    }

    private EpisodeResponse createTestEpisodeResponse() {
        List<String> testEpisodeCharactersUrl = new ArrayList<>();
        testEpisodeCharactersUrl.add("https://rickandmortyapi.com/api/character/1");
        testEpisodeCharactersUrl.add("https://rickandmortyapi.com/api/character/2");
        testEpisodeCharactersUrl.add("https://rickandmortyapi.com/api/character/35");
        return new EpisodeResponse(
                1,
                "Pilot",
                "December 2, 2013",
                "S01E01",
                testEpisodeCharactersUrl
        );
    }

    private Episode createTestEpisode() {
        return new Episode(createTestEpisodeResponse());
    }
}
