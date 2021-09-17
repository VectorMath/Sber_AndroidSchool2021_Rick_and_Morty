package com.eugenebaturov.rickandmorty.presentation.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;

import com.eugenebaturov.rickandmorty.App;
import com.eugenebaturov.rickandmorty.R;
import com.eugenebaturov.rickandmorty.di.main.MainActivitySubcomponent;
import com.eugenebaturov.rickandmorty.prefs.SettingsFragment;
import com.eugenebaturov.rickandmorty.presentation.ui.fragment.character.CharacterFragment;
import com.eugenebaturov.rickandmorty.presentation.ui.fragment.character.CharacterListFragment;
import com.eugenebaturov.rickandmorty.presentation.ui.fragment.episode.EpisodeFragment;
import com.eugenebaturov.rickandmorty.presentation.ui.fragment.episode.EpisodeListFragment;
import com.eugenebaturov.rickandmorty.presentation.ui.fragment.location.LocationFragment;
import com.eugenebaturov.rickandmorty.presentation.ui.fragment.location.LocationListFragment;
import com.eugenebaturov.rickandmorty.presentation.viewmodel.main.MainViewModel;
import com.eugenebaturov.rickandmorty.presentation.viewmodel.main.MainViewModelFactory;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import javax.inject.Inject;

/**
 * Главная активити, где происходят все действия приложения.
 */
public final class MainActivity extends AppCompatActivity implements Navigation {
    private MainViewModel mViewModel;

    @Inject
    MainViewModelFactory mViewModelFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        injectDependency();
        initViewModel();
        initUI(savedInstanceState);
    }

    @Override
    public void goToCharacter(final int characterId) {
        mViewModel.setFragment(CharacterFragment.newInstance(characterId));
        goToFragment(mViewModel.getFragment());
    }

    @Override
    public void goToEpisode(final int episodeId, final int imageRecourse) {
        mViewModel.setFragment(EpisodeFragment.newInstance(episodeId, imageRecourse));
        goToFragment(mViewModel.getFragment());
    }

    @Override
    public void goToLocation(final int locationId) {
        mViewModel.setFragment(LocationFragment.newInstance(locationId));
        goToFragment(mViewModel.getFragment());
    }

    private void injectDependency() {
        MainActivitySubcomponent activitySubcomponent
                = App.getAppComponent(this).getMainActivitySubcomponent();
        activitySubcomponent.inject(this);
    }

    private void initViewModel() {
        mViewModel = new ViewModelProvider(this, mViewModelFactory).get(MainViewModel.class);
    }

    @SuppressLint("NonConstantResourceId")
    private void initUI(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            mViewModel.setFragment(CharacterListFragment.newInstance());
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.current_fragment, mViewModel.getFragment())
                    .commit();
        }

        BottomNavigationView mBottomNavigationView = findViewById(R.id.bottom_navigation);
        mBottomNavigationView.setOnItemSelectedListener(item -> {

            switch (item.getItemId()) {
                case R.id.page_1: {
                    if (!(mViewModel.getFragment() instanceof CharacterListFragment)) {
                        clearBackStack();
                        mViewModel.setFragment(CharacterListFragment.newInstance());
                        startFragment(mViewModel.getFragment());
                        return true;
                    }
                    break;
                }

                case R.id.page_2: {
                    if (!(mViewModel.getFragment() instanceof LocationListFragment)) {
                        clearBackStack();
                        mViewModel.setFragment(LocationListFragment.newInstance());
                        startFragment(mViewModel.getFragment());
                        return true;
                    }
                    break;
                }

                case R.id.page_3: {
                    if (!(mViewModel.getFragment() instanceof EpisodeListFragment)) {
                        clearBackStack();
                        mViewModel.setFragment(EpisodeListFragment.newInstance());
                        startFragment(mViewModel.getFragment());
                        return true;
                    }
                    break;
                }

                case R.id.page_4: {
                    if (!(mViewModel.getFragment() instanceof SettingsFragment)) {
                        clearBackStack();
                        mViewModel.setFragment(SettingsFragment.newInstance());
                        startFragment(mViewModel.getFragment());
                        return true;
                    }
                    break;
                }
            }
            return false;
        });
    }

    private void startFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.current_fragment, fragment)
                .commit();
    }

    private void goToFragment(@NonNull final Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.current_fragment, fragment)
                .addToBackStack(null)
                .commit();
    }

    private void clearBackStack() {
        final FragmentManager fragmentManager = getSupportFragmentManager();
        for (int i = 0; i < fragmentManager.getBackStackEntryCount(); ++i) {
            fragmentManager.popBackStack();
        }
    }
}