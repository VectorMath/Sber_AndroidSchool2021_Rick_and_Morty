package com.eugenebaturov.rickandmorty.presentation.ui.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.eugenebaturov.rickandmorty.R;
import com.eugenebaturov.rickandmorty.prefs.SettingsFragment;
import com.eugenebaturov.rickandmorty.presentation.ui.fragment.character.CharacterFragment;
import com.eugenebaturov.rickandmorty.presentation.ui.fragment.character.CharacterListFragment;
import com.eugenebaturov.rickandmorty.presentation.ui.fragment.episode.EpisodeFragment;
import com.eugenebaturov.rickandmorty.presentation.ui.fragment.episode.EpisodeListFragment;
import com.eugenebaturov.rickandmorty.presentation.ui.fragment.location.LocationFragment;
import com.eugenebaturov.rickandmorty.presentation.ui.fragment.location.LocationListFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

/**
 * Главная активити, где происходят все действия приложения.
 */
public final class MainActivity extends AppCompatActivity implements CharacterListFragment.BottomNavigation,
        EpisodeListFragment.BottomNavigation, LocationListFragment.BottomNavigation,
        CharacterFragment.FromTo {
    private Fragment mFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
    }

    @Override
    public void goToCharacter(final int characterId) {
        mFragment = CharacterFragment.newInstance(characterId);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.current_fragment, mFragment)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void goToEpisode(final int episodeId, final int imageRecourse) {
        mFragment = EpisodeFragment.newInstance(episodeId, imageRecourse);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.current_fragment, mFragment)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void goToLocation(final int locationId) {
        mFragment = LocationFragment.newInstance(locationId);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.current_fragment, mFragment)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void fromCharacterToLocation(final int locationId) {
        mFragment = LocationFragment.newInstance(locationId);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.current_fragment, mFragment)
                .addToBackStack(null)
                .commit();
    }

    @SuppressLint("NonConstantResourceId")
    private void initUI() {
        BottomNavigationView mBottomNavigationView = findViewById(R.id.bottom_navigation);

        if (mFragment == null) {
            mFragment = CharacterListFragment.newInstance();
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.current_fragment, mFragment)
                    .commit();
        }

        mBottomNavigationView.setOnItemSelectedListener(item -> {

            switch (item.getItemId()) {
                case R.id.page_1: {
                    clearBackStack();
                    mFragment = CharacterListFragment.newInstance();
                    startFragment(mFragment);
                    break;
                }

                case R.id.page_2: {
                    clearBackStack();
                    mFragment = LocationListFragment.newInstance();
                    startFragment(mFragment);
                    break;
                }

                case R.id.page_3: {
                    clearBackStack();
                    mFragment = EpisodeListFragment.newInstance();
                    startFragment(mFragment);
                    break;
                }

                case R.id.page_4: {
                    clearBackStack();
                    mFragment = SettingsFragment.newInstance();
                    startFragment(mFragment);
                    break;
                }
            }
            return true;
        });
    }

    private void startFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.current_fragment, fragment)
                .commit();
    }

    private void clearBackStack() {
        final FragmentManager fragmentManager = getSupportFragmentManager();
        for (int i = 0; i < fragmentManager.getBackStackEntryCount(); ++i) {
            fragmentManager.popBackStack();
        }
    }
}