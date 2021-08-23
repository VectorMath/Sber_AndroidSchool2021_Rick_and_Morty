package com.eugenebaturov.rickandmorty.models.data;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Objects;

/**
 * Класс-сущность, который хранит информацию об эпизоде мульт-сериала "Рик и Морти".
 * <p>
 * [mId] - id эпизода.
 * <p>
 * [mTitle] - название эпизода.
 * <p>
 * [mAirDate] - дата выпуска эпизода(пример: September 10, 2017).
 * <p>
 * [mEpisodeCount] - номер эпизода(пример: S03E07).
 * <p>
 * [mCharacters] - ссылка на персонажей, которые появились в эпизоде.
 */
public class EpisodeResponse {

    @SerializedName("id")
    private int mId;

    @SerializedName("name")
    private String mTitle;

    @SerializedName("air_date")
    private String mAirDate;

    @SerializedName("episode")
    private String mEpisodeNumber;

    @SerializedName("characters")
    private List<String> mCharacters;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EpisodeResponse episodeResponse = (EpisodeResponse) o;
        return mId == episodeResponse.mId &&
                Objects.equals(mTitle, episodeResponse.mTitle) &&
                Objects.equals(mAirDate, episodeResponse.mAirDate) &&
                Objects.equals(mEpisodeNumber, episodeResponse.mEpisodeNumber) &&
                Objects.equals(mCharacters, episodeResponse.mCharacters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                mId,
                mTitle,
                mAirDate,
                mEpisodeNumber,
                mCharacters
        );
    }

    @NonNull
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
