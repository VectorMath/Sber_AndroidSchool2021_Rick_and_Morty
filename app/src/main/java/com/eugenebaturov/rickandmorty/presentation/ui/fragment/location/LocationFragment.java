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
import com.eugenebaturov.rickandmorty.di.location.DaggerLocationComponent;
import com.eugenebaturov.rickandmorty.di.location.LocationComponent;
import com.eugenebaturov.rickandmorty.presentation.viewmodel.location.LocationViewModel;
import com.eugenebaturov.rickandmorty.utils.Extras;

/**
 * Фрагмент локации.
 */
public final class LocationFragment extends Fragment {
    private int mLocationId;
    private LocationViewModel mViewModel;

    private TextView mLocationTitleTextView;
    private TextView mLocationTypeTextView;
    private TextView mLocationDimensionTextView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        getLocationArgs();
        initViewModel();
        return inflater.inflate(R.layout.fragment_location, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initUI(view);
        mViewModel.loadLocationById(mLocationId);
        observeLocation();
    }

    private void getLocationArgs() {
        Bundle args = this.getArguments();
        if (args != null)
            mLocationId = args.getInt(Extras.EXTRA_LOCATION_ID);
    }

    private void initViewModel() {
        LocationComponent mComponent = DaggerLocationComponent.create();
        mViewModel = new ViewModelProvider(
                this,
                mComponent.getViewModelFactory())
                .get(LocationViewModel.class);
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
