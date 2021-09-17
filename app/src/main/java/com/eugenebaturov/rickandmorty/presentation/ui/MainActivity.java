package com.eugenebaturov.rickandmorty.presentation.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.preference.PreferenceManager;

import com.eugenebaturov.rickandmorty.R;
import com.eugenebaturov.rickandmorty.presentation.ui.fragment.SettingsFragment;
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
public final class MainActivity extends AppCompatActivity implements Navigation {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initTheme(getApplicationContext());
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            startFragment(CharacterListFragment.newInstance(), false);
        }
        initUI();
    }


    private void initTheme(Context context) {
        SharedPreferences mPreference
                = PreferenceManager.getDefaultSharedPreferences(context);
        final boolean isNightMode
                = mPreference.getBoolean(getString(R.string.night_mode_key), false);
        if (isNightMode)
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        else
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
    }

    @Override
    public void goToCharacter(final int characterId) {
        startFragment(CharacterFragment.newInstance(characterId), true);
    }

    @Override
    public void goToEpisode(final int episodeId, final int imageRecourse) {
        startFragment(EpisodeFragment.newInstance(episodeId, imageRecourse), true);
    }

    @Override
    public void goToLocation(final int locationId) {
        startFragment(LocationFragment.newInstance(locationId), true);
    }

    @SuppressLint("NonConstantResourceId")
    private void initUI() {

        BottomNavigationView mBottomNavigationView = findViewById(R.id.bottom_navigation);
        mBottomNavigationView.setOnItemSelectedListener(item -> {

            final Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.current_fragment);
            switch (item.getItemId()) {
                case R.id.page_1: {
                    if (!(currentFragment instanceof CharacterListFragment)) {
                        clearBackStack();
                        startFragment(CharacterListFragment.newInstance(), false);
                        return true;
                    }
                    break;
                }

                case R.id.page_2: {
                    if (!(currentFragment instanceof LocationListFragment)) {
                        clearBackStack();
                        startFragment(LocationListFragment.newInstance(), false);
                        return true;
                    }
                    break;
                }

                case R.id.page_3: {
                    if (!(currentFragment instanceof EpisodeListFragment)) {
                        clearBackStack();
                        startFragment(EpisodeListFragment.newInstance(), false);
                        return true;
                    }
                    break;
                }

                case R.id.page_4: {
                    if (!(currentFragment instanceof SettingsFragment)) {
                        clearBackStack();
                        startFragment(SettingsFragment.newInstance(), false);
                        return true;
                    }
                    break;
                }
            }
            return false;
        });
    }

    private void startFragment(Fragment fragment, boolean addToBackStack) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.current_fragment, fragment);

        if (addToBackStack) {
            fragmentTransaction.addToBackStack(null);
        }

        fragmentTransaction.commit();
    }

    private void clearBackStack() {
        getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
    }
}