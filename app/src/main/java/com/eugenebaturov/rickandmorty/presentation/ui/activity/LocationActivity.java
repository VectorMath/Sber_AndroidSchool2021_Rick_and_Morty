package com.eugenebaturov.rickandmorty.presentation.ui.activity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.lifecycle.ViewModelProvider;

import com.eugenebaturov.rickandmorty.R;
import com.eugenebaturov.rickandmorty.di.location.DaggerLocationComponent;
import com.eugenebaturov.rickandmorty.di.location.LocationComponent;
import com.eugenebaturov.rickandmorty.presentation.viewmodel.location.LocationViewModel;
import com.eugenebaturov.rickandmorty.utils.Keys;

/**
 * Активити в которой отображается вся информация о конкретной локации.
 */
public class LocationActivity extends BaseActivity {
    private LocationViewModel mViewModel;
    private TextView mLocationTitleTextView;
    private TextView mLocationTypeTextView;
    private TextView mLocationDimensionTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        initUI();
        initViewModel();
    }

    private void initUI() {
        mLocationTitleTextView = findViewById(R.id.locationTitle_textView);
        mLocationTypeTextView = findViewById(R.id.locationType_textView);
        mLocationDimensionTextView = findViewById(R.id.locationDimension_textView);
    }

    private void initViewModel() {
        LocationComponent locationComponent = DaggerLocationComponent.create();
        mViewModel = new ViewModelProvider(
                this,
                locationComponent.getViewModelFactory())
                .get(LocationViewModel.class);

        int mId = getIntent().getIntExtra(Keys.KEY_LOCATION_ID, 0);
        mViewModel.loadLocationById(mId);
        observeLocationInfo();
    }

    private void observeLocationInfo() {
        mViewModel.getLocation().observe(this, location -> {
            getSupportActionBar().setTitle(location.getName());
            mLocationTitleTextView.setText(location.getName());
            mLocationTypeTextView.setText(location.getType());
            mLocationDimensionTextView.setText(location.getDimension());
        });
    }
}