package com.eugenebaturov.rickandmorty.presentation.viewmodel.main;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.eugenebaturov.rickandmorty.presentation.ui.MainActivity;

/**
 * ВьюМодель {@link MainActivity}.
 */
public final class MainViewModel extends ViewModel {
    private Fragment mFragment;

    /**
     * Getter для фрагмента.
     *
     * @return фрагмент.
     */
    public Fragment getFragment() {
        return mFragment;
    }

    /**
     * Setter для фрагмента
     *
     * @param fragment фрагмент.
     */
    public void setFragment(Fragment fragment) {
        mFragment = fragment;
    }
}
