package com.eugenebaturov.rickandmorty.models.data;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Objects;

/**
 * Класс-сущность, который хранит информацию об эпизоде мульт-сериала "Рик и Морти".
 */
public final class EpisodeResponse {

    @SerializedName("id")
    private final int mId;

    @SerializedName("name")
    @NonNull
    private final String mTitle;

    @SerializedName("air_date")
    @NonNull
    private final String mAirDate;

    @SerializedName("episode")
    @NonNull
    private final String mEpisodeNumber;

    @SerializedName("characters")
    @NonNull
    private final List<String> mCharacters;

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
