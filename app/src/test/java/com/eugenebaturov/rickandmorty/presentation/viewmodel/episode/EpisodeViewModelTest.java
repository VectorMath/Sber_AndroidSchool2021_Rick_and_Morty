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
 * Unit-test для {@link EpisodeViewModel}.
 */
@RunWith(MockitoJUnitRunner.class)
public class EpisodeViewModelTest {
    private final static int CORRECT_ID = 22;
    private final static int INCORRECT_ID = -122;

    @Mock
    private SchedulerProvider mSchedulerProvider;

    @Mock
    private EpisodeInteractor mEpisodeInteractor;

    @Mock
    private Observer<Episode> mEpisode;

    @Mock
    private Observer<Boolean> mProgress;

    @Mock
    private Observer<Throwable> mError;

    @Rule
    public final InstantTaskExecutorRule mRule = new InstantTaskExecutorRule();

    private EpisodeViewModel mEpisodeViewModel;

    @Before
    public void setUp() {
        mEpisodeViewModel = new EpisodeViewModel(mSchedulerProvider, mEpisodeInteractor);

        mEpisodeViewModel.getEpisode().observeForever(mEpisode);
        mEpisodeViewModel.getProgress().observeForever(mProgress);
        mEpisodeViewModel.getError().observeForever(mError);

        Mockito.when(mSchedulerProvider.io()).thenReturn(Schedulers.trampoline());
        Mockito.when(mSchedulerProvider.ui()).thenReturn(Schedulers.trampoline());
    }

    /**
     * Проверка на то, что после подписки мы получим ожидаемую информацию об локации.
     */
    @Test
    public void testLoadEpisodeById() {
        // Arrange
        Mockito
                .when(mEpisodeInteractor.getEpisodeFromRepository(CORRECT_ID))
                .thenReturn(Single.just(createTestEpisode()));

        // Act
        mEpisodeViewModel.loadEpisodeById(CORRECT_ID);

        // Assert
        Mockito.verify(mEpisode).onChanged(createTestEpisode());
    }

    /**
     * Проверка на то, что методы вызываются в нужном порядке.
     */
    @Test
    public void testLoadEpisodeInOrder() {
        // Arrange
        Mockito
                .when(mEpisodeInteractor.getEpisodeFromRepository(CORRECT_ID))
                .thenReturn(Single.just(createTestEpisode()));

        // Act
        mEpisodeViewModel.loadEpisodeById(CORRECT_ID);
        InOrder inOrder = Mockito.inOrder(mError, mEpisode, mProgress);

        // Assert
        inOrder.verify(mProgress).onChanged(true);
        inOrder.verify(mEpisode).onChanged(createTestEpisode());
        inOrder.verify(mProgress).onChanged(false);
        inOrder.verifyNoMoreInteractions();
    }

    /**
     * Проверка на то, что при указание неверного id при подписке, мы получим
     * {@link NullPointerException}.
     */
    @Test
    public void testLoadEpisodeWithError() {
        // Arrange
        Mockito
                .when(mEpisodeInteractor.getEpisodeFromRepository(INCORRECT_ID))
                .thenReturn(Single.error(new NullPointerException()));

        // Act
        mEpisodeViewModel.loadEpisodeById(INCORRECT_ID);

        // Assert
        Mockito.verify(mError).onChanged(ArgumentMatchers.isA(NullPointerException.class));
    }

    private Episode createTestEpisode() {
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
