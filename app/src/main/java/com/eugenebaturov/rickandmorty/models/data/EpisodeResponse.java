package com.eugenebaturov.rickandmorty.models.data;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

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
public final class EpisodeResponse {

    @SerializedName("id")
    private int mId;

    @SerializedName("name")
    @Nullable
    private String mTitle;

    @SerializedName("air_date")
    @Nullable
    private String mAirDate;

    @SerializedName("episode")
    @Nullable
    private String mEpisodeNumber;

    @SerializedName("characters")
    @Nullable
    private List<String> mCharacters;

    /**
     * Пустой конструктор класса.
     */
    public EpisodeResponse() {

    }

    /**
     * Конструктор класса в который передается вся информация об эпизоде, пришедшая из сервера.
     *
     * @param mId            id эпизода.
     * @param mTitle         название эпизода.
     * @param mAirDate       дата выпуска эпизода(пример: September 10, 2017).
     * @param mEpisodeNumber номер эпизода(пример: S03E07).
     * @param mCharacters    ссылка на персонажей, которые появились в эпизоде.
     */
    public EpisodeResponse(
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
