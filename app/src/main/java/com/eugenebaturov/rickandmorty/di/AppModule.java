package com.eugenebaturov.rickandmorty.di;

import com.eugenebaturov.rickandmorty.app.RetrofitInstance;
import com.eugenebaturov.rickandmorty.utils.SchedulerProvider;
import com.eugenebaturov.rickandmorty.app.SchedulerProviderInstance;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Базовый модуль, который внедряет в компоненты общие зависимости.
 */
@Module
public final class AppModule {

    /**
     * Внедряет шедулеры {@link SchedulerProvider}.
     *
     * @return шедулеры
     */
    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return SchedulerProviderInstance.getInstance().getProvider();
    }

    /**
     * Внедряет ретрофит {@link Retrofit}.
     *
     * @return ретрофит.
     */
    @Provides
    Retrofit provideRetrofit() {
        return RetrofitInstance.getInstance().getRetrofit();
    }
}
