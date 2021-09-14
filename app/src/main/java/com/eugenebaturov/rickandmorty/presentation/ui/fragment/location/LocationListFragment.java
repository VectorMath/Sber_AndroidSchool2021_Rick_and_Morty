package com.eugenebaturov.rickandmorty.presentation.ui.fragment.location;

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
import com.eugenebaturov.rickandmorty.di.location.DaggerLocationComponent;
import com.eugenebaturov.rickandmorty.di.location.LocationComponent;
import com.eugenebaturov.rickandmorty.presentation.ui.activity.MainActivity;
import com.eugenebaturov.rickandmorty.presentation.ui.adapter.LocationsAdapter;
import com.eugenebaturov.rickandmorty.presentation.viewmodel.location.LocationListViewModel;

/**
 * Фрагмент, который отображает список локаций.
 */
public final class LocationListFragment extends Fragment {
    private ProgressBar mProgress;
    private RecyclerView mRecyclerView;
    private LocationsAdapter mAdapter;

    private LocationListViewModel mViewModel;
    private BottomNavigation mBottomNavigation;

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        initViewModel();
        return inflater.inflate(R.layout.fragment_list_locations, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initUI(view);
        setRecyclerView();
        mViewModel.loadLocations();
        observeLocations();
        observeProgress();
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
        void goToLocation(int locationId);
    }

    private void initUI(View view) {
        SearchView mSearchView = view.findViewById(R.id.location_searchView);
        mProgress = view.findViewById(R.id.progress_bar);
        mRecyclerView = view.findViewById(R.id.recyclerView_locations);

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

    private void initViewModel() {
        LocationComponent locationComponent = DaggerLocationComponent.create();
        mViewModel = new ViewModelProvider(
                this,
                locationComponent.getListViewModelFactory())
                .get(LocationListViewModel.class);
    }

    private void setRecyclerView() {
        mAdapter = new LocationsAdapter(mBottomNavigation);
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
