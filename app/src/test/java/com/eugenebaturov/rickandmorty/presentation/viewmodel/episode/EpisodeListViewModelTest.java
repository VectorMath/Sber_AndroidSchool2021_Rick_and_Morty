package com.eugenebaturov.rickandmorty.presentation.viewmodel.episode;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.Observer;

import com.eugenebaturov.rickandmorty.domain.interactor.episode.EpisodeInteractor;
import com.eugenebaturov.rickandmorty.models.domain.Episode;
import com.eugenebaturov.rickandmorty.testdata.EpisodeTestData;
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

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;

/**
 * Unit-test для {@link EpisodeListViewModel}.
 */
@RunWith(MockitoJUnitRunner.class)
public class EpisodeListViewModelTest {
    private static final String EPISODE_NAME_QUERY = "Day";
    private static final String INCORRECT_QUERY = "_3fFIK2F_JFK";

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
     * Проверка на то, что после подписки мы получим ожидаемые тестовые данные об эпизодах.
     */
    @Test
    public void testLoadEpisodes() {
        // Arrange
        Mockito
                .when(mEpisodeInteractor.getEpisodes())
                .thenReturn(Single.just(EpisodeTestData.createEpisodes()));

        // Act
        mEpisodeListViewModel.loadEpisodes();
        InOrder inOrder = Mockito.inOrder(mError, mEpisodes, mProgress);

        // Assert
        inOrder.verify(mProgress).onChanged(true);
        inOrder.verify(mEpisodes).onChanged(EpisodeTestData.createEpisodes());
        inOrder.verify(mProgress).onChanged(false);
        inOrder.verifyNoMoreInteractions();
    }

    /**
     * Проверка на то, что после подписки с конкретным запросом
     * мы получим ожидаемые тестовые данные об эпизодах.
     */
    @Test
    public void testLoadEpisodesWithQuery() {
        // Arrange
        Mockito
                .when(mEpisodeInteractor.getEpisodes(EPISODE_NAME_QUERY))
                .thenReturn(Single.just(EpisodeTestData.createSearchedEpisodes()));

        // Act
        mEpisodeListViewModel.loadEpisodes(EPISODE_NAME_QUERY);
        InOrder inOrder = Mockito.inOrder(mError, mEpisodes, mProgress);

        // Assert
        inOrder.verify(mProgress).onChanged(true);
        inOrder.verify(mEpisodes).onChanged(EpisodeTestData.createSearchedEpisodes());
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
                .when(mEpisodeInteractor.getEpisodes())
                .thenReturn(Single.error(new IllegalAccessException()));

        // Act
        mEpisodeListViewModel.loadEpisodes();

        // Assert
        Mockito.verify(mError).onChanged(ArgumentMatchers.isA(IllegalAccessException.class));
    }

    /**
     * Проверка на то, что если интерактор вернёт {@link IllegalAccessException},
     * то и наша вью-моделька получит её.
     */
    @Test
    public void testLoadSearchedEpisodesWithError() {
        // Arrange
        Mockito
                .when(mEpisodeInteractor.getEpisodes(INCORRECT_QUERY))
                .thenReturn(Single.error(new IllegalAccessException()));

        // Act
        mEpisodeListViewModel.loadEpisodes(INCORRECT_QUERY);

        // Assert
        Mockito.verify(mError).onChanged(ArgumentMatchers.isA(IllegalAccessException.class));
    }
}
