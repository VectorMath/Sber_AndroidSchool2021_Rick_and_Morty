package com.eugenebaturov.rickandmorty.app;

import com.eugenebaturov.rickandmorty.BuildConfig;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Класс-одиночка, который создаёт единичный экземпляр {@link Retrofit}.
 */
public final class RetrofitInstance {

    private static RetrofitInstance mInstance;
    private static Retrofit mRetrofitInstance;

    private RetrofitInstance() {
        mRetrofitInstance = new Retrofit
                .Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    /**
     * Получение единственного объекта нашего класса.
     *
     * @return объект класса {@link RetrofitInstance}.
     */
    public static RetrofitInstance getInstance() {
        if (mInstance == null)
            mInstance = new RetrofitInstance();

        return mInstance;
    }

    /**
     * Получить {@link Retrofit}.
     *
     * @return готовый ретрофит.
     */
    public Retrofit getRetrofit() {
        return mRetrofitInstance;
    }
}
