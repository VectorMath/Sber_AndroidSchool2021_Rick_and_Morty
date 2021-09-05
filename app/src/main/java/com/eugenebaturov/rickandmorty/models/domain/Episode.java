package com.eugenebaturov.rickandmorty.models.domain;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.eugenebaturov.rickandmorty.models.data.EpisodeResponse;

import java.util.List;
import java.util.Objects;

/**
 * Класс-сущность, которая обрабатывает данные из класса-сущности
 * {@link EpisodeResponse} в data-слое
 */
public final class Episode {
    private final int mId;
    @Nullable
    private final String mTitle;
    @Nullable
    private final String mAirDate;
    @Nullable
    private final String mEpisodeNumber;
    @Nullable
    private final List<String> mCharacters;

    /**
     * Конструктор класса
     *
     * @param episodeResponse - моделька, которая получила данные с api.
     */
    public Episode(@NonNull final EpisodeResponse episodeResponse) {
        mId = episodeResponse.getId();
        mTitle = episodeResponse.getTitle();
        mAirDate = episodeResponse.getAirDate();
        mEpisodeNumber = episodeResponse.getEpisodeNumber();
        mCharacters = episodeResponse.getCharacters();
    }

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
            @Nullable final String mTitle,
            @Nullable final String mAirDate,
            @Nullable final String mEpisodeNumber,
            @Nullable final List<String> mCharacters) {
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
