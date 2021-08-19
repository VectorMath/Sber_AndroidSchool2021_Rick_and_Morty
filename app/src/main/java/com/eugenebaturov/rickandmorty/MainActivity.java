package com.eugenebaturov.rickandmorty;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.eugenebaturov.rickandmorty.data.api.RickAndMortyURL;
import com.eugenebaturov.rickandmorty.data.repository.CharacterRepository;
import com.eugenebaturov.rickandmorty.data.repository.EpisodeRepository;
import com.eugenebaturov.rickandmorty.data.repository.LocationRepository;
import com.eugenebaturov.rickandmorty.domain.entity.Character;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}