package com.eugenebaturov.rickandmorty.domain.interactor.character;

import com.eugenebaturov.rickandmorty.data.entity.CharacterRequest;

import java.io.IOException;
import java.util.List;

public interface CharacterInteractor {

    List<CharacterRequest> getCharactersFromRepository() throws IOException;

    CharacterRequest getCharacterByIdFromRepository(int characterId) throws IOException;
}
