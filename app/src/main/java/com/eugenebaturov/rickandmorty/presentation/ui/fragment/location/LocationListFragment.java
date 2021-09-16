package com.eugenebaturov.rickandmorty.presentation.ui.fragment.location;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.eugenebaturov.rickandmorty.App;
import com.eugenebaturov.rickandmorty.R;
import com.eugenebaturov.rickandmorty.di.location.LocationSubcomponent;
import com.eugenebaturov.rickandmorty.presentation.ui.adapter.LocationsAdapter;
import com.eugenebaturov.rickandmorty.presentation.ui.fragment.BaseFragment;
import com.eugenebaturov.rickandmorty.presentation.viewmodel.location.LocationListViewModel;
import com.eugenebaturov.rickandmorty.presentation.viewmodel.location.LocationListViewModelFactory;

import javax.inject.Inject;

/**
 * Фрагмент, который отображает список локаций.
 */
public final class LocationListFragment extends BaseFragment {
    private ProgressBar mProgress;
    private RecyclerView mRecyclerView;
    private LocationsAdapter mAdapter;

    private LocationListViewModel mViewModel;

    @Inject
    LocationListViewModelFactory mViewModelFactory;

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        injectDependency();
        initViewModel();
        return inflater.inflate(R.layout.fragment_list_locations, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initUI(view);
        observeLocations();
        observeProgress();
        mViewModel.loadLocations();
    }

    private void injectDependency() {
        LocationSubcomponent locationSubcomponent
                = App.getAppComponent(requireContext()).getLocationSubcomponent();
        locationSubcomponent.inject(this);
    }

    private void initViewModel() {
        mViewModel = new ViewModelProvider(
                this,
                mViewModelFactory)
                .get(LocationListViewModel.class);
    }

    private void initUI(View view) {
        mProgress = view.findViewById(R.id.progress_bar);
        mRecyclerView = view.findViewById(R.id.recyclerView_locations);
        setRecyclerView();

        SearchView mSearchView = view.findViewById(R.id.location_searchView);
        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                mViewModel.loadLocations(newText);
                return false;
            }
        });
    }

    private void setRecyclerView() {
        mAdapter = new LocationsAdapter(mNavigation);
        mRecyclerView.hasFixedSize();
        mRecyclerView.setAdapter(mAdapter);
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

    /**
     * Создаёт новый образец {@link LocationListFragment}.
     *
     * @return фрагмент списка локаций.
     */
    public static LocationListFragment newInstance() {
        return new LocationListFragment();
    }
}
