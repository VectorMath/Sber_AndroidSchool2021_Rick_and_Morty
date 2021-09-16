package com.eugenebaturov.rickandmorty.testdata;

import com.eugenebaturov.rickandmorty.R;
import com.eugenebaturov.rickandmorty.models.data.CharacterResponse;
import com.eugenebaturov.rickandmorty.models.data.CurrentLocation;
import com.eugenebaturov.rickandmorty.models.data.Origin;
import com.eugenebaturov.rickandmorty.models.data.list.ListCharacterResponse;
import com.eugenebaturov.rickandmorty.models.domain.Character;

import java.util.ArrayList;
import java.util.List;

/**
 * Создаёт тестовые данные о персонаже/персонажах для unit-тестов.
 */
public final class CharacterTestData {

    public static CharacterResponse createResponse() {
        Origin firstTestOrigin = new Origin(
                "Earth (C-137)",
                "https://rickandmortyapi.com/api/location/1");
        CurrentLocation firstTestCurrentLocation = new CurrentLocation(
                "Earth (Replacement Dimension)",
                "https://rickandmortyapi.com/api/location/20");
        List<String> firstTestEpisodesUrl = new ArrayList<>();
        firstTestEpisodesUrl.add("https://rickandmortyapi.com/api/episode/20");
        firstTestEpisodesUrl.add("https://rickandmortyapi.com/api/episode/16");
        firstTestEpisodesUrl.add("https://rickandmortyapi.com/api/episode/5");

        return new CharacterResponse(
                1,
                "Rick Sanchez",
                "Alive",
                "Human",
                "Scientist",
                "Male",
                "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
                firstTestOrigin,
                firstTestCurrentLocation,
                firstTestEpisodesUrl
        );
    }

    public static ListCharacterResponse createSearchedResponse() {
        List<CharacterResponse> charactersResponses = new ArrayList<>();

        Origin firstTestOrigin = new Origin(
                "Earth (C-137)",
                "https://rickandmortyapi.com/api/location/1");
        CurrentLocation firstTestCurrentLocation = new CurrentLocation(
                "Earth (Replacement Dimension)",
                "https://rickandmortyapi.com/api/location/20");
        List<String> firstTestEpisodesUrl = new ArrayList<>();
        firstTestEpisodesUrl.add("https://rickandmortyapi.com/api/episode/20");
        firstTestEpisodesUrl.add("https://rickandmortyapi.com/api/episode/16");
        firstTestEpisodesUrl.add("https://rickandmortyapi.com/api/episode/5");

        charactersResponses.add(new CharacterResponse(
                1,
                "Rick Sanchez",
                "Alive",
                "Human",
                "Scientist",
                "Male",
                "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
                firstTestOrigin,
                firstTestCurrentLocation,
                firstTestEpisodesUrl
        ));

        Origin secondTestOrigin = new Origin(
                "Earth (C-137)",
                "https://rickandmortyapi.com/api/location/1");
        CurrentLocation secondTestCurrentLocation = new CurrentLocation(
                "Earth (Replacement Dimension)",
                "https://rickandmortyapi.com/api/location/20");
        List<String> secondTestEpisodesUrl = new ArrayList<>();
        secondTestEpisodesUrl.add("https://rickandmortyapi.com/api/episode/4");
        secondTestEpisodesUrl.add("https://rickandmortyapi.com/api/episode/10");
        secondTestEpisodesUrl.add("https://rickandmortyapi.com/api/episode/17");

        charactersResponses.add(new CharacterResponse(
                23,
                "Old Rick Sanchez",
                "Alive",
                "Human",
                "Faggot",
                "Male",
                "https://rickandmortyapi.com/api/character/avatar/23.jpeg",
                secondTestOrigin,
                secondTestCurrentLocation,
                secondTestEpisodesUrl
        ));


        return new ListCharacterResponse(charactersResponses);
    }

    public static List<Character> createSearchedCharacter() {
        List<Character> characters = new ArrayList<>();

        Origin firstTestOrigin = new Origin(
                "Earth (C-137)",
                "https://rickandmortyapi.com/api/location/1");
        CurrentLocation firstTestCurrentLocation = new CurrentLocation(
                "Earth (Replacement Dimension)",
                "https://rickandmortyapi.com/api/location/20");
        List<String> firstTestEpisodesUrl = new ArrayList<>();
        firstTestEpisodesUrl.add("https://rickandmortyapi.com/api/episode/20");
        firstTestEpisodesUrl.add("https://rickandmortyapi.com/api/episode/16");
        firstTestEpisodesUrl.add("https://rickandmortyapi.com/api/episode/5");

        characters.add(new Character(
                1,
                "Rick Sanchez",
                "Alive",
                R.drawable.ic_status_alive,
                "Human",
                "Scientist",
                "Male",
                "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
                firstTestOrigin,
                1,
                firstTestCurrentLocation,
                20,
                firstTestEpisodesUrl
        ));

        Origin secondTestOrigin = new Origin(
                "Earth (C-137)",
                "https://rickandmortyapi.com/api/location/1");
        CurrentLocation secondTestCurrentLocation = new CurrentLocation(
                "Earth (Replacement Dimension)",
                "https://rickandmortyapi.com/api/location/20");
        List<String> secondTestEpisodesUrl = new ArrayList<>();
        secondTestEpisodesUrl.add("https://rickandmortyapi.com/api/episode/4");
        secondTestEpisodesUrl.add("https://rickandmortyapi.com/api/episode/10");
        secondTestEpisodesUrl.add("https://rickandmortyapi.com/api/episode/17");

        characters.add(new Character(
                23,
                "Old Rick Sanchez",
                "Alive",
                R.drawable.ic_status_alive,
                "Human",
                "Faggot",
                "Male",
                "https://rickandmortyapi.com/api/character/avatar/23.jpeg",
                secondTestOrigin,
                1,
                secondTestCurrentLocation,
                20,
                secondTestEpisodesUrl
        ));


        return characters;
    }

    public static ListCharacterResponse createListResponse() {
        List<CharacterResponse> charactersResponses = new ArrayList<>();

        Origin firstTestOrigin = new Origin(
                "Earth (C-137)",
                "https://rickandmortyapi.com/api/location/1");
        CurrentLocation firstTestCurrentLocation = new CurrentLocation(
                "Earth (Replacement Dimension)",
                "https://rickandmortyapi.com/api/location/20");
        List<String> firstTestEpisodesUrl = new ArrayList<>();
        firstTestEpisodesUrl.add("https://rickandmortyapi.com/api/episode/20");
        firstTestEpisodesUrl.add("https://rickandmortyapi.com/api/episode/16");
        firstTestEpisodesUrl.add("https://rickandmortyapi.com/api/episode/5");

        charactersResponses.add(new CharacterResponse(
                1,
                "Rick Sanchez",
                "Alive",
                "Human",
                "Scientist",
                "Male",
                "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
                firstTestOrigin,
                firstTestCurrentLocation,
                firstTestEpisodesUrl
        ));

        Origin secondTestOrigin = new Origin(
                "Earth (C-137)",
                "https://rickandmortyapi.com/api/location/1");
        CurrentLocation secondTestCurrentLocation = new CurrentLocation(
                "Earth (Replacement Dimension)",
                "https://rickandmortyapi.com/api/location/20");
        List<String> secondTestEpisodesUrl = new ArrayList<>();
        secondTestEpisodesUrl.add("https://rickandmortyapi.com/api/episode/4");
        secondTestEpisodesUrl.add("https://rickandmortyapi.com/api/episode/10");
        secondTestEpisodesUrl.add("https://rickandmortyapi.com/api/episode/17");

        charactersResponses.add(new CharacterResponse(
                2,
                "Morty Smith",
                "Alive",
                "Human",
                "Faggot",
                "Male",
                "https://rickandmortyapi.com/api/character/avatar/2.jpeg",
                secondTestOrigin,
                secondTestCurrentLocation,
                secondTestEpisodesUrl
        ));


        return new ListCharacterResponse(charactersResponses);
    }

    public static Character createCharacter() {
        Origin testOrigin = new Origin(
                "Earth (C-137)",
                "https://rickandmortyapi.com/api/location/1");
        CurrentLocation testCurrentLocation = new CurrentLocation(
                "Earth (Replacement Dimension)",
                "https://rickandmortyapi.com/api/location/20");
        List<String> testEpisodesUrl = new ArrayList<>();
        testEpisodesUrl.add("https://rickandmortyapi.com/api/episode/20");
        testEpisodesUrl.add("https://rickandmortyapi.com/api/episode/16");
        testEpisodesUrl.add("https://rickandmortyapi.com/api/episode/5");

        return new Character(
                1,
                "Rick Sanchez",
                "Alive",
                R.drawable.ic_status_alive,
                "Human",
                "Scientist",
                "Male",
                "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
                testOrigin,
                1,
                testCurrentLocation,
                20,
                testEpisodesUrl
        );
    }

    public static List<Character> createListCharacter() {
        List<Character> characters = new ArrayList<>();

        Origin firstOrigin = new Origin(
                "Earth (C-137)",
                "https://rickandmortyapi.com/api/location/1");
        CurrentLocation firstCurrentLocation = new CurrentLocation(
                "Earth (Replacement Dimension)",
                "https://rickandmortyapi.com/api/location/20");
        List<String> firstEpisodesUrl = new ArrayList<>();
        firstEpisodesUrl.add("https://rickandmortyapi.com/api/episode/20");
        firstEpisodesUrl.add("https://rickandmortyapi.com/api/episode/16");
        firstEpisodesUrl.add("https://rickandmortyapi.com/api/episode/5");

        Character firstCharacter = new Character(
                1,
                "Rick Sanchez",
                "Alive",
                R.drawable.ic_status_alive,
                "Human",
                "Scientist",
                "Male",
                "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
                firstOrigin,
                1,
                firstCurrentLocation,
                20,
                firstEpisodesUrl
        );

        Origin secondOrigin = new Origin(
                "Earth (C-137)",
                "https://rickandmortyapi.com/api/location/1");
        CurrentLocation secondCurrentLocation = new CurrentLocation(
                "Earth (Replacement Dimension)",
                "https://rickandmortyapi.com/api/location/20");
        List<String> secondEpisodesUrl = new ArrayList<>();
        secondEpisodesUrl.add("https://rickandmortyapi.com/api/episode/4");
        secondEpisodesUrl.add("https://rickandmortyapi.com/api/episode/10");
        secondEpisodesUrl.add("https://rickandmortyapi.com/api/episode/17");

        Character secondCharacter = new Character(
                2,
                "Morty Smith",
                "Alive",
                R.drawable.ic_status_alive,
                "Human",
                "Faggot",
                "Male",
                "https://rickandmortyapi.com/api/character/avatar/2.jpeg",
                secondOrigin,
                1,
                secondCurrentLocation,
                20,
                secondEpisodesUrl
        );

        characters.add(firstCharacter);
        characters.add(secondCharacter);
        return characters;
    }
}
