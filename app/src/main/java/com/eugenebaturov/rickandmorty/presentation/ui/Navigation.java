package com.eugenebaturov.rickandmorty.presentation.ui;

/**
 * Навигация по приложению.
 */
public interface Navigation {
    /**
     * Переход на страницу персонажа.
     *
     * @param characterId id персонажа.
     */
    void goToCharacter(final int characterId);

    /**
     * Переход на страницу эпизода.
     *
     * @param episodeId     id эпизода.
     * @param imageRecourse ресурс изображения.
     */
    void goToEpisode(final int episodeId, final int imageRecourse);

    /**
     * Переход на страницу локации.
     *
     * @param locationId id локации.
     */
    void goToLocation(final int locationId);
}
