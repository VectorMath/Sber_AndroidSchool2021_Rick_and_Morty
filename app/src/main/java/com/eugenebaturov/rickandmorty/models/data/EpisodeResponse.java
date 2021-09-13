package com.eugenebaturov.rickandmorty.models.data;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;

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
    private final List<String> mCharactersUrl;

    /**
     * Конструктор класса в который передается вся информация об эпизоде, пришедшая из сервера.
     *
     * @param id            id эпизода.
     * @param title         название эпизода.
     * @param airDate       дата выпуска эпизода(пример: September 10, 2017).
     * @param episodeNumber номер эпизода(пример: S03E07).
     * @param charactersUrl ссылка на персонажей, которые появились в эпизоде.
     */
    @VisibleForTesting
    public EpisodeResponse(
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
        EpisodeResponse episodeResponse = (EpisodeResponse) o;
        return mId == episodeResponse.mId &&
                Objects.equals(mTitle, episodeResponse.mTitle) &&
                Objects.equals(mAirDate, episodeResponse.mAirDate) &&
                Objects.equals(mEpisodeNumber, episodeResponse.mEpisodeNumber) &&
                Objects.equals(mCharactersUrl, episodeResponse.mCharactersUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                mId,
                mTitle,
                mAirDate,
                mEpisodeNumber,
                mCharactersUrl
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
                ", mCharacters=" + mCharactersUrl +
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
