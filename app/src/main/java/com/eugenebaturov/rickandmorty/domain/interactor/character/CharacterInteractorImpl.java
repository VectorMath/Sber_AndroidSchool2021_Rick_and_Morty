package com.eugenebaturov.rickandmorty.domain.interactor.character;

import com.eugenebaturov.rickandmorty.data.repository.character.ICharacterRepository;
import com.eugenebaturov.rickandmorty.domain.entity.Character;

import java.io.IOException;
import java.util.List;

public class CharacterInteractorImpl implements CharacterInteractor {

    private final ICharacterRepository mRepository;

    public CharacterInteractorImpl(ICharacterRepository repository) {
        mRepository = repository;
    }
    @Override
    public List<Character> getCharactersFromRepository() throws IOException {
        return mRepository.getAllCharacters().execute().body();
    }

    @Override
    public Character getCharacterByIdFromRepository(int characterId) throws IOException {
        return mRepository.getCharacterById(characterId).execute().body();
    }
}
