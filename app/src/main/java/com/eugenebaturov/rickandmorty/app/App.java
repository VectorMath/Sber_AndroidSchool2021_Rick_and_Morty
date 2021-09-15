package com.eugenebaturov.rickandmorty.app;

import android.app.Application;
import android.content.SharedPreferences;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.preference.PreferenceManager;

/**
 * Класс-приложение.
 */
public final class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        RetrofitInstance.getInstance();
        SchedulerProviderInstance.getInstance();
    }
}
