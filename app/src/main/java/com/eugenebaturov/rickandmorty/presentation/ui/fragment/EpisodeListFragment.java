package com.eugenebaturov.rickandmorty.presentation.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.eugenebaturov.rickandmorty.R;
import com.eugenebaturov.rickandmorty.di.episode.DaggerEpisodeComponent;
import com.eugenebaturov.rickandmorty.di.episode.EpisodeComponent;
import com.eugenebaturov.rickandmorty.presentation.ui.activity.EpisodeActivity;
import com.eugenebaturov.rickandmorty.presentation.ui.adapter.EpisodesAdapter;
import com.eugenebaturov.rickandmorty.presentation.viewmodel.episode.EpisodeListViewModel;
import com.eugenebaturov.rickandmorty.utils.Keys;

/**
 * Фрагмент, который отображает список эпизодов.
 * Так же является реализацией интерфейса {@link EpisodesAdapter.EpisodePage}.
 */
public class EpisodeListFragment extends Fragment implements EpisodesAdapter.EpisodePage {
    private ProgressBar mProgress;
    private RecyclerView mRecyclerView;
    private EpisodesAdapter mAdapter;
    private EpisodeListViewModel mViewModel;

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list_episodes, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initUI(view);
        initViewModel();
        setRecyclerView();
        observeEpisodes();
        observeProgress();
    }

    @Override
    public void goToEpisode(int id, int imgRes) {
        Intent intent = new Intent(getContext(), EpisodeActivity.class);
        intent.putExtra(Keys.KEY_EPISODE_ID, id);
        intent.putExtra(Keys.KEY_EPISODE_IMAGE, imgRes);
        startActivity(intent);
    }

    /**
     * Создаёт новый образец {@link EpisodeListFragment}.
     *
     * @return фрагмент списка эпизодов.
     */
    public static EpisodeListFragment newInstance() {
        return new EpisodeListFragment();
    }

    private void initUI(View view) {
        mProgress = view.findViewById(R.id.progress_bar);
        mRecyclerView = view.findViewById(R.id.recyclerView_episodes);
    }

    private void setRecyclerView() {
        mViewModel.loadEpisodes();
        mAdapter = new EpisodesAdapter(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.hasFixedSize();
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void initViewModel() {
        EpisodeComponent episodeComponent = DaggerEpisodeComponent.create();
        mViewModel = new ViewModelProvider(
                this,
                episodeComponent.getListViewModelFactory())
                .get(EpisodeListViewModel.class);
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
}
