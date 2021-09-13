package com.eugenebaturov.rickandmorty.presentation.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProvider;

import com.eugenebaturov.rickandmorty.R;
import com.eugenebaturov.rickandmorty.di.character.CharacterComponent;
import com.eugenebaturov.rickandmorty.di.character.DaggerCharacterComponent;
import com.eugenebaturov.rickandmorty.presentation.viewmodel.character.CharacterViewModel;
import com.eugenebaturov.rickandmorty.utils.IdTaker;
import com.eugenebaturov.rickandmorty.utils.Extras;
import com.squareup.picasso.Picasso;

/**
 * Активити в которой отображается вся информация о конкретном персонаже.
 */

// Перенсти ui во фрагмент
public class CharacterActivity extends BaseActivity {
    private CharacterViewModel mViewModel;
    private int mId;
    private int mOriginId;
    private int mCurrentLocationId;
    private ImageView mCharacterAvatarImageView;
    private TextView mCharacterNameTextView;
    private TextView mCharacterStatusTextView;
    private TextView mCharacterGenderTextView;
    private TextView mCharacterRaceTextView;
    private TextView mCharacterOriginLinkTextView;
    private TextView mCharacterCurrentLocationLinkTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character);
        mId = getIntent().getIntExtra(Extras.EXTRA_CHARACTER_ID, 0);
        initUI();
        initViewModel();
    }

    private void initUI() {
        // id: characterName_textView-> character_name_textView
        mCharacterAvatarImageView = findViewById(R.id.character_imageView);
        mCharacterNameTextView = findViewById(R.id.characterName_textView);
        mCharacterStatusTextView = findViewById(R.id.characterStatus_textView);
        mCharacterGenderTextView = findViewById(R.id.character_gender_textView);
        mCharacterRaceTextView = findViewById(R.id.characterRace_textView);
        mCharacterOriginLinkTextView = findViewById(R.id.characterOrigin_textView);
        mCharacterCurrentLocationLinkTextView = findViewById(R.id.characterCurrentLocation_textView);

        mCharacterOriginLinkTextView.setOnClickListener(v -> goToLocation(mOriginId));
        mCharacterCurrentLocationLinkTextView.setOnClickListener(v -> goToLocation(mCurrentLocationId));
    }

    private void initViewModel() {
        // https://developer.android.com/training/dependency-injection/dagger-android
        CharacterComponent characterComponent = DaggerCharacterComponent.create();
        mViewModel = new ViewModelProvider(
                this,
                characterComponent.getViewModelFactory()
        ).get(CharacterViewModel.class);

        mViewModel.loadCharacterById(mId);
        observeCharacterInfo();
    }

    // Без Suppress
    private void observeCharacterInfo() {
        mViewModel.getCharacter().observe(this, character -> {
            getSupportActionBar().setTitle(character.getName());

            final String originUrl = character.getOrigin().getUrl();
            final String currentUrl = character.getCurrentLocation().getUrl();
            final String originName = character.getOrigin().getName();
            final String currentLocationName = character.getCurrentLocation().getName();

            // зависимость на конкрентную реалзиаицю. Вынести, чтбы в любьой момент
            // можно было подложить другую реализаицию
            Picasso.get().load(character.getImage()).into(mCharacterAvatarImageView);
            mCharacterNameTextView.setText(character.getName());
            mCharacterStatusTextView.setText(character.getStatus());
            mCharacterGenderTextView.setText(character.getGender());
            mCharacterRaceTextView.setText(character.getSpecies());
            checkLocation(originUrl, originName, mCharacterOriginLinkTextView, true);
            checkLocation(currentUrl, currentLocationName, mCharacterCurrentLocationLinkTextView, false);

        });
    }

    private void goToLocation(int locationId) {
        Intent intent = new Intent(this, LocationActivity.class);
        intent.putExtra(Extras.EXTRA_LOCATION_ID, locationId);
        startActivity(intent);
    }

    private void checkLocation(String url, String locationName, TextView textView, boolean isOrigin) {
        if (!locationName.equals("unknown")) {
            textView.setText(locationName);
            if (isOrigin)
                mOriginId = IdTaker.getLocationId(url);
            else
                mCurrentLocationId = IdTaker.getLocationId(url);
        } else {
            textView.setTextColor(ContextCompat.getColor(this, R.color.black));
            textView.setText("-");
            textView.setEnabled(false);
        }
    }
}