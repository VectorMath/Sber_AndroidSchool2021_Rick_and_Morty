package com.eugenebaturov.rickandmorty.data.db;

import androidx.annotation.NonNull;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.eugenebaturov.rickandmorty.models.domain.Character;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;

@Dao
public interface CharacterDao {

    @Insert
    Completable insertAll(List<Character> characters);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    Completable update(List<Character> characters);

    @Query("SELECT * FROM character_table")
    Single<List<Character>> getAll();

    @Query("SELECT * FROM character_table WHERE name = :query")
    Single<List<Character>> getCharactersByQuery(@NonNull final String query);

    @Query("SELECT * FROM character_table WHERE id = :characterId")
    Single<Character> getCharacterById(final int characterId);
}
