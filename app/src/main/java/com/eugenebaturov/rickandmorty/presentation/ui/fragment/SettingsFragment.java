package com.eugenebaturov.rickandmorty.presentation.ui.fragment;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceManager;
import androidx.preference.SwitchPreference;

import com.eugenebaturov.rickandmorty.R;

import java.util.Objects;

public final class SettingsFragment extends PreferenceFragmentCompat {

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.preference, rootKey);

        SharedPreferences mPreference
                = PreferenceManager.getDefaultSharedPreferences(requireContext());
        final boolean isNightMode
                = mPreference.getBoolean(getString(R.string.night_mode_key), false);

        SwitchPreference mSwitchPreference =
                Objects.requireNonNull(findPreference(getString(R.string.night_mode_key)));

        mSwitchPreference.setOnPreferenceClickListener(preference -> {
            if (!isNightMode)
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            else
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            return true;
        });
    }

    public static SettingsFragment newInstance() {
        return new SettingsFragment();
    }
}
