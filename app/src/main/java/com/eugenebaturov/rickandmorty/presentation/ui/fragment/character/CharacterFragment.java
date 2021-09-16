package com.eugenebaturov.rickandmorty.presentation.ui.fragment.character;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.eugenebaturov.rickandmorty.App;
import com.eugenebaturov.rickandmorty.R;
import com.eugenebaturov.rickandmorty.di.character.CharacterSubcomponent;
import com.eugenebaturov.rickandmorty.presentation.ui.fragment.BaseFragment;
import com.eugenebaturov.rickandmorty.presentation.viewmodel.character.CharacterViewModel;
import com.eugenebaturov.rickandmorty.presentation.viewmodel.character.CharacterViewModelFactory;
import com.eugenebaturov.rickandmorty.utils.ImageLoader;

import javax.inject.Inject;

/**
 * Фрагмент, который отображает конкретного персонажа.
 */
public final class CharacterFragment extends BaseFragment {
    private static final String EXTRA_CHARACTER_ID = "EXTRA_CHARACTER_ID";

    private int mCharacterId;

    private ImageView mCharacterAvatarImageView;
    private ImageView mCharacterStatusImageView;
    private TextView mCharacterNameTextView;
    private TextView mCharacterStatusTextView;
    private TextView mCharacterGenderTextView;
    private TextView mCharacterRaceTextView;
    private TextView mCharacterOriginLinkTextView;
    private TextView mCharacterCurrentLocationLinkTextView;

    private CharacterViewModel mViewModel;

    @Inject
    CharacterViewModelFactory mViewModelFactory;

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        injectDependency();
        initViewModel();
        getCharacterArgs();
        return inflater.inflate(R.layout.fragment_character, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initUI(view);
        observeCharacter();
        mViewModel.loadCharacterById(mCharacterId);
    }

    private void getCharacterArgs() {
        mCharacterId = requireArguments().getInt(EXTRA_CHARACTER_ID);
    }

    private void injectDependency() {
        CharacterSubcomponent characterSubcomponent
                = App.getAppComponent(requireContext()).getCharacterSubcomponent();
        characterSubcomponent.inject(this);
    }

    private void initViewModel() {
        mViewModel = new ViewModelProvider(
                this,
                mViewModelFactory)
                .get(CharacterViewModel.class);
    }

    private void initUI(View view) {
        mCharacterAvatarImageView
                = view.findViewById(R.id.character_imageView);
        mCharacterStatusImageView =
                view.findViewById(R.id.characterStatus_imageView);
        mCharacterNameTextView
                = view.findViewById(R.id.character_name_textView);
        mCharacterStatusTextView
                = view.findViewById(R.id.character_status_textView);
        mCharacterGenderTextView
                = view.findViewById(R.id.character_gender_textView);
        mCharacterRaceTextView
                = view.findViewById(R.id.character_race_textView);
        mCharacterOriginLinkTextView
                = view.findViewById(R.id.character_origin_textView);
        mCharacterCurrentLocationLinkTextView
                = view.findViewById(R.id.character_current_location_textView);
    }

    private void observeCharacter() {
        mViewModel.getCharacter().observe(getViewLifecycleOwner(), character -> {

            ImageLoader.loadFromPicasso(character.getImageUrl(), mCharacterAvatarImageView);
            mCharacterStatusImageView.setImageResource(character.getImageStatusResource());
            mCharacterNameTextView.setText(character.getName());
            mCharacterStatusTextView.setText(character.getStatus());
            mCharacterGenderTextView.setText(character.getGender());
            mCharacterRaceTextView.setText(character.getSpecies());
            mCharacterOriginLinkTextView.setText(character.getOrigin().getName());
            mCharacterCurrentLocationLinkTextView.setText(character.getCurrentLocation().getName());

            if (character.getOriginId() != 0) {
                mCharacterOriginLinkTextView
                        .setTextColor(ContextCompat.getColor(requireContext(), R.color.text_link));
                mCharacterOriginLinkTextView
                        .setOnClickListener(v -> mNavigation.goToLocation(character.getOriginId()));
            }


            if (character.getCurrentLocationId() != 0) {
                mCharacterCurrentLocationLinkTextView
                        .setTextColor(ContextCompat.getColor(requireContext(), R.color.text_link));
                mCharacterCurrentLocationLinkTextView
                        .setOnClickListener(v -> mNavigation.goToLocation(character.getCurrentLocationId()));
            }
        });
    }

    /**
     * Создаёт новый образец {@link CharacterFragment}.
     *
     * @param characterId id персонажа.
     * @return фрагмент персонажа.
     */
    public static Fragment newInstance(final int characterId) {
        Bundle args = new Bundle();
        args.putInt(EXTRA_CHARACTER_ID, characterId);
        CharacterFragment fragment = new CharacterFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
