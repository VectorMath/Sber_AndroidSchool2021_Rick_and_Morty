package com.eugenebaturov.rickandmorty.presentation.ui.fragment.episode;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.eugenebaturov.rickandmorty.R;
import com.eugenebaturov.rickandmorty.di.episode.DaggerEpisodeComponent;
import com.eugenebaturov.rickandmorty.di.episode.EpisodeComponent;
import com.eugenebaturov.rickandmorty.presentation.ui.activity.MainActivity;
import com.eugenebaturov.rickandmorty.presentation.ui.adapter.EpisodesAdapter;
import com.eugenebaturov.rickandmorty.presentation.viewmodel.episode.EpisodeListViewModel;

/**
 * Фрагмент, который отображает список эпизодов.
 */
public final class EpisodeListFragment extends Fragment {
    private ProgressBar mProgress;
    private RecyclerView mRecyclerView;
    private EpisodesAdapter mAdapter;

    private EpisodeListViewModel mViewModel;
    private BottomNavigation mBottomNavigation;

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        initViewModel();
        return inflater.inflate(R.layout.fragment_list_episodes, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initUI(view);
        setRecyclerView();
        mViewModel.loadEpisodes();
        observeEpisodes();
        observeProgress();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mBottomNavigation = (MainActivity) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mBottomNavigation = null;
    }

    /**
     * Callback-интерфейс для перехода на фрагмент с конкретной сущностью.
     */
    public interface BottomNavigation {
        void goToEpisode(final int episodeId, final int imageRecourse);
    }

    private void initViewModel() {
        EpisodeComponent episodeComponent = DaggerEpisodeComponent.create();
        mViewModel = new ViewModelProvider(
                this,
                episodeComponent.getListViewModelFactory())
                .get(EpisodeListViewModel.class);
    }

    private void initUI(View view) {
        SearchView mSearchView = view.findViewById(R.id.episode_searchView);
        mProgress = view.findViewById(R.id.progress_bar);
        mRecyclerView = view.findViewById(R.id.recyclerView_episodes);

        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                mViewModel.loadEpisodes(newText);
                return false;
            }
        });
    }

    private void setRecyclerView() {
        mAdapter = new EpisodesAdapter(mBottomNavigation);
        mRecyclerView.hasFixedSize();
        mRecyclerView.setAdapter(mAdapter);
    }

    private void observeEpisodes() {
        mViewModel.getEpisodes().observe(
                getViewLifecycleOwner(),
                episodes -> mAdapter.updateData(episodes));
    }

    private void observeProgress() {
        mViewModel.getProgress().observe(getViewLifecycleOwner(), progress -> {
            if (!progress)
                mProgress.setVisibility(View.INVISIBLE);
            else
                mProgress.setVisibility(View.VISIBLE);
        });
    }

    /**
     * Создаёт новый образец {@link EpisodeListFragment}.
     *
     * @return фрагмент списка эпизодов.
     */
    public static EpisodeListFragment newInstance() {
        return new EpisodeListFragment();
    }
}
