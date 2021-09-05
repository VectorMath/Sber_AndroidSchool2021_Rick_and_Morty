package com.eugenebaturov.rickandmorty.presentation.viewmodel.episode;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.Observer;

import com.eugenebaturov.rickandmorty.domain.interactor.episode.EpisodeInteractor;
import com.eugenebaturov.rickandmorty.models.domain.Episode;
import com.eugenebaturov.rickandmorty.utils.SchedulerProvider;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;

/**
 * Unit-test для {@link EpisodeListViewModel}.
 */
@RunWith(MockitoJUnitRunner.class)
public class EpisodeListViewModelTest {
    @Mock
    private SchedulerProvider mSchedulerProvider;

    @Mock
    private EpisodeInteractor mEpisodeInteractor;

    @Mock
    private Observer<List<Episode>> mEpisodes;

    @Mock
    private Observer<Boolean> mProgress;

    @Mock
    private Observer<Throwable> mError;

    @Rule
    public final InstantTaskExecutorRule mRule = new InstantTaskExecutorRule();

    private EpisodeListViewModel mEpisodeListViewModel;

    @Before
    public void setUp() {
        mEpisodeListViewModel = new EpisodeListViewModel(mSchedulerProvider, mEpisodeInteractor);

        mEpisodeListViewModel.getEpisodes().observeForever(mEpisodes);
        mEpisodeListViewModel.getProgress().observeForever(mProgress);
        mEpisodeListViewModel.getError().observeForever(mError);

        Mockito.when(mSchedulerProvider.io()).thenReturn(Schedulers.trampoline());
        Mockito.when(mSchedulerProvider.ui()).thenReturn(Schedulers.trampoline());
    }

    /**
     * Проверка на то, что после подписки мы получим ожидаемые тестовые данные о локациях.
     */
    @Test
    public void testLoadEpisodes() {
        // Arrange
        Mockito
                .when(mEpisodeInteractor.getEpisodesFromRepository())
                .thenReturn(Single.just(createTestData()));

        // Act
        mEpisodeListViewModel.loadEpisodes();

        // Assert
        Mockito.verify(mEpisodes).onChanged(createTestData());
    }

    /**
     * Проверка на то, что методы вызывутся в нужном порядке.
     */
    @Test
    public void testLoadEpisodesInOrder() {
        // Arrange
        Mockito
                .when(mEpisodeInteractor.getEpisodesFromRepository())
                .thenReturn(Single.just(createTestData()));

        // Act
        mEpisodeListViewModel.loadEpisodes();
        InOrder inOrder = Mockito.inOrder(mError, mEpisodes, mProgress);

        // Assert
        inOrder.verify(mProgress).onChanged(true);
        inOrder.verify(mEpisodes).onChanged(createTestData());
        inOrder.verify(mProgress).onChanged(false);
        inOrder.verifyNoMoreInteractions();
    }

    /**
     * Проверка на то, что если интерактор вернёт {@link IllegalAccessException},
     * то и наша вью-моделька получит её.
     */
    @Test
    public void testLoadEpisodesWithError() {
        // Arrange
        Mockito
                .when(mEpisodeInteractor.getEpisodesFromRepository())
                .thenReturn(Single.error(new IllegalAccessException()));

        // Act
        mEpisodeListViewModel.loadEpisodes();

        // Assert
        Mockito.verify(mError).onChanged(ArgumentMatchers.isA(IllegalAccessException.class));
    }

    private List<Episode> createTestData() {
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
}
