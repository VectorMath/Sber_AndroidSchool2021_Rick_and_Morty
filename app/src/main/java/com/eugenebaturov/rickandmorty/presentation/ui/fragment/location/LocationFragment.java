package com.eugenebaturov.rickandmorty.presentation.ui.fragment.location;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.eugenebaturov.rickandmorty.R;
import com.eugenebaturov.rickandmorty.App;
import com.eugenebaturov.rickandmorty.di.location.LocationSubcomponent;
import com.eugenebaturov.rickandmorty.presentation.ui.fragment.BaseFragment;
import com.eugenebaturov.rickandmorty.presentation.viewmodel.location.LocationViewModel;
import com.eugenebaturov.rickandmorty.presentation.viewmodel.location.LocationViewModelFactory;

import javax.inject.Inject;

/**
 * Фрагмент локации.
 */
public final class LocationFragment extends BaseFragment {
    private static final String EXTRA_LOCATION_ID = "EXTRA_LOCATION_ID";
    private int mLocationId;

    private TextView mLocationTitleTextView;
    private TextView mLocationTypeTextView;
    private TextView mLocationDimensionTextView;

    private LocationViewModel mViewModel;

    @Inject
    LocationViewModelFactory mViewModelFactory;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        injectDependency();
        initViewModel();
        getLocationArgs();
        return inflater.inflate(R.layout.fragment_location, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initUI(view);
        mViewModel.loadLocationById(mLocationId);
        observeLocation();
    }

    private void injectDependency() {
        LocationSubcomponent mComponent
                = App.getAppComponent(requireContext()).getLocationSubcomponent();
        mComponent.inject(this);
    }

    private void initViewModel() {
        mViewModel = new ViewModelProvider(
                this,
                mViewModelFactory)
                .get(LocationViewModel.class);
    }

    private void getLocationArgs() {
        mLocationId = requireArguments().getInt(EXTRA_LOCATION_ID);
    }

    private void initUI(View view) {
        mLocationTitleTextView = view.findViewById(R.id.location_title_textView);
        mLocationTypeTextView = view.findViewById(R.id.location_type_textView);
        mLocationDimensionTextView = view.findViewById(R.id.location_dimension_textView);
    }

    private void observeLocation() {
        mViewModel.getLocation().observe(getViewLifecycleOwner(), location -> {
            mLocationTitleTextView.setText(location.getName());
            mLocationTypeTextView.setText(location.getType());
            mLocationDimensionTextView.setText(location.getDimension());
        });
    }

    /**
     * Создаёт новый образец {@link LocationFragment}.
     *
     * @param locationId id локации.
     * @return фрагмент локации.
     */
    public static LocationFragment newInstance(final int locationId) {
        Bundle args = new Bundle();
        args.putInt(EXTRA_LOCATION_ID, locationId);
        LocationFragment fragment = new LocationFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
