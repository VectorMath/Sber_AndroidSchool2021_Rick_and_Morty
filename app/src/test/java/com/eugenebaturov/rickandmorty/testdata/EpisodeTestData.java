package com.eugenebaturov.rickandmorty.testdata;

import com.eugenebaturov.rickandmorty.models.data.EpisodeResponse;
import com.eugenebaturov.rickandmorty.models.data.list.ListEpisodeResponse;
import com.eugenebaturov.rickandmorty.models.domain.Episode;

import java.util.ArrayList;
import java.util.List;

/**
 * Создаёт тестовые данные об эпизоде/эпизодах для unit-тестов.
 */
public final class EpisodeTestData {

    public static ListEpisodeResponse createListResponse() {
        List<EpisodeResponse> episodes = new ArrayList<>();

        List<String> firstEpisodeCharactersUrl = new ArrayList<>();
        firstEpisodeCharactersUrl.add("https://rickandmortyapi.com/api/character/1");
        firstEpisodeCharactersUrl.add("https://rickandmortyapi.com/api/character/2");
        firstEpisodeCharactersUrl.add("https://rickandmortyapi.com/api/character/35");
        EpisodeResponse firstEpisode = new EpisodeResponse(
                1,
                "Pilot",
                "December 2, 2013",
                "S01E01",
                firstEpisodeCharactersUrl
        );

        List<String> secondEpisodeCharactersUrl = new ArrayList<>();
        secondEpisodeCharactersUrl.add("https://rickandmortyapi.com/api/character/31");
        secondEpisodeCharactersUrl.add("https://rickandmortyapi.com/api/character/12");
        secondEpisodeCharactersUrl.add("https://rickandmortyapi.com/api/character/5");
        EpisodeResponse secondEpisode = new EpisodeResponse(
                2,
                "Lawnmower Dog",
                "December 9, 2013",
                "S01E02",
                secondEpisodeCharactersUrl
        );

        episodes.add(firstEpisode);
        episodes.add(secondEpisode);

        return new ListEpisodeResponse(episodes);
    }

    public static ListEpisodeResponse createSearchedResponse() {
        List<EpisodeResponse> episodes = new ArrayList<>();

        List<String> firstEpisodeCharactersUrl = new ArrayList<>();
        firstEpisodeCharactersUrl.add("https://rickandmortyapi.com/api/character/1");
        firstEpisodeCharactersUrl.add("https://rickandmortyapi.com/api/character/2");
        firstEpisodeCharactersUrl.add("https://rickandmortyapi.com/api/character/35");
        EpisodeResponse firstEpisode = new EpisodeResponse(
                3,
                "Last Day",
                "December 2, 2013",
                "S01E03",
                firstEpisodeCharactersUrl
        );

        List<String> secondEpisodeCharactersUrl = new ArrayList<>();
        secondEpisodeCharactersUrl.add("https://rickandmortyapi.com/api/character/31");
        secondEpisodeCharactersUrl.add("https://rickandmortyapi.com/api/character/12");
        secondEpisodeCharactersUrl.add("https://rickandmortyapi.com/api/character/5");
        EpisodeResponse secondEpisode = new EpisodeResponse(
                24,
                "Thanksgiving Day",
                "December 9, 2013",
                "S03E12",
                secondEpisodeCharactersUrl
        );

        episodes.add(firstEpisode);
        episodes.add(secondEpisode);

        return new ListEpisodeResponse(episodes);
    }

    public static List<Episode> createEpisodes() {
        List<Episode> episodes = new ArrayList<>();

        List<String> firstEpisodeCharactersUrl = new ArrayList<>();
        firstEpisodeCharactersUrl.add("https://rickandmortyapi.com/api/character/1");
        firstEpisodeCharactersUrl.add("https://rickandmortyapi.com/api/character/2");
        firstEpisodeCharactersUrl.add("https://rickandmortyapi.com/api/character/35");
        Episode firstEpisode = new Episode(
                1,
                "Pilot",
                "December 2, 2013",
                "S01E01",
                firstEpisodeCharactersUrl
        );

        List<String> secondEpisodeCharactersUrl = new ArrayList<>();
        secondEpisodeCharactersUrl.add("https://rickandmortyapi.com/api/character/31");
        secondEpisodeCharactersUrl.add("https://rickandmortyapi.com/api/character/12");
        secondEpisodeCharactersUrl.add("https://rickandmortyapi.com/api/character/5");
        Episode secondEpisode = new Episode(
                2,
                "Lawnmower Dog",
                "December 9, 2013",
                "S01E02",
                secondEpisodeCharactersUrl
        );

        episodes.add(firstEpisode);
        episodes.add(secondEpisode);

        return episodes;
    }

    public static List<Episode> createSearchedEpisodes() {
        List<Episode> episodes = new ArrayList<>();

        List<String> firstEpisodeCharactersUrl = new ArrayList<>();
        firstEpisodeCharactersUrl.add("https://rickandmortyapi.com/api/character/1");
        firstEpisodeCharactersUrl.add("https://rickandmortyapi.com/api/character/2");
        firstEpisodeCharactersUrl.add("https://rickandmortyapi.com/api/character/35");
        Episode firstEpisode = new Episode(
                3,
                "Last Day",
                "December 2, 2013",
                "S01E03",
                firstEpisodeCharactersUrl
        );

        List<String> secondEpisodeCharactersUrl = new ArrayList<>();
        secondEpisodeCharactersUrl.add("https://rickandmortyapi.com/api/character/31");
        secondEpisodeCharactersUrl.add("https://rickandmortyapi.com/api/character/12");
        secondEpisodeCharactersUrl.add("https://rickandmortyapi.com/api/character/5");
        Episode secondEpisode = new Episode(
                24,
                "Thanksgiving Day",
                "December 9, 2013",
                "S03E12",
                secondEpisodeCharactersUrl
        );

        episodes.add(firstEpisode);
        episodes.add(secondEpisode);

        return episodes;
    }

    public static EpisodeResponse createResponse() {
        List<String> testEpisodeCharactersUrl = new ArrayList<>();
        testEpisodeCharactersUrl.add("https://rickandmortyapi.com/api/character/1");
        testEpisodeCharactersUrl.add("https://rickandmortyapi.com/api/character/2");
        testEpisodeCharactersUrl.add("https://rickandmortyapi.com/api/character/35");
        return new EpisodeResponse(
                1,
                "Pilot",
                "December 2, 2013",
                "S01E01",
                testEpisodeCharactersUrl
        );
    }

    public static Episode createEpisode() {
        List<String> testEpisodeCharactersUrl = new ArrayList<>();
        testEpisodeCharactersUrl.add("https://rickandmortyapi.com/api/character/1");
        testEpisodeCharactersUrl.add("https://rickandmortyapi.com/api/character/2");
        testEpisodeCharactersUrl.add("https://rickandmortyapi.com/api/character/35");
        return new Episode(
                1,
                "Pilot",
                "December 2, 2013",
                "S01E01",
                testEpisodeCharactersUrl
        );
    }
}
