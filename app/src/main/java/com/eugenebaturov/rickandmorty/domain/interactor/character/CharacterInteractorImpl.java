package com.eugenebaturov.rickandmorty.domain.interactor.character;

import com.eugenebaturov.rickandmorty.models.data.CharacterRequest;
import com.eugenebaturov.rickandmorty.data.repository.character.CharacterRepository;
import com.eugenebaturov.rickandmorty.models.domain.Character;

import java.util.ArrayList;
import java.util.List;

/**
 * Реализация интерфейса {@link CharacterInteractor}
 */
public class CharacterInteractorImpl implements CharacterInteractor {

    private final CharacterRepository mRepository;

    /**
     * Конструктор класса.
     *
     * @param repository - экземпляр интерфейса-репозитория {@link CharacterRepository}
     */
    public CharacterInteractorImpl(CharacterRepository repository) {
        mRepository = repository;
    }

    @Override
    public List<Character> parseCharactersFromRepository() {
        List<CharacterRequest> request = mRepository
                .getAllCharacters()
                .blockingGet()
                .getCharacters();
        List<Character> characters = new ArrayList<>();

        for (CharacterRequest character : request) {
            characters.add(new Character(character));
        }

        return characters;
    }

    @Override
    public Character parseCharacterByIdFromRepository(int characterId) {
        CharacterRequest request = mRepository.getCharacterById(characterId).blockingGet();
        return new Character(request);
    }
}
