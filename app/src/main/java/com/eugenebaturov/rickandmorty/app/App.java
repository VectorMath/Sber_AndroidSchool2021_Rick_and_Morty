package com.eugenebaturov.rickandmorty.app;

import android.app.Application;
import android.content.Context;

import com.eugenebaturov.rickandmorty.di.AppComponent;
import com.eugenebaturov.rickandmorty.di.DaggerAppComponent;


/**
 * Класс-приложение.
 */
public final class App extends Application {
    private AppComponent mAppComponent;

    public static AppComponent getAppComponent(Context context) {
        return ((App) context.getApplicationContext()).mAppComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mAppComponent = DaggerAppComponent.factory().create();
    }
}
