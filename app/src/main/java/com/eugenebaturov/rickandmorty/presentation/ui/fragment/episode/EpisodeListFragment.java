package com.eugenebaturov.rickandmorty.presentation.ui.fragment.episode;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.eugenebaturov.rickandmorty.R;
import com.eugenebaturov.rickandmorty.App;
import com.eugenebaturov.rickandmorty.di.episode.EpisodeSubcomponent;
import com.eugenebaturov.rickandmorty.presentation.ui.adapter.EpisodesAdapter;
import com.eugenebaturov.rickandmorty.presentation.ui.fragment.BaseFragment;
import com.eugenebaturov.rickandmorty.presentation.viewmodel.episode.EpisodeListViewModel;
import com.eugenebaturov.rickandmorty.presentation.viewmodel.episode.EpisodeListViewModelFactory;

import javax.inject.Inject;

/**
 * Фрагмент, который отображает список эпизодов.
 */
public final class EpisodeListFragment extends BaseFragment {
    private ProgressBar mProgress;
    private RecyclerView mRecyclerView;
    private EpisodesAdapter mAdapter;

    private EpisodeListViewModel mViewModel;

    @Inject
    EpisodeListViewModelFactory mViewModelFactory;

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        injectDependency();
        initViewModel();
        return inflater.inflate(R.layout.fragment_list_episodes, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initUI(view);
        observeEpisodes();
        observeProgress();
        mViewModel.loadEpisodes();
    }

    private void injectDependency() {
        EpisodeSubcomponent episodeSubcomponent
                = App.getAppComponent(requireContext()).getEpisodeSubcomponent();
        episodeSubcomponent.inject(this);
    }

    private void initViewModel() {
        mViewModel = new ViewModelProvider(
                this,
                mViewModelFactory)
                .get(EpisodeListViewModel.class);
    }

    private void initUI(View view) {
        mProgress = view.findViewById(R.id.progress_bar);
        mRecyclerView = view.findViewById(R.id.recyclerView_episodes);
        setRecyclerView();

        SearchView mSearchView = view.findViewById(R.id.episode_searchView);
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
        mAdapter = new EpisodesAdapter(mNavigation);
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
