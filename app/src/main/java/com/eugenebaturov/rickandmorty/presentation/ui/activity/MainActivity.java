package com.eugenebaturov.rickandmorty.presentation.ui.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.eugenebaturov.rickandmorty.R;
import com.eugenebaturov.rickandmorty.presentation.ui.fragment.CharacterListFragment;
import com.eugenebaturov.rickandmorty.presentation.ui.fragment.EpisodeListFragment;
import com.eugenebaturov.rickandmorty.presentation.ui.fragment.LocationListFragment;
import com.eugenebaturov.rickandmorty.utils.Keys;
import com.google.android.material.bottomnavigation.BottomNavigationView;

/**
 * Главная активити, где отображаются списки персонажей/эпизодов/локаций.
 */
public class MainActivity extends AppCompatActivity {

    private Fragment mFragment;
    private Searcher mSearcher;
    private String mSearchType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        initUI();
    }

    /**
     * Callback-интерфейс для поиска.
     */
    public interface Searcher {
        /**
         * Осуществляет поиск необходимый информции.
         *
         * @param whereSearch где ищем(в персонажах/эпизодах/локациях).
         * @param whatSearch  строка запроса.
         */
        void search(String whereSearch, String whatSearch);
    }

    @SuppressLint("NonConstantResourceId")
    private void initUI() {
        BottomNavigationView mBottomNavigationView = findViewById(R.id.bottom_navigation);
        SearchView mSearchView = findViewById(R.id.main_searchView);

        if (mFragment == null) {
            mFragment = CharacterListFragment.newInstance();
            mSearcher = (CharacterListFragment) mFragment;
            mSearchType = Keys.CHARACTER_SEARCH;
            startFragment(mFragment);
        }

        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                mSearchView.clearFocus();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                switch (mSearchType) {
                    case Keys.CHARACTER_SEARCH: {
                        mSearcher.search(mSearchType, newText);
                    }
                    case Keys.EPISODE_SEARCH: {
                        mSearcher.search(mSearchType, newText);
                    }
                    case Keys.LOCATION_SEARCH: {
                        mSearcher.search(mSearchType, newText);
                    }
                }

                return false;
            }
        });

        mBottomNavigationView.setOnItemSelectedListener(item -> {
            mSearchView.clearFocus();
            mSearchView.setQuery("", true);

            switch (item.getItemId()) {
                case R.id.page_1: {
                    mFragment = CharacterListFragment.newInstance();
                    mSearcher = (CharacterListFragment) mFragment;
                    mSearchType = Keys.CHARACTER_SEARCH;
                    startFragment(mFragment);
                    break;
                }

                case R.id.page_2: {
                    mFragment = LocationListFragment.newInstance();
                    mSearcher = (LocationListFragment) mFragment;
                    mSearchType = Keys.LOCATION_SEARCH;
                    startFragment(mFragment);
                    break;
                }

                case R.id.page_3: {
                    mFragment = EpisodeListFragment.newInstance();
                    mSearcher = (EpisodeListFragment) mFragment;
                    mSearchType = Keys.EPISODE_SEARCH;
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
                .add(R.id.current_fragment, fragment)
                .commit();
    }

}