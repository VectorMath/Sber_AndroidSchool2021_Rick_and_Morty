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
    private final List<String> mCharacters;

    /**
     * Конструктор класса в который мы передаём всю информацию об эпизоде вручную.
     *
     * @param mId            id эпизода.
     * @param mTitle         название эпизода.
     * @param mAirDate       дата выпуска эпизода(пример: September 10, 2017).
     * @param mEpisodeNumber номер эпизода(пример: S03E07).
     * @param mCharacters    ссылка на персонажей, которые появились в эпизоде.
     */
    public Episode(
            final int mId,
            @NonNull final String mTitle,
            @NonNull final String mAirDate,
            @NonNull final String mEpisodeNumber,
            @NonNull final List<String> mCharacters) {
        this.mId = mId;
        this.mTitle = mTitle;
        this.mAirDate = mAirDate;
        this.mEpisodeNumber = mEpisodeNumber;
        this.mCharacters = mCharacters;
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
    @NonNull
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

    @NonNull
    public String getTitle() {
        return mTitle;
    }

    @NonNull
    public String getAirDate() {
        return mAirDate;
    }

    @NonNull
    public String getEpisodeNumber() {
        return mEpisodeNumber;
    }

    @NonNull
    public List<String> getCharacters() {
        return mCharacters;
    }
}
