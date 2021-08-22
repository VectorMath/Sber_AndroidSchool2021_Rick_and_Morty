package com.eugenebaturov.rickandmorty.domain.interactor.character;

import com.eugenebaturov.rickandmorty.domain.entity.Character;

import java.io.IOException;
import java.util.List;

public interface CharacterInteractor {

    List<Character> getCharactersFromRepository() throws IOException;

    Character getCharacterByIdFromRepository(int characterId) throws IOException;
}
