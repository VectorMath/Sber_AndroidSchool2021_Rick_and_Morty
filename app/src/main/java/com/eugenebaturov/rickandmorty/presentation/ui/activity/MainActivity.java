package com.eugenebaturov.rickandmorty.presentation.ui.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.eugenebaturov.rickandmorty.R;
import com.eugenebaturov.rickandmorty.presentation.ui.fragment.CharacterListFragment;
import com.eugenebaturov.rickandmorty.presentation.ui.fragment.EpisodeListFragment;
import com.eugenebaturov.rickandmorty.presentation.ui.fragment.LocationListFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
    }

    @SuppressLint("NonConstantResourceId")
    private void initUI() {
        BottomNavigationView mBottomNavigationView = findViewById(R.id.bottom_navigation);

        if (fragment == null) {
            fragment = CharacterListFragment.newInstance();
            startFragment(fragment);
        }

        mBottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.page_1: {
                    fragment = CharacterListFragment.newInstance();
                    startFragment(fragment);
                    break;
                }

                case R.id.page_2: {
                    fragment = LocationListFragment.newInstance();
                    startFragment(fragment);
                    break;
                }

                case R.id.page_3: {
                    fragment = EpisodeListFragment.newInstance();
                    startFragment(fragment);
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

}