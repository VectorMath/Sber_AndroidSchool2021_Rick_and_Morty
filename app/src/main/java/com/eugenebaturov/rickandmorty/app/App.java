package com.eugenebaturov.rickandmorty.app;

import android.app.Application;

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
