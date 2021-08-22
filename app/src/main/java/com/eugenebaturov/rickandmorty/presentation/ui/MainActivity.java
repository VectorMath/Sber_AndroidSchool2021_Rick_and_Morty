package com.eugenebaturov.rickandmorty.presentation.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.eugenebaturov.rickandmorty.R;
import com.eugenebaturov.rickandmorty.data.api.RickAndMortyURL;
import com.eugenebaturov.rickandmorty.data.repository.character.CharacterRepository;
import com.eugenebaturov.rickandmorty.data.repository.character.ICharacterRepository;
import com.eugenebaturov.rickandmorty.domain.interactor.character.CharacterInteractor;
import com.eugenebaturov.rickandmorty.domain.interactor.character.CharacterInteractorImpl;

import java.io.IOException;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    Thread thread;
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            Retrofit retrofit = new Retrofit.Builder().baseUrl(RickAndMortyURL.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

            ICharacterRepository repository = new CharacterRepository(retrofit);
            CharacterInteractor characterInteractor = new CharacterInteractorImpl(repository);

            try {
                Log.d("ttest", characterInteractor.getCharactersFromRepository().toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        thread = new Thread(runnable);
        thread.start();
    }
}