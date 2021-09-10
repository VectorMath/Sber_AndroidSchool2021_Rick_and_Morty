package com.eugenebaturov.rickandmorty.presentation.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.eugenebaturov.rickandmorty.R;
import com.eugenebaturov.rickandmorty.di.episode.DaggerEpisodeComponent;
import com.eugenebaturov.rickandmorty.di.episode.EpisodeComponent;
import com.eugenebaturov.rickandmorty.presentation.viewmodel.episode.EpisodeViewModel;
import com.eugenebaturov.rickandmorty.utils.Keys;

/**
 * Активити в которой отображается вся информация об конкретном эпизоде.
 */
public class EpisodeActivity extends BaseActivity {
    private EpisodeViewModel mViewModel;
    private ImageView mEpisodeSeasonImageView;
    private TextView mEpisodeTitleTextView;
    private TextView mEpisodeNumberTextView;
    private TextView mEpisodeAirDateTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_episode);
        initUI();
        initViewModel();
    }

    private void initUI() {
        mEpisodeSeasonImageView = findViewById(R.id.episodeSeasonNumb_imageView);
        mEpisodeTitleTextView = findViewById(R.id.episodeTitle_textView);
        mEpisodeNumberTextView = findViewById(R.id.episode_number_textView);
        mEpisodeAirDateTextView = findViewById(R.id.episode_airDate_textView);
    }

    private void initViewModel() {
        EpisodeComponent component = DaggerEpisodeComponent.create();
        mViewModel = new ViewModelProvider(
                this,
                component.getViewModelFactory())
                .get(EpisodeViewModel.class);

        int id = getIntent().getIntExtra(Keys.KEY_EPISODE_ID, 0);
        mViewModel.loadEpisodeById(id);
        observeEpisode();
    }

    private void observeEpisode() {
        int seasonImageResource = getIntent().getIntExtra(
                Keys.KEY_EPISODE_IMAGE,
                R.drawable.ic_first_season_black);

        mViewModel.getEpisode().observe(this, episode -> {
            getSupportActionBar().setTitle(episode.getTitle());

            mEpisodeSeasonImageView.setImageResource(seasonImageResource);
            mEpisodeTitleTextView.setText(episode.getTitle());
            mEpisodeNumberTextView.setText(episode.getEpisodeNumber());
            mEpisodeAirDateTextView.setText(episode.getAirDate());
        });
    }
}