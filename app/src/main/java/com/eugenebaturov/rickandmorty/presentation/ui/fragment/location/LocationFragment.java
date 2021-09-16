package com.eugenebaturov.rickandmorty.presentation.ui.fragment.location;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.eugenebaturov.rickandmorty.R;
import com.eugenebaturov.rickandmorty.app.App;
import com.eugenebaturov.rickandmorty.di.location.LocationComponent;
import com.eugenebaturov.rickandmorty.presentation.viewmodel.location.LocationViewModel;
import com.eugenebaturov.rickandmorty.presentation.viewmodel.location.LocationViewModelFactory;
import com.eugenebaturov.rickandmorty.utils.Extras;

import javax.inject.Inject;

/**
 * Фрагмент локации.
 */
public final class LocationFragment extends Fragment {
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
        LocationComponent mComponent
                = App.getAppComponent(requireContext()).getLocationComponent();
        mComponent.inject(this);
    }

    private void initViewModel() {
        mViewModel = new ViewModelProvider(
                this,
                mViewModelFactory)
                .get(LocationViewModel.class);
    }

    private void getLocationArgs() {
        mLocationId = requireArguments().getInt(Extras.EXTRA_LOCATION_ID);
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
        args.putInt(Extras.EXTRA_LOCATION_ID, locationId);
        LocationFragment fragment = new LocationFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
