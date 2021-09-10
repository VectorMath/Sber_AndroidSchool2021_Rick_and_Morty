package com.eugenebaturov.rickandmorty.di;

import com.eugenebaturov.rickandmorty.data.api.RickAndMortyURL;
import com.eugenebaturov.rickandmorty.utils.SchedulerProvider;
import com.eugenebaturov.rickandmorty.utils.SchedulerProviderImpl;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

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
        return new SchedulerProviderImpl();
    }

    /**
     * Внедряет ретрофит {@link Retrofit}.
     *
     * @return ретрофит.
     */
    @Provides
    Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(RickAndMortyURL.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();
    }
}
