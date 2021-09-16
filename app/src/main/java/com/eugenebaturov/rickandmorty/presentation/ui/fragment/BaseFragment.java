package com.eugenebaturov.rickandmorty.presentation.ui.fragment;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.eugenebaturov.rickandmorty.presentation.ui.MainActivity;
import com.eugenebaturov.rickandmorty.presentation.ui.Navigation;

/**
 * Базовый фрагмент.
 */
public class BaseFragment extends Fragment {
    protected Navigation mNavigation;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mNavigation = (MainActivity) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mNavigation = null;
    }
}
