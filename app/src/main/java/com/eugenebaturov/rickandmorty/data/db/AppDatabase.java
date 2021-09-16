package com.eugenebaturov.rickandmorty.data.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.eugenebaturov.rickandmorty.data.converter.ListConverter;
import com.eugenebaturov.rickandmorty.models.domain.Character;


@Database(entities = {Character.class}, version = 1)
@TypeConverters({ListConverter.class})
public abstract class AppDatabase extends RoomDatabase {
    public abstract CharacterDao characterDao();
}
