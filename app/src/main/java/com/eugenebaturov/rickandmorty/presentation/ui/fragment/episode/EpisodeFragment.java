package com.eugenebaturov.rickandmorty.presentation.ui.fragment.episode;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.eugenebaturov.rickandmorty.R;
import com.eugenebaturov.rickandmorty.app.App;
import com.eugenebaturov.rickandmorty.di.episode.EpisodeComponent;
import com.eugenebaturov.rickandmorty.presentation.viewmodel.episode.EpisodeViewModel;
import com.eugenebaturov.rickandmorty.presentation.viewmodel.episode.EpisodeViewModelFactory;

import javax.inject.Inject;

public final class EpisodeFragment extends Fragment {
    private static final String EXTRA_EPISODE_ID = "EXTRA_EPISODE_ID";
    private static final String EXTRA_EPISODE_IMAGE = "EXTRA_EPISODE_IMAGE";

    private int mEpisodeId;
    private int mSeasonImageResource;

    private ImageView mEpisodeSeasonImageView;
    private TextView mEpisodeTitleTextView;
    private TextView mEpisodeNumberTextView;
    private TextView mEpisodeAirDateTextView;

    private EpisodeViewModel mViewModel;

    @Inject
    EpisodeViewModelFactory mViewModelFactory;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        injectDependency();
        initViewModel();
        getEpisodeArgs();
        return inflater.inflate(R.layout.fragment_episode, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view,
                              @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initUI(view);
        observeEpisode();
        mViewModel.loadEpisodeById(mEpisodeId);
    }

    private void injectDependency() {
        EpisodeComponent mEpisodeComponent
                = App.getAppComponent(requireContext()).getEpisodeComponent();
        mEpisodeComponent.inject(this);
    }

    private void initViewModel() {
        mViewModel = new ViewModelProvider(
                this,
                mViewModelFactory)
                .get(EpisodeViewModel.class);
    }

    private void getEpisodeArgs() {
        mEpisodeId = requireArguments().getInt(EXTRA_EPISODE_ID);
        mSeasonImageResource = requireArguments().getInt(EXTRA_EPISODE_IMAGE);
    }

    private void initUI(View view) {
        mEpisodeSeasonImageView = view.findViewById(R.id.episode_season_numb_imageView);
        mEpisodeTitleTextView = view.findViewById(R.id.episode_title_textView);
        mEpisodeNumberTextView = view.findViewById(R.id.episode_number_textView);
        mEpisodeAirDateTextView = view.findViewById(R.id.episode_air_date_textView);
    }

    private void observeEpisode() {
        mViewModel.getEpisode().observe(getViewLifecycleOwner(), episode -> {
            mEpisodeSeasonImageView.setImageResource(mSeasonImageResource);
            mEpisodeTitleTextView.setText(episode.getTitle());
            mEpisodeNumberTextView.setText(episode.getEpisodeNumber());
            mEpisodeAirDateTextView.setText(episode.getAirDate());
        });
    }

    /**
     * Создаёт новый образец {@link EpisodeFragment}.
     *
     * @param episodeId     id эпизода.
     * @param imageResource ресурс изображения сезона.
     * @return фрагмент эпизода.
     */
    public static EpisodeFragment newInstance(final int episodeId, final int imageResource) {
        Bundle args = new Bundle();
        args.putInt(EXTRA_EPISODE_ID, episodeId);
        args.putInt(EXTRA_EPISODE_IMAGE, imageResource);
        EpisodeFragment fragment = new EpisodeFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
