package com.eugenebaturov.rickandmorty.presentation.ui.fragment;

import android.content.Context;
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
import com.eugenebaturov.rickandmorty.di.location.DaggerLocationComponent;
import com.eugenebaturov.rickandmorty.di.location.LocationComponent;
import com.eugenebaturov.rickandmorty.presentation.ui.activity.LocationActivity;
import com.eugenebaturov.rickandmorty.presentation.ui.activity.MainActivity;
import com.eugenebaturov.rickandmorty.presentation.ui.adapter.LocationsAdapter;
import com.eugenebaturov.rickandmorty.presentation.viewmodel.location.LocationListViewModel;
import com.eugenebaturov.rickandmorty.utils.Keys;

/**
 * Фрагмент, который отображает список локаций.
 * Так же является реализацией интерфейса {@link LocationsAdapter.LocationPage}.
 */
public class LocationListFragment extends Fragment
        implements LocationsAdapter.LocationPage, MainActivity.Searcher {

    private ProgressBar mProgress;
    private RecyclerView mRecyclerView;
    private LocationsAdapter mAdapter;
    private LocationListViewModel mViewModel;

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list_locations, container, false);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initUI(view);
        initViewModel();
        setRecyclerView();
        observeLocations();
        observeProgress();
    }

    @Override
    public void goToLocation(int id) {
        Intent intent = new Intent(getContext(), LocationActivity.class);
        intent.putExtra(Keys.KEY_LOCATION_ID, id);
        startActivity(intent);
    }

    @Override
    public void search(String whereSearch, String whatSearch) {
        mViewModel.loadLocations(whatSearch);
    }

    /**
     * Создаёт новый образец {@link LocationListFragment}.
     *
     * @return фрагмент списка локаций.
     */
    public static LocationListFragment newInstance() {
        return new LocationListFragment();
    }

    private void initUI(View view) {
        mProgress = view.findViewById(R.id.progress_bar);
        mRecyclerView = view.findViewById(R.id.recyclerView_locations);
    }

    private void setRecyclerView() {
        mViewModel.loadLocations();
        mAdapter = new LocationsAdapter(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.hasFixedSize();
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void initViewModel() {
        LocationComponent locationComponent = DaggerLocationComponent.create();
        mViewModel = new ViewModelProvider(
                this,
                locationComponent.getListViewModelFactory())
                .get(LocationListViewModel.class);
    }

    private void observeLocations() {
        mViewModel.getLocations().observe(
                getViewLifecycleOwner(),
                locations -> mAdapter.updateData(locations));
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
