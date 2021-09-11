package com.eugenebaturov.rickandmorty.presentation.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
import com.eugenebaturov.rickandmorty.di.character.CharacterComponent;
import com.eugenebaturov.rickandmorty.di.character.DaggerCharacterComponent;
import com.eugenebaturov.rickandmorty.presentation.ui.activity.CharacterActivity;
import com.eugenebaturov.rickandmorty.presentation.ui.activity.MainActivity;
import com.eugenebaturov.rickandmorty.presentation.ui.adapter.CharactersAdapter;
import com.eugenebaturov.rickandmorty.presentation.viewmodel.character.CharacterListViewModel;
import com.eugenebaturov.rickandmorty.utils.Keys;

/**
 * Фрагмент, который отображает список персонажей.
 * Так же является реализацией интерфейса {@link CharactersAdapter.CharacterPage}.
 */
public class CharacterListFragment extends Fragment implements
        CharactersAdapter.CharacterPage,
        MainActivity.Searcher {
    private ProgressBar mProgress;
    private RecyclerView mRecyclerView;
    private CharactersAdapter mAdapter;
    private CharacterListViewModel mViewModel;

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list_characters, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initUI(view);
        initViewModel();
        setRecyclerView();
        observeCharacters();
        observeProgress();
    }

    @Override
    public void goToCharacterActivity(int id) {
        Intent intent = new Intent(getContext(), CharacterActivity.class);
        intent.putExtra(Keys.KEY_CHARACTER_ID, id);
        startActivity(intent);
    }

    /**
     * Создаёт новый образец {@link CharacterListFragment}.
     *
     * @return фрагмент списка персонажей.
     */
    public static CharacterListFragment newInstance() {
        return new CharacterListFragment();
    }

    private void initUI(View view) {
        mProgress = view.findViewById(R.id.progress_bar);
        mRecyclerView = view.findViewById(R.id.recyclerView_characters);
    }

    private void setRecyclerView() {
        mViewModel.loadCharacters();
        mAdapter = new CharactersAdapter(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.hasFixedSize();
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void initViewModel() {
        CharacterComponent characterComponent = DaggerCharacterComponent.create();
        mViewModel = new ViewModelProvider(
                this,
                characterComponent.getListViewModelFactory())
                .get(CharacterListViewModel.class);
    }

    private void observeCharacters() {
        mViewModel.getCharacters().observe(
                getViewLifecycleOwner(),
                characters -> mAdapter.updateData(characters));
    }

    private void observeProgress() {
        mViewModel.getProgress().observe(getViewLifecycleOwner(), progress -> {
            if (!progress)
                mProgress.setVisibility(View.INVISIBLE);
            else
                mProgress.setVisibility(View.VISIBLE);
        });
    }

    @Override
    public void search(String whereSearch, String whatSearch) {
        mViewModel.loadCharacters(whatSearch);
        observeCharacters();
        observeProgress();
        mAdapter.notifyDataSetChanged();
    }
}
