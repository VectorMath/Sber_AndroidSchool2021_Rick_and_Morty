package com.eugenebaturov.rickandmorty.presentation.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.eugenebaturov.rickandmorty.R;
import com.eugenebaturov.rickandmorty.data.api.RickAndMortyURL;
import com.eugenebaturov.rickandmorty.data.repository.character.CharacterRepositoryImpl;
import com.eugenebaturov.rickandmorty.data.repository.character.CharacterRepository;
import com.eugenebaturov.rickandmorty.data.repository.location.LocationRepository;
import com.eugenebaturov.rickandmorty.data.repository.location.LocationRepositoryImpl;
import com.eugenebaturov.rickandmorty.domain.interactor.character.CharacterInteractor;
import com.eugenebaturov.rickandmorty.domain.interactor.character.CharacterInteractorImpl;
import com.eugenebaturov.rickandmorty.domain.interactor.location.LocationInteractor;
import com.eugenebaturov.rickandmorty.domain.interactor.location.LocationInteractorImpl;

import java.io.IOException;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}