package com.eugenebaturov.rickandmorty.presentation.ui.fragment.character;

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
import com.eugenebaturov.rickandmorty.app.App;
import com.eugenebaturov.rickandmorty.di.character.CharacterComponent;
import com.eugenebaturov.rickandmorty.presentation.ui.activity.MainActivity;
import com.eugenebaturov.rickandmorty.presentation.ui.adapter.CharactersAdapter;
import com.eugenebaturov.rickandmorty.presentation.viewmodel.character.CharacterListViewModel;
import com.eugenebaturov.rickandmorty.presentation.viewmodel.character.CharacterListViewModelFactory;

import javax.inject.Inject;

/**
 * Фрагмент, который отображает список персонажей.
 */
public final class CharacterListFragment extends Fragment {
    private ProgressBar mProgress;
    private RecyclerView mRecyclerView;
    private CharactersAdapter mAdapter;

    private BottomNavigation mBottomNavigation;

    private CharacterListViewModel mViewModel;

    @Inject
    CharacterListViewModelFactory mViewModelFactory;

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        injectDependency();
        initViewModel();
        return inflater.inflate(R.layout.fragment_list_characters, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initUI(view);
        observeCharacters();
        observeProgress();
        mViewModel.loadCharacters();
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
        void goToCharacter(final int characterId);
    }

    private void injectDependency() {
        CharacterComponent characterComponent
                = App.getAppComponent(requireContext()).getCharacterComponent();
        characterComponent.inject(this);
    }

    private void initViewModel() {
        mViewModel = new ViewModelProvider(
                this,
                mViewModelFactory)
                .get(CharacterListViewModel.class);
    }

    private void initUI(View view) {
        mProgress = view.findViewById(R.id.progress_bar);
        mRecyclerView = view.findViewById(R.id.recyclerView_characters);
        setRecyclerView();

        SearchView mSearchView = view.findViewById(R.id.character_searchView);
        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                mViewModel.loadCharacters(newText);
                return false;
            }
        });
    }

    private void setRecyclerView() {
        mAdapter = new CharactersAdapter(mBottomNavigation);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.hasFixedSize();
    }

    private void observeCharacters() {
        mViewModel.getCharacters().observe(
                getViewLifecycleOwner(),
                mAdapter::updateData);
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
     * Создаёт новый образец {@link CharacterListFragment}.
     *
     * @return фрагмент списка персонажей.
     */
    public static CharacterListFragment newInstance() {
        return new CharacterListFragment();
    }
}
