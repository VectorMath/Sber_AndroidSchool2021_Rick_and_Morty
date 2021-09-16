package com.eugenebaturov.rickandmorty.data.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.eugenebaturov.rickandmorty.models.domain.Character;

@Database(entities = {Character.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract CharacterDao characterDao();
}
