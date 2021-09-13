package com.eugenebaturov.rickandmorty.app;

import com.eugenebaturov.rickandmorty.utils.SchedulerProvider;
import com.eugenebaturov.rickandmorty.utils.SchedulerProviderImpl;

import retrofit2.Retrofit;

/**
 * Класс-одиночка, который создаёт единичный экземпляр {@link SchedulerProvider}.
 */
public final class SchedulerProviderInstance {
    private static SchedulerProviderInstance mInstance;
    private static SchedulerProvider mSchedulerProvider;

    private SchedulerProviderInstance() {
        mSchedulerProvider = new SchedulerProviderImpl();
    }

    /**
     * Получение единственного объекта нашего класса.
     *
     * @return объект класса {@link SchedulerProviderInstance}.
     */
    public static SchedulerProviderInstance getInstance() {
        if (mInstance == null)
            mInstance = new SchedulerProviderInstance();

        return mInstance;
    }

    /**
     * Получить {@link Retrofit}.
     *
     * @return готовый ретрофит.
     */
    public SchedulerProvider getProvider() {
        return mSchedulerProvider;
    }
}
