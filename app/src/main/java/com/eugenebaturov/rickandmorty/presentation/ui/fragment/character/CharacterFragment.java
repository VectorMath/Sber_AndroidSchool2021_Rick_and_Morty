package com.eugenebaturov.rickandmorty.presentation.ui.fragment.character;

import android.content.Context;
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

import com.eugenebaturov.rickandmorty.R;
import com.eugenebaturov.rickandmorty.app.App;
import com.eugenebaturov.rickandmorty.di.character.CharacterComponent;
import com.eugenebaturov.rickandmorty.presentation.ui.activity.MainActivity;
import com.eugenebaturov.rickandmorty.presentation.ui.fragment.location.LocationFragment;
import com.eugenebaturov.rickandmorty.presentation.viewmodel.character.CharacterViewModel;
import com.eugenebaturov.rickandmorty.presentation.viewmodel.character.CharacterViewModelFactory;
import com.eugenebaturov.rickandmorty.utils.IdTaker;
import com.eugenebaturov.rickandmorty.utils.ImageLoader;

import javax.inject.Inject;

/**
 * Фрагмент, который отображает конкретного персонажа.
 */
public final class CharacterFragment extends Fragment {
    private static final String EXTRA_CHARACTER_ID = "EXTRA_CHARACTER_ID";
    private static final String UNKNOWN = "unknown";
    private static final String NOTHING = "-";

    private int mCharacterId;
    private int mOriginId;
    private int mCurrentLocationId;

    private FromTo mFromTo;

    private ImageView mCharacterAvatarImageView;
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

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mFromTo = (MainActivity) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mFromTo = null;
    }

    /**
     * Callback-интерфейс для перехода между фрагментами.
     */
    public interface FromTo {

        /**
         * Переход из {@link CharacterFragment} в {@link LocationFragment}.
         *
         * @param locationId id локации.
         */
        void fromCharacterToLocation(int locationId);
    }

    private void getCharacterArgs() {
        mCharacterId = requireArguments().getInt(EXTRA_CHARACTER_ID);
    }

    private void injectDependency() {
        CharacterComponent characterComponent
                = App.getAppComponent(requireContext()).getCharacterComponent();
        characterComponent.inject(this);
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

        mCharacterOriginLinkTextView
                .setOnClickListener(v -> mFromTo.fromCharacterToLocation(mOriginId));
        mCharacterCurrentLocationLinkTextView
                .setOnClickListener(v -> mFromTo.fromCharacterToLocation(mCurrentLocationId));
    }

    private void observeCharacter() {
        mViewModel.getCharacter().observe(getViewLifecycleOwner(), character -> {
            final String originUrl = character.getOrigin().getUrl();
            final String currentUrl = character.getCurrentLocation().getUrl();
            final String originName = character.getOrigin().getName();
            final String currentLocationName = character.getCurrentLocation().getName();

            ImageLoader.loadFromPicasso(character.getImage(), mCharacterAvatarImageView);
            mCharacterNameTextView.setText(character.getName());
            mCharacterStatusTextView.setText(character.getStatus());
            mCharacterGenderTextView.setText(character.getGender());
            mCharacterRaceTextView.setText(character.getSpecies());

            checkLocation(originUrl,
                    originName,
                    mCharacterOriginLinkTextView,
                    true);

            checkLocation(currentUrl,
                    currentLocationName,
                    mCharacterCurrentLocationLinkTextView,
                    false);
        });
    }

    // Проверяет существует ли локация.
    // Если да, то мы отображем название локации и получаем её id.
    private void checkLocation(String url,
                               String locationName,
                               TextView textView,
                               boolean isOrigin) {
        if (!locationName.equals(UNKNOWN)) {
            textView.setText(locationName);
            if (isOrigin)
                mOriginId = IdTaker.getLocationId(url);
            else
                mCurrentLocationId = IdTaker.getLocationId(url);
        } else {
            textView.setTextColor(ContextCompat.getColor(requireContext(), R.color.black));
            textView.setText(NOTHING);
            textView.setEnabled(false);
        }
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
