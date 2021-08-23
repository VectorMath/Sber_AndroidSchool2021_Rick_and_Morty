package com.eugenebaturov.rickandmorty.models.domain;

import com.eugenebaturov.rickandmorty.models.data.EpisodeResponse;

import java.util.List;
import java.util.Objects;

/**
 * Класс-сущность, которая обрабатывает данные из класса-сущности
 * {@link EpisodeResponse} в data-слое
 */
public class Episode {
    private final int mId;
    private final String mTitle;
    private final String mAirDate;
    private final String mEpisodeNumber;
    private final List<String> mCharacters;

    /**
     * Конструктор класса
     *
     * @param episodeResponse - моделька, которая получила данные с api.
     */
    public Episode(EpisodeResponse episodeResponse) {
        mId = episodeResponse.getId();
        mTitle = episodeResponse.getTitle();
        mAirDate = episodeResponse.getAirDate();
        mEpisodeNumber = episodeResponse.getEpisodeNumber();
        mCharacters = episodeResponse.getCharacters();
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
                Objects.equals(mCharacters, episode.mCharacters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mId, mTitle, mAirDate, mEpisodeNumber, mCharacters);
    }

    @Override
    public String toString() {
        return "Episode{" +
                "mId=" + mId +
                ", mTitle='" + mTitle + '\'' +
                ", mAirDate='" + mAirDate + '\'' +
                ", mEpisodeNumber='" + mEpisodeNumber + '\'' +
                ", mCharacters=" + mCharacters +
                '}';
    }

    public int getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getAirDate() {
        return mAirDate;
    }

    public String getEpisodeNumber() {
        return mEpisodeNumber;
    }

    public List<String> getCharacters() {
        return mCharacters;
    }
}
