package com.eugenebaturov.rickandmorty.data.utils;

import androidx.annotation.NonNull;

import com.eugenebaturov.rickandmorty.models.data.CharacterResponse;
import com.eugenebaturov.rickandmorty.models.data.EpisodeResponse;
import com.eugenebaturov.rickandmorty.models.data.LocationResponse;
import com.eugenebaturov.rickandmorty.models.data.list.ListCharacterResponse;
import com.eugenebaturov.rickandmorty.models.data.list.ListEpisodeResponse;
import com.eugenebaturov.rickandmorty.models.data.list.ListLocationResponse;
import com.eugenebaturov.rickandmorty.models.domain.Character;
import com.eugenebaturov.rickandmorty.models.domain.Episode;
import com.eugenebaturov.rickandmorty.models.domain.Location;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс-конвертатор сущностей из data-слоя, в domain-слой.
 */
public final class Converter {

    /**
     * Конвертирует ответ из сервера в виде {@link ListCharacterResponse} в список {@link Character}.
     *
     * @param responses ответ от сервера в виде списка персонажей.
     * @return отконвертированный список персонажей.
     */
    public static List<Character> convertCharacters(@NonNull final ListCharacterResponse responses) {
        List<Character> characters = new ArrayList<>();

        for (CharacterResponse response : responses.getCharacters()) {
            Character character = new Character(
                    response.getId(),
                    response.getName(),
                    response.getStatus(),
                    response.getSpecies(),
                    response.getType(),
                    response.getGender(),
                    response.getImage(),
                    response.getOrigin(),
                    response.getCurrentLocation(),
                    response.getEpisodes()
            );
            characters.add(character);
        }

        return characters;
    }

    /**
     * Конвертирует ответ из сервера в виде {@link CharacterResponse} в {@link Character}.
     *
     * @param response ответ от сервера с информацией о персонаже.
     * @return отконвертированная информация о персонаже.
     */
    public static Character convertCharacter(@NonNull final CharacterResponse response) {
        return new Character(
                response.getId(),
                response.getName(),
                response.getStatus(),
                response.getSpecies(),
                response.getType(),
                response.getGender(),
                response.getImage(),
                response.getOrigin(),
                response.getCurrentLocation(),
                response.getEpisodes());
    }

    /**
     * Конвертирует ответ из сервера в виде {@link ListEpisodeResponse} в список {@link Episode}.
     *
     * @param responses ответ от сервера в виде списка эпизодов.
     * @return отконвертированный список эпизодов.
     */
    public static List<Episode> convertEpisodes(@NonNull final ListEpisodeResponse responses) {
        List<Episode> episodes = new ArrayList<>();

        for (EpisodeResponse response : responses.getEpisodes()) {
            Episode episode = new Episode(
                    response.getId(),
                    response.getTitle(),
                    response.getAirDate(),
                    response.getEpisodeNumber(),
                    response.getCharacters()
            );

            episodes.add(episode);
        }

        return episodes;
    }

    /**
     * Конвертирует ответ из сервера в виде {@link EpisodeResponse} в {@link Episode}.
     *
     * @param response ответ от сервера в виде информации об эпизоде.
     * @return отконвертированная информация об эпизоде.
     */
    public static Episode convertEpisode(@NonNull final EpisodeResponse response) {
        return new Episode(
                response.getId(),
                response.getTitle(),
                response.getAirDate(),
                response.getEpisodeNumber(),
                response.getCharacters());
    }

    /**
     * Конвертирует ответ из сервера в виде {@link ListLocationResponse} в список {@link Location}.
     *
     * @param responses ответ от сервера в виде списка локаций.
     * @return отконвертированный список локаций.
     */
    public static List<Location> convertLocations(@NonNull final ListLocationResponse responses) {
        List<Location> locations = new ArrayList<>();

        for (LocationResponse response : responses.getLocations()) {
            Location location = new Location(
                    response.getId(),
                    response.getName(),
                    response.getType(),
                    response.getDimension(),
                    response.getResidents()
            );
            locations.add(location);
        }

        return locations;
    }

    /**
     * Конвертирует ответ из сервера в виде {@link LocationResponse} в список {@link Location}.
     *
     * @param response ответ от сервера в виде информации об локации.
     * @return отконвертированная информация об локации.
     */
    public static Location convertLocation(@NonNull final LocationResponse response) {
        return new Location(
                response.getId(),
                response.getName(),
                response.getType(),
                response.getDimension(),
                response.getResidents()
        );
    }
}
