package com.eugenebaturov.rickandmorty.models.domain;

import androidx.annotation.NonNull;

import com.eugenebaturov.rickandmorty.models.data.EpisodeResponse;

import java.util.List;
import java.util.Objects;

/**
 * Класс-сущность, которая обрабатывает данные из класса-сущности
 * {@link EpisodeResponse} в data-слое
 */
public final class Episode {
    private final int mId;
    @NonNull
    private final String mTitle;
    @NonNull
    private final String mAirDate;
    @NonNull
    private final String mEpisodeNumber;
    @NonNull
    private final List<String> mCharactersUrl;

    /**
     * Конструктор класса в который мы передаём всю информацию об эпизоде вручную.
     *
     * @param id            id эпизода.
     * @param title         название эпизода.
     * @param airDate       дата выпуска эпизода(пример: September 10, 2017).
     * @param episodeNumber номер эпизода(пример: S03E07).
     * @param charactersUrl ссылка на персонажей, которые появились в эпизоде.
     */
    public Episode(
            final int id,
            @NonNull final String title,
            @NonNull final String airDate,
            @NonNull final String episodeNumber,
            @NonNull final List<String> charactersUrl) {
        mId = id;
        mTitle = title;
        mAirDate = airDate;
        mEpisodeNumber = episodeNumber;
        mCharactersUrl = charactersUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Episode episode = (Episode) o;
        return mId == episode.mId &&
                Objects.equals(mTitle, episode.mTitle) &&
                Objects.equals(mAirDate, episode.mAirDate) &&
                Objects.equals(mEpisodeNumber, episode.mEpisodeNumber) &&
                Objects.equals(mCharactersUrl, episode.mCharactersUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mId, mTitle, mAirDate, mEpisodeNumber, mCharactersUrl);
    }

    @Override
    @NonNull
    public String toString() {
        return "Episode{" +
                "mId=" + mId +
                ", mTitle='" + mTitle + '\'' +
                ", mAirDate='" + mAirDate + '\'' +
                ", mEpisodeNumber='" + mEpisodeNumber + '\'' +
                ", mCharactersUrl=" + mCharactersUrl +
                '}';
    }

    /**
     * Получить id эпизода.
     *
     * @return id эпизода.
     */
    public int getId() {
        return mId;
    }

    /**
     * Получить название эпизода.
     *
     * @return название эпизода.
     */
    @NonNull
    public String getTitle() {
        return mTitle;
    }

    /**
     * Получить дата выхода эпизода.
     *
     * @return дата выхода эпизода.
     */
    @NonNull
    public String getAirDate() {
        return mAirDate;
    }

    /**
     * Получить номер эпизода.
     *
     * @return номер эпизода.
     */
    @NonNull
    public String getEpisodeNumber() {
        return mEpisodeNumber;
    }

    /**
     * Получить список url персонажей, которые были в этом эпизоде.
     *
     * @return url-список персонажей.
     */
    @NonNull
    public List<String> getCharacters() {
        return mCharactersUrl;
    }
}
