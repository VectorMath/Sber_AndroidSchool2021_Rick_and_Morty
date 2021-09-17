package com.eugenebaturov.rickandmorty.data.repository.character;

import androidx.annotation.NonNull;

import com.eugenebaturov.rickandmorty.data.api.CharacterApi;
import com.eugenebaturov.rickandmorty.data.converter.Converter;
import com.eugenebaturov.rickandmorty.data.converter.character.CharacterConverter;
import com.eugenebaturov.rickandmorty.data.converter.character.CharactersConverter;
import com.eugenebaturov.rickandmorty.data.db.CharacterDao;
import com.eugenebaturov.rickandmorty.models.data.CharacterResponse;
import com.eugenebaturov.rickandmorty.models.data.list.ListCharacterResponse;
import com.eugenebaturov.rickandmorty.models.domain.Character;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

/**
 * Реализация {@link CharacterRepository}.
 */
public final class CharacterRepositoryImpl implements CharacterRepository {

    @NonNull
    private final CharacterApi mCharacterApi;

    @NonNull
    private final CharacterDao mCharacterDao;

    /**
     * Конструктор класса.
     *
     * @param characterApi экземпляр {@link CharacterApi}.
     */
    public CharacterRepositoryImpl(@NonNull final CharacterApi characterApi,
                                   @NonNull final CharacterDao characterDao) {
        mCharacterApi = characterApi;
        mCharacterDao = characterDao;
    }

    @Override
    public @NonNull
    Single<List<Character>> getCharacters() {
        final Converter<ListCharacterResponse, List<Character>> mConverter
                = new CharactersConverter();

        return mCharacterApi.getCharacters().map(mConverter::convert);
    }

    @Override
    public @NonNull
    Single<List<Character>> getCharacters(@NonNull final String query) {
        final Converter<ListCharacterResponse, List<Character>> mConverter
                = new CharactersConverter();
        return mCharacterApi.getCharacters(query).map(mConverter::convert);
    }

    @Override
    public @NonNull
    Single<Character> getCharacterById(final int characterId) {
        final Converter<CharacterResponse, Character> mConverter
                = new CharacterConverter();
        return mCharacterApi.getCharacterById(characterId).map(mConverter::convert);
    }
}